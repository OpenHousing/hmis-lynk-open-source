package com.servinglynk.hmis.warehouse.model.staging;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;
import com.servinglynk.hmis.warehouse.model.live.HmisBaseModel;


/** 
 * Object mapping for hibernate-handled table: incomeandsources.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "incomeandsources_staging")
@Table(name = "incomeandsources", catalog = "hmis", schema = "staging")
public class Incomeandsources extends HmisBaseStagingModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -4984883027361158713L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private IncomeandsourcesAlimonyEnum alimony;
	/** Field mapping. */
	private java.math.BigDecimal alimonyamount;
	/** Field mapping. */
	private IncomeandsourcesChildsupportEnum childsupport;
	/** Field mapping. */
	private java.math.BigDecimal childsupportamount;
	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private IncomeandsourcesEarnedEnum earned;
	/** Field mapping. */
	private java.math.BigDecimal earnedamount;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private IncomeandsourcesGaEnum ga;
	/** Field mapping. */
	private java.math.BigDecimal gaamount;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private IncomeandsourcesIncomefromanysourceEnum incomefromanysource;
	/** Field mapping. */
	private IncomeandsourcesOthersourceEnum othersource;
	/** Field mapping. */
	private java.math.BigDecimal othersourceamount;
	/** Field mapping. */
	private String othersourceidentify;
	/** Field mapping. */
	private IncomeandsourcesPensionEnum pension;
	/** Field mapping. */
	private java.math.BigDecimal pensionamount;
	/** Field mapping. */
	private IncomeandsourcesPrivatedisabilityEnum privatedisability;
	/** Field mapping. */
	private java.math.BigDecimal privatedisabilityamount;
	/** Field mapping. */
	private IncomeandsourcesSocsecretirementEnum socsecretirement;
	/** Field mapping. */
	private java.math.BigDecimal socsecretirementamount;
	/** Field mapping. */
	private IncomeandsourcesSsdiEnum ssdi;
	/** Field mapping. */
	private java.math.BigDecimal ssdiamount;
	/** Field mapping. */
	private IncomeandsourcesSsiEnum ssi;
	/** Field mapping. */
	private java.math.BigDecimal ssiamount;
	/** Field mapping. */
	private IncomeandsourcesTanfEnum tanf;
	/** Field mapping. */
	private java.math.BigDecimal tanfamount;
	/** Field mapping. */
	private java.math.BigDecimal totalmonthlyincome;
	/** Field mapping. */
	private IncomeandsourcesUnemploymentEnum unemployment;
	/** Field mapping. */
	private java.math.BigDecimal unemploymentamount;
	/** Field mapping. */
	private HmisUser user;
	/** Field mapping. */
	private IncomeandsourcesVadisabilitynonserviceEnum vadisabilitynonservice;
	/** Field mapping. */
	private java.math.BigDecimal vadisabilitynonserviceamount;
	/** Field mapping. */
	private IncomeandsourcesVadisabilityserviceEnum vadisabilityservice;
	/** Field mapping. */
	private java.math.BigDecimal vadisabilityserviceamount;
	/** Field mapping. */
	private IncomeandsourcesWorkerscompEnum workerscomp;
	/** Field mapping. */
	private java.math.BigDecimal workerscompamount;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Incomeandsources() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Incomeandsources(java.util.UUID id) {
		this.id = id;
	}
	
 


	 
	/** Field mapping. */
	private Export export;
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "export_id", nullable = true )
	public Export getExport() {
		return this.export;
		
	}
	

 
	 /**  
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final Export export) {
		this.export = export;
	}

 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Incomeandsources.class;
	}
 

	 /**
	 * Return the value associated with the column: alimony.
	 * @return A IncomeandsourcesAlimonyEnum object (this.alimony)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesAlimonyEnum getAlimony() {
		return this.alimony;
		
	}
	

  
	 /**  
	 * Set the value related to the column: alimony.
	 * @param alimony the alimony value you wish to set
	 */
	public void setAlimony(final IncomeandsourcesAlimonyEnum alimony) {
		this.alimony = alimony;
	}

	 /**
	 * Return the value associated with the column: alimonyamount.
	 * @return A java.math.BigDecimal object (this.alimonyamount)
	 */
	public java.math.BigDecimal getAlimonyamount() {
		return this.alimonyamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: alimonyamount.
	 * @param alimonyamount the alimonyamount value you wish to set
	 */
	public void setAlimonyamount(final java.math.BigDecimal alimonyamount) {
		this.alimonyamount = alimonyamount;
	}

	 /**
	 * Return the value associated with the column: childsupport.
	 * @return A IncomeandsourcesChildsupportEnum object (this.childsupport)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesChildsupportEnum getChildsupport() {
		return this.childsupport;
		
	}
	

  
	 /**  
	 * Set the value related to the column: childsupport.
	 * @param childsupport the childsupport value you wish to set
	 */
	public void setChildsupport(final IncomeandsourcesChildsupportEnum childsupport) {
		this.childsupport = childsupport;
	}

	 /**
	 * Return the value associated with the column: childsupportamount.
	 * @return A java.math.BigDecimal object (this.childsupportamount)
	 */
	public java.math.BigDecimal getChildsupportamount() {
		return this.childsupportamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: childsupportamount.
	 * @param childsupportamount the childsupportamount value you wish to set
	 */
	public void setChildsupportamount(final java.math.BigDecimal childsupportamount) {
		this.childsupportamount = childsupportamount;
	}

	 /**
	 * Return the value associated with the column: earned.
	 * @return A IncomeandsourcesEarnedEnum object (this.earned)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesEarnedEnum getEarned() {
		return this.earned;
		
	}
	

  
	 /**  
	 * Set the value related to the column: earned.
	 * @param earned the earned value you wish to set
	 */
	public void setEarned(final IncomeandsourcesEarnedEnum earned) {
		this.earned = earned;
	}

	 /**
	 * Return the value associated with the column: earnedamount.
	 * @return A java.math.BigDecimal object (this.earnedamount)
	 */
	public java.math.BigDecimal getEarnedamount() {
		return this.earnedamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: earnedamount.
	 * @param earnedamount the earnedamount value you wish to set
	 */
	public void setEarnedamount(final java.math.BigDecimal earnedamount) {
		this.earnedamount = earnedamount;
	}

	 /**
	 * Return the value associated with the column: enrollmentid.
	 * @return A Enrollment object (this.enrollmentid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "enrollmentid", nullable = true )
	public Enrollment getEnrollmentid() {
		return this.enrollmentid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: enrollmentid.
	 * @param enrollmentid the enrollmentid value you wish to set
	 */
	public void setEnrollmentid(final Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	 /**
	 * Return the value associated with the column: ga.
	 * @return A IncomeandsourcesGaEnum object (this.ga)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesGaEnum getGa() {
		return this.ga;
		
	}
	

  
	 /**  
	 * Set the value related to the column: ga.
	 * @param ga the ga value you wish to set
	 */
	public void setGa(final IncomeandsourcesGaEnum ga) {
		this.ga = ga;
	}

	 /**
	 * Return the value associated with the column: gaamount.
	 * @return A java.math.BigDecimal object (this.gaamount)
	 */
	public java.math.BigDecimal getGaamount() {
		return this.gaamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: gaamount.
	 * @param gaamount the gaamount value you wish to set
	 */
	public void setGaamount(final java.math.BigDecimal gaamount) {
		this.gaamount = gaamount;
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
	 * Return the value associated with the column: incomefromanysource.
	 * @return A IncomeandsourcesIncomefromanysourceEnum object (this.incomefromanysource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesIncomefromanysourceEnum getIncomefromanysource() {
		return this.incomefromanysource;
		
	}
	

  
	 /**  
	 * Set the value related to the column: incomefromanysource.
	 * @param incomefromanysource the incomefromanysource value you wish to set
	 */
	public void setIncomefromanysource(final IncomeandsourcesIncomefromanysourceEnum incomefromanysource) {
		this.incomefromanysource = incomefromanysource;
	}

	 /**
	 * Return the value associated with the column: othersource.
	 * @return A IncomeandsourcesOthersourceEnum object (this.othersource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesOthersourceEnum getOthersource() {
		return this.othersource;
		
	}
	

  
	 /**  
	 * Set the value related to the column: othersource.
	 * @param othersource the othersource value you wish to set
	 */
	public void setOthersource(final IncomeandsourcesOthersourceEnum othersource) {
		this.othersource = othersource;
	}

	 /**
	 * Return the value associated with the column: othersourceamount.
	 * @return A java.math.BigDecimal object (this.othersourceamount)
	 */
	public java.math.BigDecimal getOthersourceamount() {
		return this.othersourceamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: othersourceamount.
	 * @param othersourceamount the othersourceamount value you wish to set
	 */
	public void setOthersourceamount(final java.math.BigDecimal othersourceamount) {
		this.othersourceamount = othersourceamount;
	}

	 /**
	 * Return the value associated with the column: othersourceidentify.
	 * @return A String object (this.othersourceidentify)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getOthersourceidentify() {
		return this.othersourceidentify;
		
	}
	

  
	 /**  
	 * Set the value related to the column: othersourceidentify.
	 * @param othersourceidentify the othersourceidentify value you wish to set
	 */
	public void setOthersourceidentify(final String othersourceidentify) {
		this.othersourceidentify = othersourceidentify;
	}

	 /**
	 * Return the value associated with the column: pension.
	 * @return A IncomeandsourcesPensionEnum object (this.pension)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesPensionEnum getPension() {
		return this.pension;
		
	}
	

  
	 /**  
	 * Set the value related to the column: pension.
	 * @param pension the pension value you wish to set
	 */
	public void setPension(final IncomeandsourcesPensionEnum pension) {
		this.pension = pension;
	}

	 /**
	 * Return the value associated with the column: pensionamount.
	 * @return A java.math.BigDecimal object (this.pensionamount)
	 */
	public java.math.BigDecimal getPensionamount() {
		return this.pensionamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: pensionamount.
	 * @param pensionamount the pensionamount value you wish to set
	 */
	public void setPensionamount(final java.math.BigDecimal pensionamount) {
		this.pensionamount = pensionamount;
	}

	 /**
	 * Return the value associated with the column: privatedisability.
	 * @return A IncomeandsourcesPrivatedisabilityEnum object (this.privatedisability)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesPrivatedisabilityEnum getPrivatedisability() {
		return this.privatedisability;
		
	}
	

  
	 /**  
	 * Set the value related to the column: privatedisability.
	 * @param privatedisability the privatedisability value you wish to set
	 */
	public void setPrivatedisability(final IncomeandsourcesPrivatedisabilityEnum privatedisability) {
		this.privatedisability = privatedisability;
	}

	 /**
	 * Return the value associated with the column: privatedisabilityamount.
	 * @return A java.math.BigDecimal object (this.privatedisabilityamount)
	 */
	public java.math.BigDecimal getPrivatedisabilityamount() {
		return this.privatedisabilityamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: privatedisabilityamount.
	 * @param privatedisabilityamount the privatedisabilityamount value you wish to set
	 */
	public void setPrivatedisabilityamount(final java.math.BigDecimal privatedisabilityamount) {
		this.privatedisabilityamount = privatedisabilityamount;
	}

	 /**
	 * Return the value associated with the column: socsecretirement.
	 * @return A IncomeandsourcesSocsecretirementEnum object (this.socsecretirement)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesSocsecretirementEnum getSocsecretirement() {
		return this.socsecretirement;
		
	}
	

  
	 /**  
	 * Set the value related to the column: socsecretirement.
	 * @param socsecretirement the socsecretirement value you wish to set
	 */
	public void setSocsecretirement(final IncomeandsourcesSocsecretirementEnum socsecretirement) {
		this.socsecretirement = socsecretirement;
	}

	 /**
	 * Return the value associated with the column: socsecretirementamount.
	 * @return A java.math.BigDecimal object (this.socsecretirementamount)
	 */
	public java.math.BigDecimal getSocsecretirementamount() {
		return this.socsecretirementamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: socsecretirementamount.
	 * @param socsecretirementamount the socsecretirementamount value you wish to set
	 */
	public void setSocsecretirementamount(final java.math.BigDecimal socsecretirementamount) {
		this.socsecretirementamount = socsecretirementamount;
	}

	 /**
	 * Return the value associated with the column: ssdi.
	 * @return A IncomeandsourcesSsdiEnum object (this.ssdi)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesSsdiEnum getSsdi() {
		return this.ssdi;
		
	}
	

  
	 /**  
	 * Set the value related to the column: ssdi.
	 * @param ssdi the ssdi value you wish to set
	 */
	public void setSsdi(final IncomeandsourcesSsdiEnum ssdi) {
		this.ssdi = ssdi;
	}

	 /**
	 * Return the value associated with the column: ssdiamount.
	 * @return A java.math.BigDecimal object (this.ssdiamount)
	 */
	public java.math.BigDecimal getSsdiamount() {
		return this.ssdiamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: ssdiamount.
	 * @param ssdiamount the ssdiamount value you wish to set
	 */
	public void setSsdiamount(final java.math.BigDecimal ssdiamount) {
		this.ssdiamount = ssdiamount;
	}

	 /**
	 * Return the value associated with the column: ssi.
	 * @return A IncomeandsourcesSsiEnum object (this.ssi)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesSsiEnum getSsi() {
		return this.ssi;
		
	}
	

  
	 /**  
	 * Set the value related to the column: ssi.
	 * @param ssi the ssi value you wish to set
	 */
	public void setSsi(final IncomeandsourcesSsiEnum ssi) {
		this.ssi = ssi;
	}

	 /**
	 * Return the value associated with the column: ssiamount.
	 * @return A java.math.BigDecimal object (this.ssiamount)
	 */
	public java.math.BigDecimal getSsiamount() {
		return this.ssiamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: ssiamount.
	 * @param ssiamount the ssiamount value you wish to set
	 */
	public void setSsiamount(final java.math.BigDecimal ssiamount) {
		this.ssiamount = ssiamount;
	}

	 /**
	 * Return the value associated with the column: tanf.
	 * @return A IncomeandsourcesTanfEnum object (this.tanf)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesTanfEnum getTanf() {
		return this.tanf;
		
	}
	

  
	 /**  
	 * Set the value related to the column: tanf.
	 * @param tanf the tanf value you wish to set
	 */
	public void setTanf(final IncomeandsourcesTanfEnum tanf) {
		this.tanf = tanf;
	}

	 /**
	 * Return the value associated with the column: tanfamount.
	 * @return A java.math.BigDecimal object (this.tanfamount)
	 */
	public java.math.BigDecimal getTanfamount() {
		return this.tanfamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: tanfamount.
	 * @param tanfamount the tanfamount value you wish to set
	 */
	public void setTanfamount(final java.math.BigDecimal tanfamount) {
		this.tanfamount = tanfamount;
	}

	 /**
	 * Return the value associated with the column: totalmonthlyincome.
	 * @return A java.math.BigDecimal object (this.totalmonthlyincome)
	 */
	public java.math.BigDecimal getTotalmonthlyincome() {
		return this.totalmonthlyincome;
		
	}
	

  
	 /**  
	 * Set the value related to the column: totalmonthlyincome.
	 * @param totalmonthlyincome the totalmonthlyincome value you wish to set
	 */
	public void setTotalmonthlyincome(final java.math.BigDecimal totalmonthlyincome) {
		this.totalmonthlyincome = totalmonthlyincome;
	}

	 /**
	 * Return the value associated with the column: unemployment.
	 * @return A IncomeandsourcesUnemploymentEnum object (this.unemployment)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesUnemploymentEnum getUnemployment() {
		return this.unemployment;
		
	}
	

  
	 /**  
	 * Set the value related to the column: unemployment.
	 * @param unemployment the unemployment value you wish to set
	 */
	public void setUnemployment(final IncomeandsourcesUnemploymentEnum unemployment) {
		this.unemployment = unemployment;
	}

	 /**
	 * Return the value associated with the column: unemploymentamount.
	 * @return A java.math.BigDecimal object (this.unemploymentamount)
	 */
	public java.math.BigDecimal getUnemploymentamount() {
		return this.unemploymentamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: unemploymentamount.
	 * @param unemploymentamount the unemploymentamount value you wish to set
	 */
	public void setUnemploymentamount(final java.math.BigDecimal unemploymentamount) {
		this.unemploymentamount = unemploymentamount;
	}

	 /**
	 * Return the value associated with the column: vadisabilitynonservice.
	 * @return A IncomeandsourcesVadisabilitynonserviceEnum object (this.vadisabilitynonservice)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesVadisabilitynonserviceEnum getVadisabilitynonservice() {
		return this.vadisabilitynonservice;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vadisabilitynonservice.
	 * @param vadisabilitynonservice the vadisabilitynonservice value you wish to set
	 */
	public void setVadisabilitynonservice(final IncomeandsourcesVadisabilitynonserviceEnum vadisabilitynonservice) {
		this.vadisabilitynonservice = vadisabilitynonservice;
	}

	 /**
	 * Return the value associated with the column: vadisabilitynonserviceamount.
	 * @return A java.math.BigDecimal object (this.vadisabilitynonserviceamount)
	 */
	public java.math.BigDecimal getVadisabilitynonserviceamount() {
		return this.vadisabilitynonserviceamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vadisabilitynonserviceamount.
	 * @param vadisabilitynonserviceamount the vadisabilitynonserviceamount value you wish to set
	 */
	public void setVadisabilitynonserviceamount(final java.math.BigDecimal vadisabilitynonserviceamount) {
		this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
	}

	 /**
	 * Return the value associated with the column: vadisabilityservice.
	 * @return A IncomeandsourcesVadisabilityserviceEnum object (this.vadisabilityservice)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesVadisabilityserviceEnum getVadisabilityservice() {
		return this.vadisabilityservice;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vadisabilityservice.
	 * @param vadisabilityservice the vadisabilityservice value you wish to set
	 */
	public void setVadisabilityservice(final IncomeandsourcesVadisabilityserviceEnum vadisabilityservice) {
		this.vadisabilityservice = vadisabilityservice;
	}

	 /**
	 * Return the value associated with the column: vadisabilityserviceamount.
	 * @return A java.math.BigDecimal object (this.vadisabilityserviceamount)
	 */
	public java.math.BigDecimal getVadisabilityserviceamount() {
		return this.vadisabilityserviceamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vadisabilityserviceamount.
	 * @param vadisabilityserviceamount the vadisabilityserviceamount value you wish to set
	 */
	public void setVadisabilityserviceamount(final java.math.BigDecimal vadisabilityserviceamount) {
		this.vadisabilityserviceamount = vadisabilityserviceamount;
	}

	 /**
	 * Return the value associated with the column: workerscomp.
	 * @return A IncomeandsourcesWorkerscompEnum object (this.workerscomp)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnumType")
	@Basic( optional = true )
	@Column
	public IncomeandsourcesWorkerscompEnum getWorkerscomp() {
		return this.workerscomp;
		
	}
	

  
	 /**  
	 * Set the value related to the column: workerscomp.
	 * @param workerscomp the workerscomp value you wish to set
	 */
	public void setWorkerscomp(final IncomeandsourcesWorkerscompEnum workerscomp) {
		this.workerscomp = workerscomp;
	}

	 /**
	 * Return the value associated with the column: workerscompamount.
	 * @return A java.math.BigDecimal object (this.workerscompamount)
	 */
	public java.math.BigDecimal getWorkerscompamount() {
		return this.workerscompamount;
		
	}
	

  
	 /**  
	 * Set the value related to the column: workerscompamount.
	 * @param workerscompamount the workerscompamount value you wish to set
	 */
	public void setWorkerscompamount(final java.math.BigDecimal workerscompamount) {
		this.workerscompamount = workerscompamount;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Incomeandsources clone() throws CloneNotSupportedException {
		
        final Incomeandsources copy = (Incomeandsources)super.clone();

		copy.setAlimony(this.getAlimony());
		copy.setAlimonyamount(this.getAlimonyamount());
		copy.setChildsupport(this.getChildsupport());
		copy.setChildsupportamount(this.getChildsupportamount());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEarned(this.getEarned());
		copy.setEarnedamount(this.getEarnedamount());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setGa(this.getGa());
		copy.setGaamount(this.getGaamount());
		copy.setId(this.getId());
		copy.setIncomefromanysource(this.getIncomefromanysource());
		copy.setOthersource(this.getOthersource());
		copy.setOthersourceamount(this.getOthersourceamount());
		copy.setOthersourceidentify(this.getOthersourceidentify());
		copy.setPension(this.getPension());
		copy.setPensionamount(this.getPensionamount());
		copy.setPrivatedisability(this.getPrivatedisability());
		copy.setPrivatedisabilityamount(this.getPrivatedisabilityamount());
		copy.setSocsecretirement(this.getSocsecretirement());
		copy.setSocsecretirementamount(this.getSocsecretirementamount());
		copy.setSsdi(this.getSsdi());
		copy.setSsdiamount(this.getSsdiamount());
		copy.setSsi(this.getSsi());
		copy.setSsiamount(this.getSsiamount());
		copy.setTanf(this.getTanf());
		copy.setTanfamount(this.getTanfamount());
		copy.setTotalmonthlyincome(this.getTotalmonthlyincome());
		copy.setUnemployment(this.getUnemployment());
		copy.setUnemploymentamount(this.getUnemploymentamount());
		copy.setUser(this.getUser());
		copy.setVadisabilitynonservice(this.getVadisabilitynonservice());
		copy.setVadisabilitynonserviceamount(this.getVadisabilitynonserviceamount());
		copy.setVadisabilityservice(this.getVadisabilityservice());
		copy.setVadisabilityserviceamount(this.getVadisabilityserviceamount());
		copy.setWorkerscomp(this.getWorkerscomp());
		copy.setWorkerscompamount(this.getWorkerscompamount());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("alimony: " + this.getAlimony() + ", ");
		sb.append("alimonyamount: " + this.getAlimonyamount() + ", ");
		sb.append("childsupport: " + this.getChildsupport() + ", ");
		sb.append("childsupportamount: " + this.getChildsupportamount() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("earned: " + this.getEarned() + ", ");
		sb.append("earnedamount: " + this.getEarnedamount() + ", ");
		sb.append("ga: " + this.getGa() + ", ");
		sb.append("gaamount: " + this.getGaamount() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("incomefromanysource: " + this.getIncomefromanysource() + ", ");
		sb.append("othersource: " + this.getOthersource() + ", ");
		sb.append("othersourceamount: " + this.getOthersourceamount() + ", ");
		sb.append("othersourceidentify: " + this.getOthersourceidentify() + ", ");
		sb.append("pension: " + this.getPension() + ", ");
		sb.append("pensionamount: " + this.getPensionamount() + ", ");
		sb.append("privatedisability: " + this.getPrivatedisability() + ", ");
		sb.append("privatedisabilityamount: " + this.getPrivatedisabilityamount() + ", ");
		sb.append("socsecretirement: " + this.getSocsecretirement() + ", ");
		sb.append("socsecretirementamount: " + this.getSocsecretirementamount() + ", ");
		sb.append("ssdi: " + this.getSsdi() + ", ");
		sb.append("ssdiamount: " + this.getSsdiamount() + ", ");
		sb.append("ssi: " + this.getSsi() + ", ");
		sb.append("ssiamount: " + this.getSsiamount() + ", ");
		sb.append("tanf: " + this.getTanf() + ", ");
		sb.append("tanfamount: " + this.getTanfamount() + ", ");
		sb.append("totalmonthlyincome: " + this.getTotalmonthlyincome() + ", ");
		sb.append("unemployment: " + this.getUnemployment() + ", ");
		sb.append("unemploymentamount: " + this.getUnemploymentamount() + ", ");
		sb.append("vadisabilitynonservice: " + this.getVadisabilitynonservice() + ", ");
		sb.append("vadisabilitynonserviceamount: " + this.getVadisabilitynonserviceamount() + ", ");
		sb.append("vadisabilityservice: " + this.getVadisabilityservice() + ", ");
		sb.append("vadisabilityserviceamount: " + this.getVadisabilityserviceamount() + ", ");
		sb.append("workerscomp: " + this.getWorkerscomp() + ", ");
		sb.append("workerscompamount: " + this.getWorkerscompamount());
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
		
		final Incomeandsources that; 
		try {
			that = (Incomeandsources) proxyThat;
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
		result = result && (((getAlimony() == null) && (that.getAlimony() == null)) || (getAlimony() != null && getAlimony().equals(that.getAlimony())));
		result = result && (((getAlimonyamount() == null) && (that.getAlimonyamount() == null)) || (getAlimonyamount() != null && getAlimonyamount().equals(that.getAlimonyamount())));
		result = result && (((getChildsupport() == null) && (that.getChildsupport() == null)) || (getChildsupport() != null && getChildsupport().equals(that.getChildsupport())));
		result = result && (((getChildsupportamount() == null) && (that.getChildsupportamount() == null)) || (getChildsupportamount() != null && getChildsupportamount().equals(that.getChildsupportamount())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEarned() == null) && (that.getEarned() == null)) || (getEarned() != null && getEarned().equals(that.getEarned())));
		result = result && (((getEarnedamount() == null) && (that.getEarnedamount() == null)) || (getEarnedamount() != null && getEarnedamount().equals(that.getEarnedamount())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getGa() == null) && (that.getGa() == null)) || (getGa() != null && getGa().equals(that.getGa())));
		result = result && (((getGaamount() == null) && (that.getGaamount() == null)) || (getGaamount() != null && getGaamount().equals(that.getGaamount())));
		result = result && (((getIncomefromanysource() == null) && (that.getIncomefromanysource() == null)) || (getIncomefromanysource() != null && getIncomefromanysource().equals(that.getIncomefromanysource())));
		result = result && (((getOthersource() == null) && (that.getOthersource() == null)) || (getOthersource() != null && getOthersource().equals(that.getOthersource())));
		result = result && (((getOthersourceamount() == null) && (that.getOthersourceamount() == null)) || (getOthersourceamount() != null && getOthersourceamount().equals(that.getOthersourceamount())));
		result = result && (((getOthersourceidentify() == null) && (that.getOthersourceidentify() == null)) || (getOthersourceidentify() != null && getOthersourceidentify().equals(that.getOthersourceidentify())));
		result = result && (((getPension() == null) && (that.getPension() == null)) || (getPension() != null && getPension().equals(that.getPension())));
		result = result && (((getPensionamount() == null) && (that.getPensionamount() == null)) || (getPensionamount() != null && getPensionamount().equals(that.getPensionamount())));
		result = result && (((getPrivatedisability() == null) && (that.getPrivatedisability() == null)) || (getPrivatedisability() != null && getPrivatedisability().equals(that.getPrivatedisability())));
		result = result && (((getPrivatedisabilityamount() == null) && (that.getPrivatedisabilityamount() == null)) || (getPrivatedisabilityamount() != null && getPrivatedisabilityamount().equals(that.getPrivatedisabilityamount())));
		result = result && (((getSocsecretirement() == null) && (that.getSocsecretirement() == null)) || (getSocsecretirement() != null && getSocsecretirement().equals(that.getSocsecretirement())));
		result = result && (((getSocsecretirementamount() == null) && (that.getSocsecretirementamount() == null)) || (getSocsecretirementamount() != null && getSocsecretirementamount().equals(that.getSocsecretirementamount())));
		result = result && (((getSsdi() == null) && (that.getSsdi() == null)) || (getSsdi() != null && getSsdi().equals(that.getSsdi())));
		result = result && (((getSsdiamount() == null) && (that.getSsdiamount() == null)) || (getSsdiamount() != null && getSsdiamount().equals(that.getSsdiamount())));
		result = result && (((getSsi() == null) && (that.getSsi() == null)) || (getSsi() != null && getSsi().equals(that.getSsi())));
		result = result && (((getSsiamount() == null) && (that.getSsiamount() == null)) || (getSsiamount() != null && getSsiamount().equals(that.getSsiamount())));
		result = result && (((getTanf() == null) && (that.getTanf() == null)) || (getTanf() != null && getTanf().equals(that.getTanf())));
		result = result && (((getTanfamount() == null) && (that.getTanfamount() == null)) || (getTanfamount() != null && getTanfamount().equals(that.getTanfamount())));
		result = result && (((getTotalmonthlyincome() == null) && (that.getTotalmonthlyincome() == null)) || (getTotalmonthlyincome() != null && getTotalmonthlyincome().equals(that.getTotalmonthlyincome())));
		result = result && (((getUnemployment() == null) && (that.getUnemployment() == null)) || (getUnemployment() != null && getUnemployment().equals(that.getUnemployment())));
		result = result && (((getUnemploymentamount() == null) && (that.getUnemploymentamount() == null)) || (getUnemploymentamount() != null && getUnemploymentamount().equals(that.getUnemploymentamount())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));	
		result = result && (((getVadisabilitynonservice() == null) && (that.getVadisabilitynonservice() == null)) || (getVadisabilitynonservice() != null && getVadisabilitynonservice().equals(that.getVadisabilitynonservice())));
		result = result && (((getVadisabilitynonserviceamount() == null) && (that.getVadisabilitynonserviceamount() == null)) || (getVadisabilitynonserviceamount() != null && getVadisabilitynonserviceamount().equals(that.getVadisabilitynonserviceamount())));
		result = result && (((getVadisabilityservice() == null) && (that.getVadisabilityservice() == null)) || (getVadisabilityservice() != null && getVadisabilityservice().equals(that.getVadisabilityservice())));
		result = result && (((getVadisabilityserviceamount() == null) && (that.getVadisabilityserviceamount() == null)) || (getVadisabilityserviceamount() != null && getVadisabilityserviceamount().equals(that.getVadisabilityserviceamount())));
		result = result && (((getWorkerscomp() == null) && (that.getWorkerscomp() == null)) || (getWorkerscomp() != null && getWorkerscomp().equals(that.getWorkerscomp())));
		result = result && (((getWorkerscompamount() == null) && (that.getWorkerscompamount() == null)) || (getWorkerscompamount() != null && getWorkerscompamount().equals(that.getWorkerscompamount())));
		return result;
	}
	
}
