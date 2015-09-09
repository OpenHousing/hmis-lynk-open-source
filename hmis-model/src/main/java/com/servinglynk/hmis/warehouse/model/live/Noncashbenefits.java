package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: noncashbenefits.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "noncashbenefits")
@Table(name = "noncashbenefits", catalog = "hmis", schema = "live")
public class Noncashbenefits implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 6493511274453583782L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private NoncashbenefitsBenefitsfromanysourceEnum benefitsfromanysource;
	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private NoncashbenefitsOthersourceEnum othersource;
	/** Field mapping. */
	private String othersourceidentify;
	/** Field mapping. */
	private NoncashbenefitsOthertanfEnum othertanf;
	/** Field mapping. */
	private NoncashbenefitsRentalassistanceongoingEnum rentalassistanceongoing;
	/** Field mapping. */
	private NoncashbenefitsRentalassistancetempEnum rentalassistancetemp;
	/** Field mapping. */
	private NoncashbenefitsSnapEnum snap;
	/** Field mapping. */
	private NoncashbenefitsTanfchildcareEnum tanfchildcare;
	/** Field mapping. */
	private NoncashbenefitsTanftransportationEnum tanftransportation;
	/** Field mapping. */
	private HmisUser user;
	/** Field mapping. */
	private NoncashbenefitsWicEnum wic;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Noncashbenefits() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Noncashbenefits(java.util.UUID id) {
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
		return Noncashbenefits.class;
	}


	 /**
	 * Return the value associated with the column: benefitsfromanysource.
	 * @return A NoncashbenefitsBenefitsfromanysourceEnum object (this.benefitsfromanysource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsBenefitsfromanysourceEnum getBenefitsfromanysource() {
		return this.benefitsfromanysource;

	}



	 /**
	 * Set the value related to the column: benefitsfromanysource.
	 * @param benefitsfromanysource the benefitsfromanysource value you wish to set
	 */
	public void setBenefitsfromanysource(final NoncashbenefitsBenefitsfromanysourceEnum benefitsfromanysource) {
		this.benefitsfromanysource = benefitsfromanysource;
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
	 * Return the value associated with the column: othersource.
	 * @return A NoncashbenefitsOthersourceEnum object (this.othersource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsOthersourceEnum getOthersource() {
		return this.othersource;

	}



	 /**
	 * Set the value related to the column: othersource.
	 * @param othersource the othersource value you wish to set
	 */
	public void setOthersource(final NoncashbenefitsOthersourceEnum othersource) {
		this.othersource = othersource;
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
	 * Return the value associated with the column: othertanf.
	 * @return A NoncashbenefitsOthertanfEnum object (this.othertanf)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsOthertanfEnum getOthertanf() {
		return this.othertanf;

	}



	 /**
	 * Set the value related to the column: othertanf.
	 * @param othertanf the othertanf value you wish to set
	 */
	public void setOthertanf(final NoncashbenefitsOthertanfEnum othertanf) {
		this.othertanf = othertanf;
	}

	 /**
	 * Return the value associated with the column: rentalassistanceongoing.
	 * @return A NoncashbenefitsRentalassistanceongoingEnum object (this.rentalassistanceongoing)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsRentalassistanceongoingEnum getRentalassistanceongoing() {
		return this.rentalassistanceongoing;

	}



	 /**
	 * Set the value related to the column: rentalassistanceongoing.
	 * @param rentalassistanceongoing the rentalassistanceongoing value you wish to set
	 */
	public void setRentalassistanceongoing(final NoncashbenefitsRentalassistanceongoingEnum rentalassistanceongoing) {
		this.rentalassistanceongoing = rentalassistanceongoing;
	}

	 /**
	 * Return the value associated with the column: rentalassistancetemp.
	 * @return A NoncashbenefitsRentalassistancetempEnum object (this.rentalassistancetemp)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnumType")
	public NoncashbenefitsRentalassistancetempEnum getRentalassistancetemp() {
		return this.rentalassistancetemp;

	}



	 /**
	 * Set the value related to the column: rentalassistancetemp.
	 * @param rentalassistancetemp the rentalassistancetemp value you wish to set
	 */
	public void setRentalassistancetemp(final NoncashbenefitsRentalassistancetempEnum rentalassistancetemp) {
		this.rentalassistancetemp = rentalassistancetemp;
	}

	 /**
	 * Return the value associated with the column: snap.
	 * @return A NoncashbenefitsSnapEnum object (this.snap)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnumType")
	public NoncashbenefitsSnapEnum getSnap() {
		return this.snap;

	}



	 /**
	 * Set the value related to the column: snap.
	 * @param snap the snap value you wish to set
	 */
	public void setSnap(final NoncashbenefitsSnapEnum snap) {
		this.snap = snap;
	}

	 /**
	 * Return the value associated with the column: tanfchildcare.
	 * @return A NoncashbenefitsTanfchildcareEnum object (this.tanfchildcare)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsTanfchildcareEnum getTanfchildcare() {
		return this.tanfchildcare;

	}



	 /**
	 * Set the value related to the column: tanfchildcare.
	 * @param tanfchildcare the tanfchildcare value you wish to set
	 */
	public void setTanfchildcare(final NoncashbenefitsTanfchildcareEnum tanfchildcare) {
		this.tanfchildcare = tanfchildcare;
	}

	 /**
	 * Return the value associated with the column: tanftransportation.
	 * @return A NoncashbenefitsTanftransportationEnum object (this.tanftransportation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsTanftransportationEnum getTanftransportation() {
		return this.tanftransportation;

	}



	 /**
	 * Set the value related to the column: tanftransportation.
	 * @param tanftransportation the tanftransportation value you wish to set
	 */
	public void setTanftransportation(final NoncashbenefitsTanftransportationEnum tanftransportation) {
		this.tanftransportation = tanftransportation;
	}

	 /**
	 * Return the value associated with the column: user.
	 * @return A HmisUser object (this.user)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "user_id", nullable = true )
	public HmisUser getUser() {
		return this.user;

	}



	 /**
	 * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	public void setUser(final HmisUser user) {
		this.user = user;
	}

	 /**
	 * Return the value associated with the column: wic.
	 * @return A NoncashbenefitsWicEnum object (this.wic)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnumType")
	@Basic( optional = true )
	@Column
	public NoncashbenefitsWicEnum getWic() {
		return this.wic;

	}



	 /**
	 * Set the value related to the column: wic.
	 * @param wic the wic value you wish to set
	 */
	public void setWic(final NoncashbenefitsWicEnum wic) {
		this.wic = wic;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Noncashbenefits clone() throws CloneNotSupportedException {

        final Noncashbenefits copy = (Noncashbenefits)super.clone();

		copy.setBenefitsfromanysource(this.getBenefitsfromanysource());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setOthersource(this.getOthersource());
		copy.setOthersourceidentify(this.getOthersourceidentify());
		copy.setOthertanf(this.getOthertanf());
		copy.setRentalassistanceongoing(this.getRentalassistanceongoing());
		copy.setRentalassistancetemp(this.getRentalassistancetemp());
		copy.setSnap(this.getSnap());
		copy.setTanfchildcare(this.getTanfchildcare());
		copy.setTanftransportation(this.getTanftransportation());
		copy.setUser(this.getUser());
		copy.setWic(this.getWic());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("benefitsfromanysource: " + this.getBenefitsfromanysource() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("othersource: " + this.getOthersource() + ", ");
		sb.append("othersourceidentify: " + this.getOthersourceidentify() + ", ");
		sb.append("othertanf: " + this.getOthertanf() + ", ");
		sb.append("rentalassistanceongoing: " + this.getRentalassistanceongoing() + ", ");
		sb.append("rentalassistancetemp: " + this.getRentalassistancetemp() + ", ");
		sb.append("snap: " + this.getSnap() + ", ");
		sb.append("tanfchildcare: " + this.getTanfchildcare() + ", ");
		sb.append("tanftransportation: " + this.getTanftransportation() + ", ");
		sb.append("wic: " + this.getWic());
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

		final Noncashbenefits that;
		try {
			that = (Noncashbenefits) proxyThat;
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
		result = result && (((getBenefitsfromanysource() == null) && (that.getBenefitsfromanysource() == null)) || (getBenefitsfromanysource() != null && getBenefitsfromanysource().equals(that.getBenefitsfromanysource())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getOthersource() == null) && (that.getOthersource() == null)) || (getOthersource() != null && getOthersource().equals(that.getOthersource())));
		result = result && (((getOthersourceidentify() == null) && (that.getOthersourceidentify() == null)) || (getOthersourceidentify() != null && getOthersourceidentify().equals(that.getOthersourceidentify())));
		result = result && (((getOthertanf() == null) && (that.getOthertanf() == null)) || (getOthertanf() != null && getOthertanf().equals(that.getOthertanf())));
		result = result && (((getRentalassistanceongoing() == null) && (that.getRentalassistanceongoing() == null)) || (getRentalassistanceongoing() != null && getRentalassistanceongoing().equals(that.getRentalassistanceongoing())));
		result = result && (((getRentalassistancetemp() == null) && (that.getRentalassistancetemp() == null)) || (getRentalassistancetemp() != null && getRentalassistancetemp().equals(that.getRentalassistancetemp())));
		result = result && (((getSnap() == null) && (that.getSnap() == null)) || (getSnap() != null && getSnap().equals(that.getSnap())));
		result = result && (((getTanfchildcare() == null) && (that.getTanfchildcare() == null)) || (getTanfchildcare() != null && getTanfchildcare().equals(that.getTanfchildcare())));
		result = result && (((getTanftransportation() == null) && (that.getTanftransportation() == null)) || (getTanftransportation() != null && getTanftransportation().equals(that.getTanftransportation())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		result = result && (((getWic() == null) && (that.getWic() == null)) || (getWic() != null && getWic().equals(that.getWic())));
		return result;
	}
}