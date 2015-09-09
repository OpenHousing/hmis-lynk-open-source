package com.servinglynk.hmis.warehouse.model.staging;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.HmisUserGenderEnum;
import com.servinglynk.hmis.warehouse.enums.HmisUserOrganizationEnum;


/** 
 * Object mapping for hibernate-handled table: hmis_user.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "hmis_user_staging")
@Table(name = "hmis_user", catalog = "hmis", schema = "staging")
public class HmisUser implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -3243148389368176233L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Set<Affiliation> affiliations = new HashSet<Affiliation>();

	/** Field mapping. */
	private Set<Bedinventory> bedinventories = new HashSet<Bedinventory>();

	/** Field mapping. */
	private Set<Client> clients = new HashSet<Client>();

	/** Field mapping. */
	private Set<Commercialsexualexploitation> commercialsexualexploitations = new HashSet<Commercialsexualexploitation>();

	/** Field mapping. */
	private Set<Connectionwithsoar> connectionwithsoars = new HashSet<Connectionwithsoar>();

	/** Field mapping. */
	private Set<Dateofengagement> dateofengagements = new HashSet<Dateofengagement>();

	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Set<Disabilities> disabilitieses = new HashSet<Disabilities>();

	/** Field mapping. */
	private LocalDate dob;
	/** Field mapping. */
	private Set<Domesticviolence> domesticviolences = new HashSet<Domesticviolence>();

	/** Field mapping. */
	private Set<Employment> employments = new HashSet<Employment>();

	/** Field mapping. */
	private Set<Enrollment> enrollments = new HashSet<Enrollment>();

	/** Field mapping. */
	private Set<EnrollmentCoc> enrollmentCocs = new HashSet<EnrollmentCoc>();

	/** Field mapping. */
	private Set<Exit> exits = new HashSet<Exit>();

	/** Field mapping. */
	private Set<Exithousingassessment> exithousingassessments = new HashSet<Exithousingassessment>();

	/** Field mapping. */
	private Set<Exitplansactions> exitplansactionss = new HashSet<Exitplansactions>();

	/** Field mapping. */
	private Set<Familyreunification> familyreunifications = new HashSet<Familyreunification>();

	/** Field mapping. */
	private String firstName;
	/** Field mapping. */
	private Set<Formerwardchildwelfare> formerwardchildwelfares = new HashSet<Formerwardchildwelfare>();

	/** Field mapping. */
	private Set<Formerwardjuvenilejustice> formerwardjuvenilejustices = new HashSet<Formerwardjuvenilejustice>();

	/** Field mapping. */
	private Set<Funder> funders = new HashSet<Funder>();

	/** Field mapping. */
	private HmisUserGenderEnum gender;
	/** Field mapping. */
	private Set<Healthinsurance> healthinsurances = new HashSet<Healthinsurance>();

	/** Field mapping. */
	private Set<HealthStatus> healthStatuses = new HashSet<HealthStatus>();

	/** Field mapping. */
	private Set<HmisType> hmisTypes = new HashSet<HmisType>();

	/** Field mapping. */
	private Set<Housingassessmentdisposition> housingassessmentdispositions = new HashSet<Housingassessmentdisposition>();

	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Set<Incomeandsources> incomeandsourceses = new HashSet<Incomeandsources>();

	/** Field mapping. */
	private Set<Inventory> inventories = new HashSet<Inventory>();

	/** Field mapping. */
	private Set<Lastgradecompleted> lastgradecompleteds = new HashSet<Lastgradecompleted>();

	/** Field mapping. */
	private Set<LastPermAddress> lastPermAddresses = new HashSet<LastPermAddress>();

	/** Field mapping. */
	private Set<Lastpermanentaddress> lastpermanentaddresses = new HashSet<Lastpermanentaddress>();

	/** Field mapping. */
	private String lastName;
	/** Field mapping. */
	private Set<Medicalassistance> medicalassistances = new HashSet<Medicalassistance>();

	/** Field mapping. */
	private String middleName;
	/** Field mapping. */
	private String nameSuffix;
	/** Field mapping. */
	private Set<Noncashbenefits> noncashbenefitss = new HashSet<Noncashbenefits>();

	/** Field mapping. */
	private Set<HmisUserOrganizationEnum> organizations = new HashSet<HmisUserOrganizationEnum>();

	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> pathstatuses = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Pathstatus>();

	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> percentamis = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Percentami>();

	/** Field mapping. */
	private Set<Project> projects = new HashSet<Project>();

	/** Field mapping. */
	private Set<Projectcoc> projectcocs = new HashSet<Projectcoc>();

	/** Field mapping. */
	private Set<Projectcompletionstatus> projectcompletionstatuses = new HashSet<Projectcompletionstatus>();

	/** Field mapping. */
	private Set<Referralsource> referralsources = new HashSet<Referralsource>();

	/** Field mapping. */
	private Set<Residentialmoveindate> residentialmoveindates = new HashSet<Residentialmoveindate>();

	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> rhybcpstatuses = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus>();

	/** Field mapping. */
	private Set<Schoolstatus> schoolstatuses = new HashSet<Schoolstatus>();

	/** Field mapping. */
	private Set<Services> serviceses = new HashSet<Services>();

	/** Field mapping. */
	private Set<Sexualorientation> sexualorientations = new HashSet<Sexualorientation>();

	/** Field mapping. */
	private Set<Site> sites = new HashSet<Site>();

	/** Field mapping. */
	private Set<Source> sources = new HashSet<Source>();

	/** Field mapping. */
	private Set<VeteranInfo> veteranInfoes = new HashSet<VeteranInfo>();

	/** Field mapping. */
	private Set<Worsthousingsituation> worsthousingsituations = new HashSet<Worsthousingsituation>();

	/** Field mapping. */
	private Set<Youthcriticalissues> youthcriticalissueses = new HashSet<Youthcriticalissues>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public HmisUser() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public HmisUser(java.util.UUID id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return HmisUser.class;
	}
 

	 /**
	 * Return the value associated with the column: affiliation.
	 * @return A Set&lt;Affiliation&gt; object (this.affiliation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Affiliation> getAffiliations() {
		return this.affiliations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Affiliation to the affiliations set.
	 * @param affiliation item to add
	 */
	public void addAffiliation(Affiliation affiliation) {
		affiliation.setUser(this);
		this.affiliations.add(affiliation);
	}

  
	 /**  
	 * Set the value related to the column: affiliation.
	 * @param affiliation the affiliation value you wish to set
	 */
	public void setAffiliations(final Set<Affiliation> affiliation) {
		this.affiliations = affiliation;
	}

	 /**
	 * Return the value associated with the column: bedinventory.
	 * @return A Set&lt;Bedinventory&gt; object (this.bedinventory)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Bedinventory> getBedinventories() {
		return this.bedinventories;
		
	}
	
	/**
	 * Adds a bi-directional link of type Bedinventory to the bedinventories set.
	 * @param bedinventory item to add
	 */
	public void addBedinventory(Bedinventory bedinventory) {
		bedinventory.setUser(this);
		this.bedinventories.add(bedinventory);
	}

  
	 /**  
	 * Set the value related to the column: bedinventory.
	 * @param bedinventory the bedinventory value you wish to set
	 */
	public void setBedinventories(final Set<Bedinventory> bedinventory) {
		this.bedinventories = bedinventory;
	}

	 /**
	 * Return the value associated with the column: client.
	 * @return A Set&lt;Client&gt; object (this.client)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Client> getClients() {
		return this.clients;
		
	}
	
	/**
	 * Adds a bi-directional link of type Client to the clients set.
	 * @param client item to add
	 */
	public void addClient(Client client) {
		client.setUser(this);
		this.clients.add(client);
	}

  
	 /**  
	 * Set the value related to the column: client.
	 * @param client the client value you wish to set
	 */
	public void setClients(final Set<Client> client) {
		this.clients = client;
	}

	 /**
	 * Return the value associated with the column: commercialsexualexploitation.
	 * @return A Set&lt;Commercialsexualexploitation&gt; object (this.commercialsexualexploitation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Commercialsexualexploitation> getCommercialsexualexploitations() {
		return this.commercialsexualexploitations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Commercialsexualexploitation to the commercialsexualexploitations set.
	 * @param commercialsexualexploitation item to add
	 */
	public void addCommercialsexualexploitation(Commercialsexualexploitation commercialsexualexploitation) {
		commercialsexualexploitation.setUser(this);
		this.commercialsexualexploitations.add(commercialsexualexploitation);
	}

  
	 /**  
	 * Set the value related to the column: commercialsexualexploitation.
	 * @param commercialsexualexploitation the commercialsexualexploitation value you wish to set
	 */
	public void setCommercialsexualexploitations(final Set<Commercialsexualexploitation> commercialsexualexploitation) {
		this.commercialsexualexploitations = commercialsexualexploitation;
	}

	 /**
	 * Return the value associated with the column: connectionwithsoar.
	 * @return A Set&lt;Connectionwithsoar&gt; object (this.connectionwithsoar)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Connectionwithsoar> getConnectionwithsoars() {
		return this.connectionwithsoars;
		
	}
	
	/**
	 * Adds a bi-directional link of type Connectionwithsoar to the connectionwithsoars set.
	 * @param connectionwithsoar item to add
	 */
	public void addConnectionwithsoar(Connectionwithsoar connectionwithsoar) {
		connectionwithsoar.setUser(this);
		this.connectionwithsoars.add(connectionwithsoar);
	}

  
	 /**  
	 * Set the value related to the column: connectionwithsoar.
	 * @param connectionwithsoar the connectionwithsoar value you wish to set
	 */
	public void setConnectionwithsoars(final Set<Connectionwithsoar> connectionwithsoar) {
		this.connectionwithsoars = connectionwithsoar;
	}

	 /**
	 * Return the value associated with the column: dateofengagement.
	 * @return A Set&lt;Dateofengagement&gt; object (this.dateofengagement)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Dateofengagement> getDateofengagements() {
		return this.dateofengagements;
		
	}
	
	/**
	 * Adds a bi-directional link of type Dateofengagement to the dateofengagements set.
	 * @param dateofengagement item to add
	 */
	public void addDateofengagement(Dateofengagement dateofengagement) {
		dateofengagement.setUser(this);
		this.dateofengagements.add(dateofengagement);
	}

  
	 /**  
	 * Set the value related to the column: dateofengagement.
	 * @param dateofengagement the dateofengagement value you wish to set
	 */
	public void setDateofengagements(final Set<Dateofengagement> dateofengagement) {
		this.dateofengagements = dateofengagement;
	}

	 /**
	 * Return the value associated with the column: dateCreated.
	 * @return A LocalDate object (this.dateCreated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column( name = "date_created"  )
	public LocalDate getDateCreated() {
		return this.dateCreated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateCreated.
	 * @param dateCreated the dateCreated value you wish to set
	 */
	public void setDateCreated(final LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	 /**
	 * Return the value associated with the column: dateUpdated.
	 * @return A LocalDate object (this.dateUpdated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column( name = "date_updated"  )
	public LocalDate getDateUpdated() {
		return this.dateUpdated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateUpdated.
	 * @param dateUpdated the dateUpdated value you wish to set
	 */
	public void setDateUpdated(final LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	 /**
	 * Return the value associated with the column: disabilities.
	 * @return A Set&lt;Disabilities&gt; object (this.disabilities)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Disabilities> getDisabilitieses() {
		return this.disabilitieses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Disabilities to the disabilitieses set.
	 * @param disabilities item to add
	 */
	public void addDisabilities(Disabilities disabilities) {
		disabilities.setUser(this);
		this.disabilitieses.add(disabilities);
	}

  
	 /**  
	 * Set the value related to the column: disabilities.
	 * @param disabilities the disabilities value you wish to set
	 */
	public void setDisabilitieses(final Set<Disabilities> disabilities) {
		this.disabilitieses = disabilities;
	}

	 /**
	 * Return the value associated with the column: dob.
	 * @return A LocalDate object (this.dob)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column
	public LocalDate getDob() {
		return this.dob;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dob.
	 * @param dob the dob value you wish to set
	 */
	public void setDob(final LocalDate dob) {
		this.dob = dob;
	}

	 /**
	 * Return the value associated with the column: domesticviolence.
	 * @return A Set&lt;Domesticviolence&gt; object (this.domesticviolence)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Domesticviolence> getDomesticviolences() {
		return this.domesticviolences;
		
	}
	
	/**
	 * Adds a bi-directional link of type Domesticviolence to the domesticviolences set.
	 * @param domesticviolence item to add
	 */
	public void addDomesticviolence(Domesticviolence domesticviolence) {
		domesticviolence.setUser(this);
		this.domesticviolences.add(domesticviolence);
	}

  
	 /**  
	 * Set the value related to the column: domesticviolence.
	 * @param domesticviolence the domesticviolence value you wish to set
	 */
	public void setDomesticviolences(final Set<Domesticviolence> domesticviolence) {
		this.domesticviolences = domesticviolence;
	}

	 /**
	 * Return the value associated with the column: employment.
	 * @return A Set&lt;Employment&gt; object (this.employment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Employment> getEmployments() {
		return this.employments;
		
	}
	
	/**
	 * Adds a bi-directional link of type Employment to the employments set.
	 * @param employment item to add
	 */
	public void addEmployment(Employment employment) {
		employment.setUser(this);
		this.employments.add(employment);
	}

  
	 /**  
	 * Set the value related to the column: employment.
	 * @param employment the employment value you wish to set
	 */
	public void setEmployments(final Set<Employment> employment) {
		this.employments = employment;
	}

	 /**
	 * Return the value associated with the column: enrollment.
	 * @return A Set&lt;Enrollment&gt; object (this.enrollment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Enrollment> getEnrollments() {
		return this.enrollments;
		
	}
	
	/**
	 * Adds a bi-directional link of type Enrollment to the enrollments set.
	 * @param enrollment item to add
	 */
	public void addEnrollment(Enrollment enrollment) {
		enrollment.setUser(this);
		this.enrollments.add(enrollment);
	}

  
	 /**  
	 * Set the value related to the column: enrollment.
	 * @param enrollment the enrollment value you wish to set
	 */
	public void setEnrollments(final Set<Enrollment> enrollment) {
		this.enrollments = enrollment;
	}

	 /**
	 * Return the value associated with the column: enrollmentCoc.
	 * @return A Set&lt;EnrollmentCoc&gt; object (this.enrollmentCoc)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<EnrollmentCoc> getEnrollmentCocs() {
		return this.enrollmentCocs;
		
	}
	
	/**
	 * Adds a bi-directional link of type EnrollmentCoc to the enrollmentCocs set.
	 * @param enrollmentCoc item to add
	 */
	public void addEnrollmentCoc(EnrollmentCoc enrollmentCoc) {
		enrollmentCoc.setUser(this);
		this.enrollmentCocs.add(enrollmentCoc);
	}

  
	 /**  
	 * Set the value related to the column: enrollmentCoc.
	 * @param enrollmentCoc the enrollmentCoc value you wish to set
	 */
	public void setEnrollmentCocs(final Set<EnrollmentCoc> enrollmentCoc) {
		this.enrollmentCocs = enrollmentCoc;
	}

	 /**
	 * Return the value associated with the column: exit.
	 * @return A Set&lt;Exit&gt; object (this.exit)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exit> getExits() {
		return this.exits;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exit to the exits set.
	 * @param exit item to add
	 */
	public void addExit(Exit exit) {
		exit.setUser(this);
		this.exits.add(exit);
	}

  
	 /**  
	 * Set the value related to the column: exit.
	 * @param exit the exit value you wish to set
	 */
	public void setExits(final Set<Exit> exit) {
		this.exits = exit;
	}

	 /**
	 * Return the value associated with the column: exithousingassessment.
	 * @return A Set&lt;Exithousingassessment&gt; object (this.exithousingassessment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exithousingassessment> getExithousingassessments() {
		return this.exithousingassessments;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exithousingassessment to the exithousingassessments set.
	 * @param exithousingassessment item to add
	 */
	public void addExithousingassessment(Exithousingassessment exithousingassessment) {
		exithousingassessment.setUser(this);
		this.exithousingassessments.add(exithousingassessment);
	}

  
	 /**  
	 * Set the value related to the column: exithousingassessment.
	 * @param exithousingassessment the exithousingassessment value you wish to set
	 */
	public void setExithousingassessments(final Set<Exithousingassessment> exithousingassessment) {
		this.exithousingassessments = exithousingassessment;
	}

	 /**
	 * Return the value associated with the column: exitplansactions.
	 * @return A Set&lt;Exitplansactions&gt; object (this.exitplansactions)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exitplansactions> getExitplansactionss() {
		return this.exitplansactionss;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exitplansactions to the exitplansactionss set.
	 * @param exitplansactions item to add
	 */
	public void addExitplansactions(Exitplansactions exitplansactions) {
		exitplansactions.setUser(this);
		this.exitplansactionss.add(exitplansactions);
	}

  
	 /**  
	 * Set the value related to the column: exitplansactions.
	 * @param exitplansactions the exitplansactions value you wish to set
	 */
	public void setExitplansactionss(final Set<Exitplansactions> exitplansactions) {
		this.exitplansactionss = exitplansactions;
	}

	 /**
	 * Return the value associated with the column: familyreunification.
	 * @return A Set&lt;Familyreunification&gt; object (this.familyreunification)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Familyreunification> getFamilyreunifications() {
		return this.familyreunifications;
		
	}
	
	/**
	 * Adds a bi-directional link of type Familyreunification to the familyreunifications set.
	 * @param familyreunification item to add
	 */
	public void addFamilyreunification(Familyreunification familyreunification) {
		familyreunification.setUser(this);
		this.familyreunifications.add(familyreunification);
	}

  
	 /**  
	 * Set the value related to the column: familyreunification.
	 * @param familyreunification the familyreunification value you wish to set
	 */
	public void setFamilyreunifications(final Set<Familyreunification> familyreunification) {
		this.familyreunifications = familyreunification;
	}

	 /**
	 * Return the value associated with the column: firstName.
	 * @return A String object (this.firstName)
	 */
	@Basic( optional = true )
	@Column( name = "first_name", length = 50  )
	public String getFirstName() {
		return this.firstName;
		
	}
	

  
	 /**  
	 * Set the value related to the column: firstName.
	 * @param firstName the firstName value you wish to set
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	 /**
	 * Return the value associated with the column: formerwardchildwelfare.
	 * @return A Set&lt;Formerwardchildwelfare&gt; object (this.formerwardchildwelfare)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Formerwardchildwelfare> getFormerwardchildwelfares() {
		return this.formerwardchildwelfares;
		
	}
	
	/**
	 * Adds a bi-directional link of type Formerwardchildwelfare to the formerwardchildwelfares set.
	 * @param formerwardchildwelfare item to add
	 */
	public void addFormerwardchildwelfare(Formerwardchildwelfare formerwardchildwelfare) {
		formerwardchildwelfare.setUser(this);
		this.formerwardchildwelfares.add(formerwardchildwelfare);
	}

  
	 /**  
	 * Set the value related to the column: formerwardchildwelfare.
	 * @param formerwardchildwelfare the formerwardchildwelfare value you wish to set
	 */
	public void setFormerwardchildwelfares(final Set<Formerwardchildwelfare> formerwardchildwelfare) {
		this.formerwardchildwelfares = formerwardchildwelfare;
	}

	 /**
	 * Return the value associated with the column: formerwardjuvenilejustice.
	 * @return A Set&lt;Formerwardjuvenilejustice&gt; object (this.formerwardjuvenilejustice)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Formerwardjuvenilejustice> getFormerwardjuvenilejustices() {
		return this.formerwardjuvenilejustices;
		
	}
	
	/**
	 * Adds a bi-directional link of type Formerwardjuvenilejustice to the formerwardjuvenilejustices set.
	 * @param formerwardjuvenilejustice item to add
	 */
	public void addFormerwardjuvenilejustice(Formerwardjuvenilejustice formerwardjuvenilejustice) {
		formerwardjuvenilejustice.setUser(this);
		this.formerwardjuvenilejustices.add(formerwardjuvenilejustice);
	}

  
	 /**  
	 * Set the value related to the column: formerwardjuvenilejustice.
	 * @param formerwardjuvenilejustice the formerwardjuvenilejustice value you wish to set
	 */
	public void setFormerwardjuvenilejustices(final Set<Formerwardjuvenilejustice> formerwardjuvenilejustice) {
		this.formerwardjuvenilejustices = formerwardjuvenilejustice;
	}

	 /**
	 * Return the value associated with the column: funder.
	 * @return A Set&lt;Funder&gt; object (this.funder)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Funder> getFunders() {
		return this.funders;
		
	}
	
	/**
	 * Adds a bi-directional link of type Funder to the funders set.
	 * @param funder item to add
	 */
	public void addFunder(Funder funder) {
		funder.setUser(this);
		this.funders.add(funder);
	}

  
	 /**  
	 * Set the value related to the column: funder.
	 * @param funder the funder value you wish to set
	 */
	public void setFunders(final Set<Funder> funder) {
		this.funders = funder;
	}

	 /**
	 * Return the value associated with the column: gender.
	 * @return A HmisUserGenderEnum object (this.gender)
	 */
	@Column()
	@Type(type="com.servinglynk.hmis.warehouse.enums.GenderEnumType")
	public HmisUserGenderEnum getGender() {
		return this.gender;
		
	}
	

  
	 /**  
	 * Set the value related to the column: gender.
	 * @param gender the gender value you wish to set
	 */
	public void setGender(final HmisUserGenderEnum gender) {
		this.gender = gender;
	}

	 /**
	 * Return the value associated with the column: healthinsurance.
	 * @return A Set&lt;Healthinsurance&gt; object (this.healthinsurance)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Healthinsurance> getHealthinsurances() {
		return this.healthinsurances;
		
	}
	
	/**
	 * Adds a bi-directional link of type Healthinsurance to the healthinsurances set.
	 * @param healthinsurance item to add
	 */
	public void addHealthinsurance(Healthinsurance healthinsurance) {
		healthinsurance.setUser(this);
		this.healthinsurances.add(healthinsurance);
	}

  
	 /**  
	 * Set the value related to the column: healthinsurance.
	 * @param healthinsurance the healthinsurance value you wish to set
	 */
	public void setHealthinsurances(final Set<Healthinsurance> healthinsurance) {
		this.healthinsurances = healthinsurance;
	}

	 /**
	 * Return the value associated with the column: healthStatus.
	 * @return A Set&lt;HealthStatus&gt; object (this.healthStatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<HealthStatus> getHealthStatuses() {
		return this.healthStatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type HealthStatus to the healthStatuses set.
	 * @param healthStatus item to add
	 */
	public void addHealthStatus(HealthStatus healthStatus) {
		healthStatus.setUser(this);
		this.healthStatuses.add(healthStatus);
	}

  
	 /**  
	 * Set the value related to the column: healthStatus.
	 * @param healthStatus the healthStatus value you wish to set
	 */
	public void setHealthStatuses(final Set<HealthStatus> healthStatus) {
		this.healthStatuses = healthStatus;
	}

	 /**
	 * Return the value associated with the column: hmisType.
	 * @return A Set&lt;HmisType&gt; object (this.hmisType)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<HmisType> getHmisTypes() {
		return this.hmisTypes;
		
	}
	
	/**
	 * Adds a bi-directional link of type HmisType to the hmisTypes set.
	 * @param hmisType item to add
	 */
	public void addHmisType(HmisType hmisType) {
		hmisType.setUser(this);
		this.hmisTypes.add(hmisType);
	}

  
	 /**  
	 * Set the value related to the column: hmisType.
	 * @param hmisType the hmisType value you wish to set
	 */
	public void setHmisTypes(final Set<HmisType> hmisType) {
		this.hmisTypes = hmisType;
	}

	 /**
	 * Return the value associated with the column: housingassessmentdisposition.
	 * @return A Set&lt;Housingassessmentdisposition&gt; object (this.housingassessmentdisposition)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Housingassessmentdisposition> getHousingassessmentdispositions() {
		return this.housingassessmentdispositions;
		
	}
	
	/**
	 * Adds a bi-directional link of type Housingassessmentdisposition to the housingassessmentdispositions set.
	 * @param housingassessmentdisposition item to add
	 */
	public void addHousingassessmentdisposition(Housingassessmentdisposition housingassessmentdisposition) {
		housingassessmentdisposition.setUser(this);
		this.housingassessmentdispositions.add(housingassessmentdisposition);
	}

  
	 /**  
	 * Set the value related to the column: housingassessmentdisposition.
	 * @param housingassessmentdisposition the housingassessmentdisposition value you wish to set
	 */
	public void setHousingassessmentdispositions(final Set<Housingassessmentdisposition> housingassessmentdisposition) {
		this.housingassessmentdispositions = housingassessmentdisposition;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */
    @Id 
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final java.util.UUID id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: incomeandsources.
	 * @return A Set&lt;Incomeandsources&gt; object (this.incomeandsources)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Incomeandsources> getIncomeandsourceses() {
		return this.incomeandsourceses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Incomeandsources to the incomeandsourceses set.
	 * @param incomeandsources item to add
	 */
	public void addIncomeandsources(Incomeandsources incomeandsources) {
		incomeandsources.setUser(this);
		this.incomeandsourceses.add(incomeandsources);
	}

  
	 /**  
	 * Set the value related to the column: incomeandsources.
	 * @param incomeandsources the incomeandsources value you wish to set
	 */
	public void setIncomeandsourceses(final Set<Incomeandsources> incomeandsources) {
		this.incomeandsourceses = incomeandsources;
	}

	 /**
	 * Return the value associated with the column: inventory.
	 * @return A Set&lt;Inventory&gt; object (this.inventory)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Inventory> getInventories() {
		return this.inventories;
		
	}
	
	/**
	 * Adds a bi-directional link of type Inventory to the inventories set.
	 * @param inventory item to add
	 */
	public void addInventory(Inventory inventory) {
		inventory.setUser(this);
		this.inventories.add(inventory);
	}

  
	 /**  
	 * Set the value related to the column: inventory.
	 * @param inventory the inventory value you wish to set
	 */
	public void setInventories(final Set<Inventory> inventory) {
		this.inventories = inventory;
	}

	 /**
	 * Return the value associated with the column: lastgradecompleted.
	 * @return A Set&lt;Lastgradecompleted&gt; object (this.lastgradecompleted)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Lastgradecompleted> getLastgradecompleteds() {
		return this.lastgradecompleteds;
		
	}
	
	/**
	 * Adds a bi-directional link of type Lastgradecompleted to the lastgradecompleteds set.
	 * @param lastgradecompleted item to add
	 */
	public void addLastgradecompleted(Lastgradecompleted lastgradecompleted) {
		lastgradecompleted.setUser(this);
		this.lastgradecompleteds.add(lastgradecompleted);
	}

  
	 /**  
	 * Set the value related to the column: lastgradecompleted.
	 * @param lastgradecompleted the lastgradecompleted value you wish to set
	 */
	public void setLastgradecompleteds(final Set<Lastgradecompleted> lastgradecompleted) {
		this.lastgradecompleteds = lastgradecompleted;
	}

	 /**
	 * Return the value associated with the column: lastPermAddress.
	 * @return A Set&lt;LastPermAddress&gt; object (this.lastPermAddress)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<LastPermAddress> getLastPermAddresses() {
		return this.lastPermAddresses;
		
	}
	
	/**
	 * Adds a bi-directional link of type LastPermAddress to the lastPermAddresses set.
	 * @param lastPermAddress item to add
	 */
	public void addLastPermAddress(LastPermAddress lastPermAddress) {
		lastPermAddress.setUser(this);
		this.lastPermAddresses.add(lastPermAddress);
	}

  
	 /**  
	 * Set the value related to the column: lastPermAddress.
	 * @param lastPermAddress the lastPermAddress value you wish to set
	 */
	public void setLastPermAddresses(final Set<LastPermAddress> lastPermAddress) {
		this.lastPermAddresses = lastPermAddress;
	}

	 /**
	 * Return the value associated with the column: lastpermanentaddress.
	 * @return A Set&lt;Lastpermanentaddress&gt; object (this.lastpermanentaddress)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Lastpermanentaddress> getLastpermanentaddresses() {
		return this.lastpermanentaddresses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Lastpermanentaddress to the lastpermanentaddresses set.
	 * @param lastpermanentaddress item to add
	 */
	public void addLastpermanentaddress(Lastpermanentaddress lastpermanentaddress) {
		lastpermanentaddress.setUser(this);
		this.lastpermanentaddresses.add(lastpermanentaddress);
	}

  
	 /**  
	 * Set the value related to the column: lastpermanentaddress.
	 * @param lastpermanentaddress the lastpermanentaddress value you wish to set
	 */
	public void setLastpermanentaddresses(final Set<Lastpermanentaddress> lastpermanentaddress) {
		this.lastpermanentaddresses = lastpermanentaddress;
	}

	 /**
	 * Return the value associated with the column: lastName.
	 * @return A String object (this.lastName)
	 */
	@Basic( optional = true )
	@Column( name = "last_name", length = 50  )
	public String getLastName() {
		return this.lastName;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastName.
	 * @param lastName the lastName value you wish to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	 /**
	 * Return the value associated with the column: medicalassistance.
	 * @return A Set&lt;Medicalassistance&gt; object (this.medicalassistance)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Medicalassistance> getMedicalassistances() {
		return this.medicalassistances;
		
	}
	
	/**
	 * Adds a bi-directional link of type Medicalassistance to the medicalassistances set.
	 * @param medicalassistance item to add
	 */
	public void addMedicalassistance(Medicalassistance medicalassistance) {
		medicalassistance.setUser(this);
		this.medicalassistances.add(medicalassistance);
	}

  
	 /**  
	 * Set the value related to the column: medicalassistance.
	 * @param medicalassistance the medicalassistance value you wish to set
	 */
	public void setMedicalassistances(final Set<Medicalassistance> medicalassistance) {
		this.medicalassistances = medicalassistance;
	}

	 /**
	 * Return the value associated with the column: middleName.
	 * @return A String object (this.middleName)
	 */
	@Basic( optional = true )
	@Column( name = "middle_name", length = 50  )
	public String getMiddleName() {
		return this.middleName;
		
	}
	

  
	 /**  
	 * Set the value related to the column: middleName.
	 * @param middleName the middleName value you wish to set
	 */
	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	 /**
	 * Return the value associated with the column: nameSuffix.
	 * @return A String object (this.nameSuffix)
	 */
	@Basic( optional = true )
	@Column( name = "name_suffix", length = 50  )
	public String getNameSuffix() {
		return this.nameSuffix;
		
	}
	

  
	 /**  
	 * Set the value related to the column: nameSuffix.
	 * @param nameSuffix the nameSuffix value you wish to set
	 */
	public void setNameSuffix(final String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	 /**
	 * Return the value associated with the column: noncashbenefits.
	 * @return A Set&lt;Noncashbenefits&gt; object (this.noncashbenefits)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Noncashbenefits> getNoncashbenefitss() {
		return this.noncashbenefitss;
		
	}
	
	/**
	 * Adds a bi-directional link of type Noncashbenefits to the noncashbenefitss set.
	 * @param noncashbenefits item to add
	 */
	public void addNoncashbenefits(Noncashbenefits noncashbenefits) {
		noncashbenefits.setUser(this);
		this.noncashbenefitss.add(noncashbenefits);
	}

  
	 /**  
	 * Set the value related to the column: noncashbenefits.
	 * @param noncashbenefits the noncashbenefits value you wish to set
	 */
	public void setNoncashbenefitss(final Set<Noncashbenefits> noncashbenefits) {
		this.noncashbenefitss = noncashbenefits;
	}

	/**
	 * Adds a bi-directional link of type Organization to the organizations set.
	 * @param organization item to add
	 */
	public void addOrganization(HmisUserOrganizationEnum organization) {
		//organization.setthis);
		//TODO : Need to add an implemenatation of setting Organization.
		this.organizations.add(organization);
	}

  
	 /**  
	 * Set the value related to the column: organization.
	 * @param organization the organization value you wish to set
	 */
	public void setOrganizations(final Set<HmisUserOrganizationEnum> organization) {
		this.organizations = organization;
	}

	 /**
	 * Return the value associated with the column: pathstatus.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Pathstatus&gt; object (this.pathstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> getPathstatuses() {
		return this.pathstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Pathstatus to the pathstatuses set.
	 * @param pathstatus item to add
	 */
	public void addPathstatus(com.servinglynk.hmis.warehouse.model.staging.Pathstatus pathstatus) {
		pathstatus.setUser(this);
		this.pathstatuses.add(pathstatus);
	}

  
	 /**  
	 * Set the value related to the column: pathstatus.
	 * @param pathstatus the pathstatus value you wish to set
	 */
	public void setPathstatuses(final Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> pathstatus) {
		this.pathstatuses = pathstatus;
	}

	 /**
	 * Return the value associated with the column: percentami.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Percentami&gt; object (this.percentami)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> getPercentamis() {
		return this.percentamis;
		
	}
	
	/**
	 * Adds a bi-directional link of type Percentami to the percentamis set.
	 * @param percentami item to add
	 */
	public void addPercentami(com.servinglynk.hmis.warehouse.model.staging.Percentami percentami) {
		percentami.setUser(this);
		this.percentamis.add(percentami);
	}

  
	 /**  
	 * Set the value related to the column: percentami.
	 * @param percentami the percentami value you wish to set
	 */
	public void setPercentamis(final Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> percentami) {
		this.percentamis = percentami;
	}

	 /**
	 * Return the value associated with the column: project.
	 * @return A Set&lt;Project&gt; object (this.project)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Project> getProjects() {
		return this.projects;
		
	}
	
	/**
	 * Adds a bi-directional link of type Project to the projects set.
	 * @param project item to add
	 */
	public void addProject(Project project) {
		project.setUser(this);
		this.projects.add(project);
	}

  
	 /**  
	 * Set the value related to the column: project.
	 * @param project the project value you wish to set
	 */
	public void setProjects(final Set<Project> project) {
		this.projects = project;
	}

	 /**
	 * Return the value associated with the column: projectcoc.
	 * @return A Set&lt;Projectcoc&gt; object (this.projectcoc)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Projectcoc> getProjectcocs() {
		return this.projectcocs;
		
	}
	
	/**
	 * Adds a bi-directional link of type Projectcoc to the projectcocs set.
	 * @param projectcoc item to add
	 */
	public void addProjectcoc(Projectcoc projectcoc) {
		projectcoc.setUser(this);
		this.projectcocs.add(projectcoc);
	}

  
	 /**  
	 * Set the value related to the column: projectcoc.
	 * @param projectcoc the projectcoc value you wish to set
	 */
	public void setProjectcocs(final Set<Projectcoc> projectcoc) {
		this.projectcocs = projectcoc;
	}

	 /**
	 * Return the value associated with the column: projectcompletionstatus.
	 * @return A Set&lt;Projectcompletionstatus&gt; object (this.projectcompletionstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Projectcompletionstatus> getProjectcompletionstatuses() {
		return this.projectcompletionstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Projectcompletionstatus to the projectcompletionstatuses set.
	 * @param projectcompletionstatus item to add
	 */
	public void addProjectcompletionstatus(Projectcompletionstatus projectcompletionstatus) {
		projectcompletionstatus.setUser(this);
		this.projectcompletionstatuses.add(projectcompletionstatus);
	}

  
	 /**  
	 * Set the value related to the column: projectcompletionstatus.
	 * @param projectcompletionstatus the projectcompletionstatus value you wish to set
	 */
	public void setProjectcompletionstatuses(final Set<Projectcompletionstatus> projectcompletionstatus) {
		this.projectcompletionstatuses = projectcompletionstatus;
	}

	 /**
	 * Return the value associated with the column: referralsource.
	 * @return A Set&lt;Referralsource&gt; object (this.referralsource)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Referralsource> getReferralsources() {
		return this.referralsources;
		
	}
	
	/**
	 * Adds a bi-directional link of type Referralsource to the referralsources set.
	 * @param referralsource item to add
	 */
	public void addReferralsource(Referralsource referralsource) {
		referralsource.setUser(this);
		this.referralsources.add(referralsource);
	}

  
	 /**  
	 * Set the value related to the column: referralsource.
	 * @param referralsource the referralsource value you wish to set
	 */
	public void setReferralsources(final Set<Referralsource> referralsource) {
		this.referralsources = referralsource;
	}

	 /**
	 * Return the value associated with the column: residentialmoveindate.
	 * @return A Set&lt;Residentialmoveindate&gt; object (this.residentialmoveindate)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Residentialmoveindate> getResidentialmoveindates() {
		return this.residentialmoveindates;
		
	}
	
	/**
	 * Adds a bi-directional link of type Residentialmoveindate to the residentialmoveindates set.
	 * @param residentialmoveindate item to add
	 */
	public void addResidentialmoveindate(Residentialmoveindate residentialmoveindate) {
		residentialmoveindate.setUser(this);
		this.residentialmoveindates.add(residentialmoveindate);
	}

  
	 /**  
	 * Set the value related to the column: residentialmoveindate.
	 * @param residentialmoveindate the residentialmoveindate value you wish to set
	 */
	public void setResidentialmoveindates(final Set<Residentialmoveindate> residentialmoveindate) {
		this.residentialmoveindates = residentialmoveindate;
	}

	 /**
	 * Return the value associated with the column: rhybcpstatus.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus&gt; object (this.rhybcpstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> getRhybcpstatuses() {
		return this.rhybcpstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Rhybcpstatus to the rhybcpstatuses set.
	 * @param rhybcpstatus item to add
	 */
	public void addRhybcpstatus(com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus rhybcpstatus) {
		rhybcpstatus.setUser(this);
		this.rhybcpstatuses.add(rhybcpstatus);
	}

  
	 /**  
	 * Set the value related to the column: rhybcpstatus.
	 * @param rhybcpstatus the rhybcpstatus value you wish to set
	 */
	public void setRhybcpstatuses(final Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> rhybcpstatus) {
		this.rhybcpstatuses = rhybcpstatus;
	}

	 /**
	 * Return the value associated with the column: schoolstatus.
	 * @return A Set&lt;Schoolstatus&gt; object (this.schoolstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Schoolstatus> getSchoolstatuses() {
		return this.schoolstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Schoolstatus to the schoolstatuses set.
	 * @param schoolstatus item to add
	 */
	public void addSchoolstatus(Schoolstatus schoolstatus) {
		schoolstatus.setUser(this);
		this.schoolstatuses.add(schoolstatus);
	}

  
	 /**  
	 * Set the value related to the column: schoolstatus.
	 * @param schoolstatus the schoolstatus value you wish to set
	 */
	public void setSchoolstatuses(final Set<Schoolstatus> schoolstatus) {
		this.schoolstatuses = schoolstatus;
	}

	 /**
	 * Return the value associated with the column: services.
	 * @return A Set&lt;Services&gt; object (this.services)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Services> getServiceses() {
		return this.serviceses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Services to the serviceses set.
	 * @param services item to add
	 */
	public void addServices(Services services) {
		services.setUser(this);
		this.serviceses.add(services);
	}

  
	 /**  
	 * Set the value related to the column: services.
	 * @param services the services value you wish to set
	 */
	public void setServiceses(final Set<Services> services) {
		this.serviceses = services;
	}

	 /**
	 * Return the value associated with the column: sexualorientation.
	 * @return A Set&lt;Sexualorientation&gt; object (this.sexualorientation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Sexualorientation> getSexualorientations() {
		return this.sexualorientations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Sexualorientation to the sexualorientations set.
	 * @param sexualorientation item to add
	 */
	public void addSexualorientation(Sexualorientation sexualorientation) {
		sexualorientation.setUser(this);
		this.sexualorientations.add(sexualorientation);
	}

  
	 /**  
	 * Set the value related to the column: sexualorientation.
	 * @param sexualorientation the sexualorientation value you wish to set
	 */
	public void setSexualorientations(final Set<Sexualorientation> sexualorientation) {
		this.sexualorientations = sexualorientation;
	}

	 /**
	 * Return the value associated with the column: site.
	 * @return A Set&lt;Site&gt; object (this.site)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Site> getSites() {
		return this.sites;
		
	}
	
	/**
	 * Adds a bi-directional link of type Site to the sites set.
	 * @param site item to add
	 */
	public void addSite(Site site) {
		site.setUser(this);
		this.sites.add(site);
	}

  
	 /**  
	 * Set the value related to the column: site.
	 * @param site the site value you wish to set
	 */
	public void setSites(final Set<Site> site) {
		this.sites = site;
	}

	 /**
	 * Return the value associated with the column: source.
	 * @return A Set&lt;Source&gt; object (this.source)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Source> getSources() {
		return this.sources;
		
	}
	
	/**
	 * Adds a bi-directional link of type Source to the sources set.
	 * @param source item to add
	 */
	public void addSource(Source source) {
		source.setUser(this);
		this.sources.add(source);
	}

  
	 /**  
	 * Set the value related to the column: source.
	 * @param source the source value you wish to set
	 */
	public void setSources(final Set<Source> source) {
		this.sources = source;
	}

	 /**
	 * Return the value associated with the column: veteranInfo.
	 * @return A Set&lt;VeteranInfo&gt; object (this.veteranInfo)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<VeteranInfo> getVeteranInfoes() {
		return this.veteranInfoes;
		
	}
	
	/**
	 * Adds a bi-directional link of type VeteranInfo to the veteranInfoes set.
	 * @param veteranInfo item to add
	 */
	public void addVeteranInfo(VeteranInfo veteranInfo) {
		veteranInfo.setUser(this);
		this.veteranInfoes.add(veteranInfo);
	}

  
	 /**  
	 * Set the value related to the column: veteranInfo.
	 * @param veteranInfo the veteranInfo value you wish to set
	 */
	public void setVeteranInfoes(final Set<VeteranInfo> veteranInfo) {
		this.veteranInfoes = veteranInfo;
	}

	 /**
	 * Return the value associated with the column: worsthousingsituation.
	 * @return A Set&lt;Worsthousingsituation&gt; object (this.worsthousingsituation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Worsthousingsituation> getWorsthousingsituations() {
		return this.worsthousingsituations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Worsthousingsituation to the worsthousingsituations set.
	 * @param worsthousingsituation item to add
	 */
	public void addWorsthousingsituation(Worsthousingsituation worsthousingsituation) {
		worsthousingsituation.setUser(this);
		this.worsthousingsituations.add(worsthousingsituation);
	}

  
	 /**  
	 * Set the value related to the column: worsthousingsituation.
	 * @param worsthousingsituation the worsthousingsituation value you wish to set
	 */
	public void setWorsthousingsituations(final Set<Worsthousingsituation> worsthousingsituation) {
		this.worsthousingsituations = worsthousingsituation;
	}

	 /**
	 * Return the value associated with the column: youthcriticalissues.
	 * @return A Set&lt;Youthcriticalissues&gt; object (this.youthcriticalissues)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "user"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Youthcriticalissues> getYouthcriticalissueses() {
		return this.youthcriticalissueses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Youthcriticalissues to the youthcriticalissueses set.
	 * @param youthcriticalissues item to add
	 */
	public void addYouthcriticalissues(Youthcriticalissues youthcriticalissues) {
		youthcriticalissues.setUser(this);
		this.youthcriticalissueses.add(youthcriticalissues);
	}

  
	 /**  
	 * Set the value related to the column: youthcriticalissues.
	 * @param youthcriticalissues the youthcriticalissues value you wish to set
	 */
	public void setYouthcriticalissueses(final Set<Youthcriticalissues> youthcriticalissues) {
		this.youthcriticalissueses = youthcriticalissues;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public HmisUser clone() throws CloneNotSupportedException {
		
        final HmisUser copy = (HmisUser)super.clone();

		if (this.getAffiliations() != null) {
			copy.getAffiliations().addAll(this.getAffiliations());
		}
		if (this.getBedinventories() != null) {
			copy.getBedinventories().addAll(this.getBedinventories());
		}
		if (this.getClients() != null) {
			copy.getClients().addAll(this.getClients());
		}
		if (this.getCommercialsexualexploitations() != null) {
			copy.getCommercialsexualexploitations().addAll(this.getCommercialsexualexploitations());
		}
		if (this.getConnectionwithsoars() != null) {
			copy.getConnectionwithsoars().addAll(this.getConnectionwithsoars());
		}
		if (this.getDateofengagements() != null) {
			copy.getDateofengagements().addAll(this.getDateofengagements());
		}
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		if (this.getDisabilitieses() != null) {
			copy.getDisabilitieses().addAll(this.getDisabilitieses());
		}
		copy.setDob(this.getDob());
		if (this.getDomesticviolences() != null) {
			copy.getDomesticviolences().addAll(this.getDomesticviolences());
		}
		if (this.getEmployments() != null) {
			copy.getEmployments().addAll(this.getEmployments());
		}
		if (this.getEnrollments() != null) {
			copy.getEnrollments().addAll(this.getEnrollments());
		}
		if (this.getEnrollmentCocs() != null) {
			copy.getEnrollmentCocs().addAll(this.getEnrollmentCocs());
		}
		if (this.getExits() != null) {
			copy.getExits().addAll(this.getExits());
		}
		if (this.getExithousingassessments() != null) {
			copy.getExithousingassessments().addAll(this.getExithousingassessments());
		}
		if (this.getExitplansactionss() != null) {
			copy.getExitplansactionss().addAll(this.getExitplansactionss());
		}
		if (this.getFamilyreunifications() != null) {
			copy.getFamilyreunifications().addAll(this.getFamilyreunifications());
		}
		copy.setFirstName(this.getFirstName());
		if (this.getFormerwardchildwelfares() != null) {
			copy.getFormerwardchildwelfares().addAll(this.getFormerwardchildwelfares());
		}
		if (this.getFormerwardjuvenilejustices() != null) {
			copy.getFormerwardjuvenilejustices().addAll(this.getFormerwardjuvenilejustices());
		}
		if (this.getFunders() != null) {
			copy.getFunders().addAll(this.getFunders());
		}
		copy.setGender(this.getGender());
		if (this.getHealthinsurances() != null) {
			copy.getHealthinsurances().addAll(this.getHealthinsurances());
		}
		if (this.getHealthStatuses() != null) {
			copy.getHealthStatuses().addAll(this.getHealthStatuses());
		}
		if (this.getHmisTypes() != null) {
			copy.getHmisTypes().addAll(this.getHmisTypes());
		}
		if (this.getHousingassessmentdispositions() != null) {
			copy.getHousingassessmentdispositions().addAll(this.getHousingassessmentdispositions());
		}
		copy.setId(this.getId());
		if (this.getIncomeandsourceses() != null) {
			copy.getIncomeandsourceses().addAll(this.getIncomeandsourceses());
		}
		if (this.getInventories() != null) {
			copy.getInventories().addAll(this.getInventories());
		}
		if (this.getLastgradecompleteds() != null) {
			copy.getLastgradecompleteds().addAll(this.getLastgradecompleteds());
		}
		if (this.getLastPermAddresses() != null) {
			copy.getLastPermAddresses().addAll(this.getLastPermAddresses());
		}
		if (this.getLastpermanentaddresses() != null) {
			copy.getLastpermanentaddresses().addAll(this.getLastpermanentaddresses());
		}
		copy.setLastName(this.getLastName());
		if (this.getMedicalassistances() != null) {
			copy.getMedicalassistances().addAll(this.getMedicalassistances());
		}
		copy.setMiddleName(this.getMiddleName());
		copy.setNameSuffix(this.getNameSuffix());
		if (this.getNoncashbenefitss() != null) {
			copy.getNoncashbenefitss().addAll(this.getNoncashbenefitss());
		}
		if (this.getPathstatuses() != null) {
			copy.getPathstatuses().addAll(this.getPathstatuses());
		}
		if (this.getPercentamis() != null) {
			copy.getPercentamis().addAll(this.getPercentamis());
		}
		if (this.getProjects() != null) {
			copy.getProjects().addAll(this.getProjects());
		}
		if (this.getProjectcocs() != null) {
			copy.getProjectcocs().addAll(this.getProjectcocs());
		}
		if (this.getProjectcompletionstatuses() != null) {
			copy.getProjectcompletionstatuses().addAll(this.getProjectcompletionstatuses());
		}
		if (this.getReferralsources() != null) {
			copy.getReferralsources().addAll(this.getReferralsources());
		}
		if (this.getResidentialmoveindates() != null) {
			copy.getResidentialmoveindates().addAll(this.getResidentialmoveindates());
		}
		if (this.getRhybcpstatuses() != null) {
			copy.getRhybcpstatuses().addAll(this.getRhybcpstatuses());
		}
		if (this.getSchoolstatuses() != null) {
			copy.getSchoolstatuses().addAll(this.getSchoolstatuses());
		}
		if (this.getServiceses() != null) {
			copy.getServiceses().addAll(this.getServiceses());
		}
		if (this.getSexualorientations() != null) {
			copy.getSexualorientations().addAll(this.getSexualorientations());
		}
		if (this.getSites() != null) {
			copy.getSites().addAll(this.getSites());
		}
		if (this.getSources() != null) {
			copy.getSources().addAll(this.getSources());
		}
		if (this.getVeteranInfoes() != null) {
			copy.getVeteranInfoes().addAll(this.getVeteranInfoes());
		}
		if (this.getWorsthousingsituations() != null) {
			copy.getWorsthousingsituations().addAll(this.getWorsthousingsituations());
		}
		if (this.getYouthcriticalissueses() != null) {
			copy.getYouthcriticalissueses().addAll(this.getYouthcriticalissueses());
		}
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("dob: " + this.getDob() + ", ");
		sb.append("firstName: " + this.getFirstName() + ", ");
		sb.append("gender: " + this.getGender() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastName: " + this.getLastName() + ", ");
		sb.append("middleName: " + this.getMiddleName() + ", ");
		sb.append("nameSuffix: " + this.getNameSuffix() + ", ");
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final HmisUser that; 
		try {
			that = (HmisUser) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDob() == null) && (that.getDob() == null)) || (getDob() != null && getDob().equals(that.getDob())));
		result = result && (((getFirstName() == null) && (that.getFirstName() == null)) || (getFirstName() != null && getFirstName().equals(that.getFirstName())));
		result = result && (((getGender() == null) && (that.getGender() == null)) || (getGender() != null && getGender().equals(that.getGender())));
		result = result && (((getLastName() == null) && (that.getLastName() == null)) || (getLastName() != null && getLastName().equals(that.getLastName())));
		result = result && (((getMiddleName() == null) && (that.getMiddleName() == null)) || (getMiddleName() != null && getMiddleName().equals(that.getMiddleName())));
		result = result && (((getNameSuffix() == null) && (that.getNameSuffix() == null)) || (getNameSuffix() != null && getNameSuffix().equals(that.getNameSuffix())));
		return result;
	}
}