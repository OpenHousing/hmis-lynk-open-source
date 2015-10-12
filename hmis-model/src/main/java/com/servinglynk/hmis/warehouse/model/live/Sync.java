package com.servinglynk.hmis.warehouse.model.live;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: sync.
 *
 *
 * @author Sandeep Dolia
 */


@Table(name = "sync", catalog = "hmis", schema = "live")
public class Sync implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -2816865188163905934L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String json;
	/** Field mapping. */
	private String status;
	/** Field mapping. */
	private String syncTable;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Sync() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Sync(java.util.UUID id) {
		this.id = id;
	}





	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Sync.class;
	}


	 /**
	 * Return the value associated with the column: dateCreated.
	 * @return A LocalDateTime object (this.dateCreated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "date_created"  )
	public LocalDateTime getDateCreated() {
		return this.dateCreated;

	}



	 /**
	 * Set the value related to the column: dateCreated.
	 * @param dateCreated the dateCreated value you wish to set
	 */
	public void setDateCreated(final LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	 /**
	 * Return the value associated with the column: dateUpdated.
	 * @return A LocalDateTime object (this.dateUpdated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "date_updated"  )
	public LocalDateTime getDateUpdated() {
		return this.dateUpdated;

	}



	 /**
	 * Set the value related to the column: dateUpdated.
	 * @param dateUpdated the dateUpdated value you wish to set
	 */
	public void setDateUpdated(final LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
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
	 * Return the value associated with the column: json.
	 * @return A String object (this.json)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getJson() {
		return this.json;

	}



	 /**
	 * Set the value related to the column: json.
	 * @param json the json value you wish to set
	 */
	public void setJson(final String json) {
		this.json = json;
	}

	 /**
	 * Return the value associated with the column: status.
	 * @return A String object (this.status)
	 */
	@Basic( optional = true )
	@Column( length = 10  )
	public String getStatus() {
		return this.status;

	}



	 /**
	 * Set the value related to the column: status.
	 * @param status the status value you wish to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	 /**
	 * Return the value associated with the column: syncTable.
	 * @return A String object (this.syncTable)
	 */
	@Basic( optional = true )
	@Column( name = "sync_table", length = 100  )
	public String getSyncTable() {
		return this.syncTable;

	}



	 /**
	 * Set the value related to the column: syncTable.
	 * @param syncTable the syncTable value you wish to set
	 */
	public void setSyncTable(final String syncTable) {
		this.syncTable = syncTable;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Sync clone() throws CloneNotSupportedException {

        final Sync copy = (Sync)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setId(this.getId());
		copy.setJson(this.getJson());
		copy.setStatus(this.getStatus());
		copy.setSyncTable(this.getSyncTable());
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
		sb.append("id: " + this.getId() + ", ");
		sb.append("json: " + this.getJson() + ", ");
		sb.append("status: " + this.getStatus() + ", ");
		sb.append("syncTable: " + this.getSyncTable());
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

		final Sync that;
		try {
			that = (Sync) proxyThat;
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
		result = result && (((getJson() == null) && (that.getJson() == null)) || (getJson() != null && getJson().equals(that.getJson())));
		result = result && (((getStatus() == null) && (that.getStatus() == null)) || (getStatus() != null && getStatus().equals(that.getStatus())));
		result = result && (((getSyncTable() == null) && (that.getSyncTable() == null)) || (getSyncTable() != null && getSyncTable().equals(that.getSyncTable())));
		return result;
	}

}
