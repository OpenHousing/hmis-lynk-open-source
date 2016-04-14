/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.YouthCriticalIssues;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class YouthcriticalissuesDaoImpl extends ParentDaoImpl implements
		YouthcriticalissuesDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<YouthCriticalIssues> youthCriticalIssuesList = domain.getExport().getYouthCriticalIssues();
		hydrateBulkUploadActivityStaging(youthCriticalIssuesList, com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class.getSimpleName(), domain);
		if(youthCriticalIssuesList !=null && !youthCriticalIssuesList.isEmpty())
		{
			for(YouthCriticalIssues youthCriticalIssues : youthCriticalIssuesList)
			{
				Youthcriticalissues youthcriticalissuesModel = new Youthcriticalissues();
				UUID id = UUID.randomUUID();
				youthcriticalissuesModel.setId(id);
				youthcriticalissuesModel.setDateCreated(LocalDateTime.now());
				youthcriticalissuesModel.setDateUpdated(LocalDateTime.now());
				youthcriticalissuesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateCreated()));
				youthcriticalissuesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(youthCriticalIssues.getDateUpdated()));
				youthcriticalissuesModel.setAbuseandneglectfam(YouthcriticalissuesAbuseandneglectfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectFam())));
				youthcriticalissuesModel.setAbuseandneglectyouth(YouthcriticalissuesAbuseandneglectyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAbuseAndNeglectYouth())));
				youthcriticalissuesModel.setActivemilitaryparent(YouthcriticalissuesActivemilitaryparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getActiveMilitaryParent())));
				youthcriticalissuesModel.setAlcoholdrugabusefam(YouthcriticalissuesAlcoholdrugabusefamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseFam())));
				youthcriticalissuesModel.setAlcoholdrugabuseyouth(YouthcriticalissuesAlcoholdrugabuseyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getAlcoholDrugAbuseYouth())));
				youthcriticalissuesModel.setHealthissuesfam(YouthcriticalissuesHealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesFam())));
				youthcriticalissuesModel.setHealthissuesyouth(YouthcriticalissuesHealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHealthIssuesYouth())));
				youthcriticalissuesModel.setHouseholddynamics(YouthcriticalissuesHouseholddynamicsEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHouseholdDynamics())));
				youthcriticalissuesModel.setHousingissuesfam(YouthcriticalissuesHousingissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesFam())));
				youthcriticalissuesModel.setHousingissuesyouth(YouthcriticalissuesHousingissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getHousingIssuesYouth())));
				youthcriticalissuesModel.setIncarceratedparent(YouthcriticalissuesIncarceratedparentEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParent())));
				youthcriticalissuesModel.setIncarceratedparentstatus(YouthcriticalissuesIncarceratedparentstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getIncarceratedParentStatus())));
				youthcriticalissuesModel.setInsufficientincome(YouthcriticalissuesInsufficientincomeEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getInsufficientIncome())));
				youthcriticalissuesModel.setMentaldisabilityfam(YouthcriticalissuesMentaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityFam())));
				youthcriticalissuesModel.setMentaldisabilityyouth(YouthcriticalissuesMentaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalDisabilityYouth())));
				youthcriticalissuesModel.setMentalhealthissuesfam(YouthcriticalissuesMentalhealthissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesFam())));
				youthcriticalissuesModel.setMentalhealthissuesyouth(YouthcriticalissuesMentalhealthissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getMentalHealthIssuesYouth())));
				youthcriticalissuesModel.setPhysicaldisabilityfam(YouthcriticalissuesPhysicaldisabilityfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityFam())));
				youthcriticalissuesModel.setPhysicaldisabilityyouth(YouthcriticalissuesPhysicaldisabilityyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getPhysicalDisabilityYouth())));
				youthcriticalissuesModel.setSchooleducationalissuesfam(YouthcriticalissuesSchooleducationalissuesfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesFam())));
				youthcriticalissuesModel.setSchooleducationalissuesyouth(YouthcriticalissuesSchooleducationalissuesyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSchoolEducationalIssuesYouth())));
				youthcriticalissuesModel.setSexualorientationgenderidfam(YouthcriticalissuesSexualorientationgenderidfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDFam())));
				youthcriticalissuesModel.setSexualorientationgenderidyouth(YouthcriticalissuesSexualorientationgenderidyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getSexualOrientationGenderIDYouth())));
				youthcriticalissuesModel.setUnemploymentfam(YouthcriticalissuesUnemploymentfamEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentFam())));
				youthcriticalissuesModel.setUnemploymentyouth(YouthcriticalissuesUnemploymentyouthEnum.lookupEnum(BasicDataGenerator.getStringValue(youthCriticalIssues.getUnemploymentYouth())));
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				youthcriticalissuesModel.setExport(exportEntity);
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(youthCriticalIssues.getProjectEntryID()));
				youthcriticalissuesModel.setEnrollmentid(enrollmentModel);
				exportEntity.addYouthcriticalissues(youthcriticalissuesModel);
				hydrateCommonFields(youthcriticalissuesModel, domain, youthCriticalIssues.getYouthCriticalIssuesID());
				insertOrUpdate(youthcriticalissuesModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Youthcriticalissues> youthcriticalissueses = export.getYouthcriticalissueses();
		hydrateBulkUploadActivity(youthcriticalissueses, com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class.getSimpleName(), export,id);
		if(youthcriticalissueses !=null && !youthcriticalissueses.isEmpty()) {
			for(Youthcriticalissues youthcriticalissues : youthcriticalissueses) {
				if(youthcriticalissues != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues target = new com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues();
					BeanUtils.copyProperties(youthcriticalissues, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, youthcriticalissues.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addYouthcriticalissues(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues createYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       youthCriticalIssues.setId(UUID.randomUUID()); 
	       insert(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues updateYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       update(youthCriticalIssues);
	       return youthCriticalIssues;
	   }
	   public void deleteYouthCriticalIssues(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues youthCriticalIssues){
	       delete(youthCriticalIssues);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues getYouthCriticalIssuesById(UUID youthCriticalIssuesId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues) get(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class, youthCriticalIssuesId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues> getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentYouthCriticalIssuessCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
