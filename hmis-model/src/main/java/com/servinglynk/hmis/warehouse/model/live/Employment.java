package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;

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
 * Object mapping for hibernate-handled table: employment.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "employment")
@Table(name = "employment", catalog = "hmis", schema = "live")
public class Employment implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -6654649692481756031L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private EmploymentEmployedEnum employed;
	/** Field mapping. */
	private EmploymentEmploymentTypeEnum employmentType;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private LocalDate informationDate;
	/** Field mapping. */
	private EmploymentNotEmployedReasonEnum notEmployedReason;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Employment() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Employment(java.util.UUID id) {
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
		return Employment.class;
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
	 * Return the value associated with the column: employed.
	 * @return A EmploymentEmployedEnum object (this.employed)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnumType")
	@Basic( optional = true )
	@Column
	public EmploymentEmployedEnum getEmployed() {
		return this.employed;

	}



	 /**
	 * Set the value related to the column: employed.
	 * @param employed the employed value you wish to set
	 */
	public void setEmployed(final EmploymentEmployedEnum employed) {
		this.employed = employed;
	}

	 /**
	 * Return the value associated with the column: employmentType.
	 * @return A EmploymentEmploymentTypeEnum object (this.employmentType)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnumType")
	@Basic( optional = true )
	@Column( name = "employment_type"  )
	public EmploymentEmploymentTypeEnum getEmploymentType() {
		return this.employmentType;

	}



	 /**
	 * Set the value related to the column: employmentType.
	 * @param employmentType the employmentType value you wish to set
	 */
	public void setEmploymentType(final EmploymentEmploymentTypeEnum employmentType) {
		this.employmentType = employmentType;
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
	 * Return the value associated with the column: informationDate.
	 * @return A LocalDate object (this.informationDate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column( name = "information_date"  )
	public LocalDate getInformationDate() {
		return this.informationDate;

	}



	 /**
	 * Set the value related to the column: informationDate.
	 * @param informationDate the informationDate value you wish to set
	 */
	public void setInformationDate(final LocalDate informationDate) {
		this.informationDate = informationDate;
	}

	 /**
	 * Return the value associated with the column: notEmployedReason.
	 * @return A EmploymentNotEmployedReasonEnum object (this.notEmployedReason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnumType")
	@Basic( optional = true )
	@Column( name = "not_employed_reason"  )
	public EmploymentNotEmployedReasonEnum getNotEmployedReason() {
		return this.notEmployedReason;

	}



	 /**
	 * Set the value related to the column: notEmployedReason.
	 * @param notEmployedReason the notEmployedReason value you wish to set
	 */
	public void setNotEmployedReason(final EmploymentNotEmployedReasonEnum notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Employment clone() throws CloneNotSupportedException {

        final Employment copy = (Employment)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEmployed(this.getEmployed());
		copy.setEmploymentType(this.getEmploymentType());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setInformationDate(this.getInformationDate());
		copy.setNotEmployedReason(this.getNotEmployedReason());
		copy.setUser(this.getUser());
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
		sb.append("employed: " + this.getEmployed() + ", ");
		sb.append("employmentType: " + this.getEmploymentType() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("informationDate: " + this.getInformationDate() + ", ");
		sb.append("notEmployedReason: " + this.getNotEmployedReason() + ", ");
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

		final Employment that;
		try {
			that = (Employment) proxyThat;
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
		result = result && (((getEmployed() == null) && (that.getEmployed() == null)) || (getEmployed() != null && getEmployed().equals(that.getEmployed())));
		result = result && (((getEmploymentType() == null) && (that.getEmploymentType() == null)) || (getEmploymentType() != null && getEmploymentType().equals(that.getEmploymentType())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getInformationDate() == null) && (that.getInformationDate() == null)) || (getInformationDate() != null && getInformationDate().equals(that.getInformationDate())));
		result = result && (((getNotEmployedReason() == null) && (that.getNotEmployedReason() == null)) || (getNotEmployedReason() != null && getNotEmployedReason().equals(that.getNotEmployedReason())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}

}