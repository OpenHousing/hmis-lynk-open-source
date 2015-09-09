/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Gender;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Client;
import com.servinglynk.hmis.warehouse.enums.ClientDobDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientEthnicityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientGenderEnum;
import com.servinglynk.hmis.warehouse.enums.ClientNameDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.enums.ClientSsnDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.ClientVeteranStatusEnum;
import com.servinglynk.hmis.warehouse.restful.model.AppRequest;
import com.servinglynk.hmis.warehouse.restful.model.AuthenticationRequest;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientDaoImpl extends ParentDaoImpl implements ClientDao {
	private static final String OPENEMPI_HOST = "http://localhost:8081/hmis-client-dedup/rest/api/v1/";

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
	
		Export export = domain.getExport();
		List<Client> clients = export.getClient();
		if (clients != null && clients.size() > 0) {
			for (Client client : clients) {
				com.servinglynk.hmis.warehouse.model.staging.Client clientModel = new com.servinglynk.hmis.warehouse.model.staging.Client();
				clientModel.setFirstName(client.getFirstName());
				clientModel.setDateCreated(BasicDataGenerator
						.getLocalDate(client.getDateCreated()));
				clientModel.setDob(BasicDataGenerator.getLocalDate(client
						.getDOB()));
				clientModel
						.setDobDataQuality(ClientDobDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getDOBDataQuality())));
				clientModel.setEthnicity(ClientEthnicityEnum
						.lookupEnum(String.valueOf(client.getEthnicity())));
				clientModel.setGender(ClientGenderEnum.lookupEnum(String
						.valueOf(client.getGender())));
				clientModel.setLastName(client.getLastName());
				clientModel.setMiddleName(client.getMiddleName());
				clientModel
						.setNameDataQuality(ClientNameDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getNameDataQuality())));
				clientModel.setNameSuffix(client.getNameSuffix());
				clientModel.setOtherGender(client.getOtherGender());
				clientModel.setRace(ClientRaceEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(client.getRace())));
				clientModel.setSsn(client.getSSN());
				clientModel
						.setSsnDataQuality(ClientSsnDataQualityEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getSSNDataQuality())));
				clientModel
						.setVeteranStatus(ClientVeteranStatusEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(client
												.getVeteranStatus())));
				UUID clientUUID = UUID.randomUUID();
				clientModel.setId(clientUUID);
				UUID exportId = domain.getExportId();
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, exportId);
				exportEntity.addClient(clientModel);
				clientModel.setExport(exportEntity);
				//Lets make a microservice all to the dedup micro service
				String dedupedId = getDedupedClient(clientModel);
				clientModel.setDedupClientId(UUID.fromString(dedupedId));
				insert(clientModel);
				domain.getClientPersonalIDMap().put(client.getPersonalID(), clientUUID);
			}
	}
	}
	

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Client> clients = export.getClients();
		if(clients !=null && !clients.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Client client : clients) {
				com.servinglynk.hmis.warehouse.model.live.Client target = new com.servinglynk.hmis.warehouse.model.live.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
				insert(target);
			}
		}
	}
	
	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Client client) {
			if(client !=null) {
				com.servinglynk.hmis.warehouse.model.live.Client target = new com.servinglynk.hmis.warehouse.model.live.Client();
				BeanUtils.copyProperties(client, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, client.getExport().getId());
				exportEntity.addClient(target);
				target.setExport(exportEntity);
				insert(target);
			}
	}
	
	private String getDedupedClient(com.servinglynk.hmis.warehouse.model.staging.Client client) {
		 	RestTemplate restTemplate = new RestTemplate();
	        String url = OPENEMPI_HOST+"authenticate";       
	        String requestBody = "{ \"AuthenticationRequest\": {\"username\":\"admin\",\"password\":\"admin\"} }";
	        AuthenticationRequest AuthenticationRequest = new AuthenticationRequest();
	        AuthenticationRequest.setPassword("admin");
	        AuthenticationRequest.setUsername("admin");
	        AppRequest request  = new AppRequest();
	        request.setAuthenticationRequest(AuthenticationRequest);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        HttpEntity<String> entity = new HttpEntity<String>(requestBody, headers); 
	        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
	        // check the response, e.g. Location header,  Status, and body
	        response.getHeaders().getLocation();
	        response.getStatusCode();
	        LinkedHashMap<String, String> responseBody = (LinkedHashMap<String, String>) response.getBody();        
	        //String sessionKey = (String) responseBody.entrySet().iterator().next();
	        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON); 
	        headers.set("OPENEMPI_SESSION_KEY", "A053E4E2D5D11E7F5BD969D1719D3A60");
	        url = OPENEMPI_HOST+"dedup";
	        Person person = new Person();
	        person.setGivenName(client.getFirstName());
	        person.setFamilyName(client.getLastName());
	        person.setSsn(client.getSsn());
	        if(client.getSsnDataQuality().getValue() !=null &&  !"1".equals(client.getSsnDataQuality().getValue())) {
	        	person.setCustom10(client.getSsnDataQuality().getValue() );	
	        }
	        java.util.Date dob = null;
			try {
				dob = new SimpleDateFormat("yyyy-MM-dd").parse(client.getDob().toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        person.setDateOfBirth(dob);
	        if(client.getGender() !=null) {
	        	Gender gender = new Gender();
	        	 gender.setGenderCode(client.getGender().getValue());
	   	        //gender.setGenderCd(genderCd);
	   	        person.setGender(gender);
	        }
	        requestBody = parsePersonObjectToXMLString(person);
	        HttpEntity<String> entityHttp = new HttpEntity<String>(requestBody, headers); 
	        ResponseEntity<Object> responseObject = restTemplate.exchange(url, HttpMethod.POST, entityHttp, Object.class);
	        LinkedHashMap<Object, Object> persons = (LinkedHashMap<Object, Object>) responseObject.getBody();
	        List<Person> finalPersons = new ArrayList<Person>();
	        if( persons.entrySet().size()  > 1) {
	        	List<LinkedHashMap<Object, Object>> abcPersons =   (ArrayList<LinkedHashMap<Object, Object>>) persons.get("Person");
	            for(LinkedHashMap<Object, Object> linkedPersons : abcPersons) {
	            	finalPersons.add(hydradePerson(linkedPersons));
	            }
	        }else if(persons.entrySet().size()  == 1){
	        	LinkedHashMap<Object, Object> abcPersons =   (LinkedHashMap<Object, Object>) persons.get("Person");
	        	finalPersons.add(hydradePerson(abcPersons));
	        }
	        return finalPersons.get(0).getCustom20();
	}
	
    private Person hydradePerson(LinkedHashMap<Object, Object> linkedPersons) {
    	Person person = new Person();
    	Long dob = (Long)linkedPersons.get("dateOfBirth");
    	if(dob !=null && !"".equals(dob)) {
    		//dob.substring(0, 9);
        	Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date;
            try {
                date = (Date)((DateFormat) formatter).parse(String.valueOf(dob));
                person.setDateOfBirth(date);
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                String s = formatter.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
    	}
		person.setSsn((String)linkedPersons.get("ssn"));
		person.setGivenName((String)linkedPersons.get("givenName"));
		person.setFamilyName((String)linkedPersons.get("familyName"));
		person.setCustom20((String)linkedPersons.get("custom20"));
		LinkedHashMap<Object, Object>  genderLinkedList = (LinkedHashMap<Object, Object>)linkedPersons.get("gender");
		Gender gender = new Gender();
		Integer genderCd = Integer.parseInt((String)genderLinkedList.get("genderCd"));
		gender.setGenderCd(genderCd);
		gender.setGenderCode((String)genderLinkedList.get("genderCode"));
		person.setGender(gender);
    	return person;
    }
    
    private String parsePersonObjectToXMLString(Person person) {
		String requestBody = "{ \"Person\": {";
		if(person.getSsn() !=null && !"".equals(person.getSsn())) {
			requestBody =requestBody+"\"ssn\": \"" +person.getSsn()+"\",";
		}
		if(person.getGivenName() !=null && !"".equals(person.getGivenName())) {
			requestBody = requestBody +"\"givenName\":  \""+person.getGivenName()+"\",";
		}
		if(person.getFamilyName() !=null && !"".equals(person.getFamilyName())) {
			requestBody = requestBody+ " \"familyName\":  \""+person.getFamilyName()+"\"";
		}
		if(person.getDateOfBirth() !=null)  {
			requestBody = requestBody+ " \"dateOfBirth\":  \""+ person.getDateOfBirth() + "\"";
		}
		requestBody = requestBody+"}}";
		System.out.println("Request Body"+requestBody);
		//logger.info("Request Body"+requestBody);
		return requestBody;	
	}
    
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}
    public static void main(String args[]) {
    	ClientDaoImpl impl = new ClientDaoImpl();
    	com.servinglynk.hmis.warehouse.model.staging.Client client = new com.servinglynk.hmis.warehouse.model.staging.Client();
    	client.setFirstName("John");
    	client.setLastName("Anderson");
    	client.setDob(LocalDate.of(1980, 01, 01));
    	client.setGender(ClientGenderEnum.ONE);
    	client.setSsn("111111111");
    	client.setSsnDataQuality(ClientSsnDataQualityEnum.EIGHT);
    	String abc = impl.getDedupedClient(client);
    	System.out.println("Identifier "+abc);
    }

}