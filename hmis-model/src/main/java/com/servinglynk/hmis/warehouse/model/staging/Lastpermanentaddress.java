package com.servinglynk.hmis.warehouse.model.staging;

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

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.StateEnum;


/** 
 * Object mapping for hibernate-handled table: lastpermanentaddress.
 * 
 *
 * @author Sandeep Dolia
 */
		

@Entity(name = "lastpermanentaddress_staging")
@Table(name = "lastpermanentaddress", catalog = "hmis", schema = "staging")
public class Lastpermanentaddress implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -3143666687530889406L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Integer addressdataquality;
	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String lastpermanentcity;
	/** Field mapping. */
	private StateEnum lastpermanentstate;
	/** Field mapping. */
	private String lastpermanentstreet;
	/** Field mapping. */
	private String lastpermanentzip;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Lastpermanentaddress() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Lastpermanentaddress(java.util.UUID id) {
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
		return Lastpermanentaddress.class;
	}
 

	 /**
	 * Return the value associated with the column: addressdataquality.
	 * @return A Integer object (this.addressdataquality)
	 */
	public Integer getAddressdataquality() {
		return this.addressdataquality;
		
	}
	

  
	 /**  
	 * Set the value related to the column: addressdataquality.
	 * @param addressdataquality the addressdataquality value you wish to set
	 */
	public void setAddressdataquality(final Integer addressdataquality) {
		this.addressdataquality = addressdataquality;
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
	 * Return the value associated with the column: lastpermanentcity.
	 * @return A String object (this.lastpermanentcity)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getLastpermanentcity() {
		return this.lastpermanentcity;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastpermanentcity.
	 * @param lastpermanentcity the lastpermanentcity value you wish to set
	 */
	public void setLastpermanentcity(final String lastpermanentcity) {
		this.lastpermanentcity = lastpermanentcity;
	}

	 /**
	/**
	 * Return the value associated with the column: addressDataQuality.
	 * @return A StateEnum object (this.addressDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.StateEnumType")
	@Basic( optional = true )
	@Column( name = "lastpermanentstate"  )
	public StateEnum getLastpermanentstate() {
		return this.lastpermanentstate;
		
	}
 
	 /**  
	 * Set the value related to the column: addressDataQuality.
	 * @param addressDataQuality the addressDataQuality value you wish to set
	 */
	public void setLastpermanentstate(final StateEnum lastpermanentstate) {
		this.lastpermanentstate = lastpermanentstate;
	}


	 /**
	 * Return the value associated with the column: lastpermanentstreet.
	 * @return A String object (this.lastpermanentstreet)
	 */
	@Basic( optional = true )
	@Column( length = 100  )
	public String getLastpermanentstreet() {
		return this.lastpermanentstreet;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastpermanentstreet.
	 * @param lastpermanentstreet the lastpermanentstreet value you wish to set
	 */
	public void setLastpermanentstreet(final String lastpermanentstreet) {
		this.lastpermanentstreet = lastpermanentstreet;
	}

	 /**
	 * Return the value associated with the column: lastpermanentzip.
	 * @return A String object (this.lastpermanentzip)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getLastpermanentzip() {
		return this.lastpermanentzip;
		
	}
	

  
	 /**  
	 * Set the value related to the column: lastpermanentzip.
	 * @param lastpermanentzip the lastpermanentzip value you wish to set
	 */
	public void setLastpermanentzip(final String lastpermanentzip) {
		this.lastpermanentzip = lastpermanentzip;
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
    public Lastpermanentaddress clone() throws CloneNotSupportedException {
		
        final Lastpermanentaddress copy = (Lastpermanentaddress)super.clone();

		copy.setAddressdataquality(this.getAddressdataquality());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setLastpermanentcity(this.getLastpermanentcity());
		copy.setLastpermanentstate(this.getLastpermanentstate());
		copy.setLastpermanentstreet(this.getLastpermanentstreet());
		copy.setLastpermanentzip(this.getLastpermanentzip());
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
		
		sb.append("addressdataquality: " + this.getAddressdataquality() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("lastpermanentcity: " + this.getLastpermanentcity() + ", ");
		sb.append("lastpermanentstate: " + this.getLastpermanentstate() + ", ");
		sb.append("lastpermanentstreet: " + this.getLastpermanentstreet() + ", ");
		sb.append("lastpermanentzip: " + this.getLastpermanentzip() + ", ");
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
		
		final Lastpermanentaddress that; 
		try {
			that = (Lastpermanentaddress) proxyThat;
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
		result = result && (((getAddressdataquality() == null) && (that.getAddressdataquality() == null)) || (getAddressdataquality() != null && getAddressdataquality().equals(that.getAddressdataquality())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getLastpermanentcity() == null) && (that.getLastpermanentcity() == null)) || (getLastpermanentcity() != null && getLastpermanentcity().equals(that.getLastpermanentcity())));
		result = result && (((getLastpermanentstate() == null) && (that.getLastpermanentstate() == null)) || (getLastpermanentstate() != null && getLastpermanentstate().equals(that.getLastpermanentstate())));
		result = result && (((getLastpermanentstreet() == null) && (that.getLastpermanentstreet() == null)) || (getLastpermanentstreet() != null && getLastpermanentstreet().equals(that.getLastpermanentstreet())));
		result = result && (((getLastpermanentzip() == null) && (that.getLastpermanentzip() == null)) || (getLastpermanentzip() != null && getLastpermanentzip().equals(that.getLastpermanentzip())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		return result;
	}
}