package com.servinglynk.hmis.warehouse.model.live;

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

import com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnum;
import com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnum;


/**
 * Object mapping for hibernate-handled table: inventory.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "inventory")
@Table(name = "inventory", catalog = "hmis", schema = "live")
public class Inventory implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = 5575541932820010068L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private InventoryAvailabiltyEnum availabilty;
	/** Field mapping. */
	private Bedinventory bedinventory;
	/** Field mapping. */
	private InventoryBedtypeEnum bedtype;
	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Integer hmisparticipatingbeds;
	/** Field mapping. */
	private InventoryHouseholdtypeEnum householdtype;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private LocalDate inventoryenddate;
	/** Field mapping. */
	private LocalDate inventorystartdate;
	/** Field mapping. */
	private Projectcoc projectCoc;
	/** Field mapping. */
	private Integer unitinventory;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Inventory() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Inventory(java.util.UUID id) {
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
		return Inventory.class;
	}


	 /**
	 * Return the value associated with the column: availabilty.
	 * @return A InventoryAvailabiltyEnum object (this.availabilty)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryAvailabiltyEnumType")
	@Basic( optional = true )
	@Column
	public InventoryAvailabiltyEnum getAvailabilty() {
		return this.availabilty;

	}



	 /**
	 * Set the value related to the column: availabilty.
	 * @param availabilty the availabilty value you wish to set
	 */
	public void setAvailabilty(final InventoryAvailabiltyEnum availabilty) {
		this.availabilty = availabilty;
	}

	 /**
	 * Return the value associated with the column: bedinventory.
	 * @return A Integer object (this.bedinventory)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "bedinventory", nullable = true )
	public Bedinventory getBedinventory() {
		return this.bedinventory;

	}



	 /**
	 * Set the value related to the column: bedinventory.
	 * @param bedinventory the bedinventory value you wish to set
	 */
	public void setBedinventory(final Bedinventory bedinventory) {
		this.bedinventory = bedinventory;
	}

	 /**
	 * Return the value associated with the column: bedtype.
	 * @return A InventoryBedtypeEnum object (this.bedtype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryBedtypeEnumType")
	@Basic( optional = true )
	@Column
	public InventoryBedtypeEnum getBedtype() {
		return this.bedtype;

	}



	 /**
	 * Set the value related to the column: bedtype.
	 * @param bedtype the bedtype value you wish to set
	 */
	public void setBedtype(final InventoryBedtypeEnum bedtype) {
		this.bedtype = bedtype;
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
	 * Return the value associated with the column: hmisparticipatingbeds.
	 * @return A Integer object (this.hmisparticipatingbeds)
	 */
	public Integer getHmisparticipatingbeds() {
		return this.hmisparticipatingbeds;

	}



	 /**
	 * Set the value related to the column: hmisparticipatingbeds.
	 * @param hmisparticipatingbeds the hmisparticipatingbeds value you wish to set
	 */
	public void setHmisparticipatingbeds(final Integer hmisparticipatingbeds) {
		this.hmisparticipatingbeds = hmisparticipatingbeds;
	}

	 /**
	 * Return the value associated with the column: householdtype.
	 * @return A InventoryHouseholdtypeEnum object (this.householdtype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.InventoryHouseholdtypeEnumType")
	@Basic( optional = true )
	@Column
	public InventoryHouseholdtypeEnum getHouseholdtype() {
		return this.householdtype;

	}



	 /**
	 * Set the value related to the column: householdtype.
	 * @param householdtype the householdtype value you wish to set
	 */
	public void setHouseholdtype(final InventoryHouseholdtypeEnum householdtype) {
		this.householdtype = householdtype;
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
	 * Return the value associated with the column: inventoryenddate.
	 * @return A LocalDate object (this.inventoryenddate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column
	public LocalDate getInventoryenddate() {
		return this.inventoryenddate;

	}



	 /**
	 * Set the value related to the column: inventoryenddate.
	 * @param inventoryenddate the inventoryenddate value you wish to set
	 */
	public void setInventoryenddate(final LocalDate inventoryenddate) {
		this.inventoryenddate = inventoryenddate;
	}

	 /**
	 * Return the value associated with the column: inventorystartdate.
	 * @return A LocalDate object (this.inventorystartdate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column
	public LocalDate getInventorystartdate() {
		return this.inventorystartdate;

	}



	 /**
	 * Set the value related to the column: inventorystartdate.
	 * @param inventorystartdate the inventorystartdate value you wish to set
	 */
	public void setInventorystartdate(final LocalDate inventorystartdate) {
		this.inventorystartdate = inventorystartdate;
	}

	 /**
	 * Return the value associated with the column: projectCoc.
	 * @return A Projectcoc object (this.projectCoc)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "project_coc_id", nullable = true )
	public Projectcoc getProjectCoc() {
		return this.projectCoc;

	}



	 /**
	 * Set the value related to the column: projectCoc.
	 * @param projectCoc the projectCoc value you wish to set
	 */
	public void setProjectCoc(final Projectcoc projectCoc) {
		this.projectCoc = projectCoc;
	}

	 /**
	 * Return the value associated with the column: unitinventory.
	 * @return A Integer object (this.unitinventory)
	 */
	public Integer getUnitinventory() {
		return this.unitinventory;

	}



	 /**
	 * Set the value related to the column: unitinventory.
	 * @param unitinventory the unitinventory value you wish to set
	 */
	public void setUnitinventory(final Integer unitinventory) {
		this.unitinventory = unitinventory;
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
    public Inventory clone() throws CloneNotSupportedException {

        final Inventory copy = (Inventory)super.clone();

		copy.setAvailabilty(this.getAvailabilty());
		copy.setBedinventory(this.getBedinventory());
		copy.setBedtype(this.getBedtype());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setHmisparticipatingbeds(this.getHmisparticipatingbeds());
		copy.setHouseholdtype(this.getHouseholdtype());
		copy.setId(this.getId());
		copy.setInventoryenddate(this.getInventoryenddate());
		copy.setInventorystartdate(this.getInventorystartdate());
		copy.setProjectCoc(this.getProjectCoc());
		copy.setUnitinventory(this.getUnitinventory());
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

		sb.append("availabilty: " + this.getAvailabilty() + ", ");
		sb.append("bedinventory: " + this.getBedinventory() + ", ");
		sb.append("bedtype: " + this.getBedtype() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("hmisparticipatingbeds: " + this.getHmisparticipatingbeds() + ", ");
		sb.append("householdtype: " + this.getHouseholdtype() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("inventoryenddate: " + this.getInventoryenddate() + ", ");
		sb.append("inventorystartdate: " + this.getInventorystartdate() + ", ");
		sb.append("unitinventory: " + this.getUnitinventory() + ", ");
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

		final Inventory that;
		try {
			that = (Inventory) proxyThat;
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
		result = result && (((getAvailabilty() == null) && (that.getAvailabilty() == null)) || (getAvailabilty() != null && getAvailabilty().equals(that.getAvailabilty())));
		result = result && (((getBedinventory() == null) && (that.getBedinventory() == null)) || (getBedinventory() != null && getBedinventory().equals(that.getBedinventory())));
		result = result && (((getBedtype() == null) && (that.getBedtype() == null)) || (getBedtype() != null && getBedtype().equals(that.getBedtype())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getHmisparticipatingbeds() == null) && (that.getHmisparticipatingbeds() == null)) || (getHmisparticipatingbeds() != null && getHmisparticipatingbeds().equals(that.getHmisparticipatingbeds())));
		result = result && (((getHouseholdtype() == null) && (that.getHouseholdtype() == null)) || (getHouseholdtype() != null && getHouseholdtype().equals(that.getHouseholdtype())));
		result = result && (((getInventoryenddate() == null) && (that.getInventoryenddate() == null)) || (getInventoryenddate() != null && getInventoryenddate().equals(that.getInventoryenddate())));
		result = result && (((getInventorystartdate() == null) && (that.getInventorystartdate() == null)) || (getInventorystartdate() != null && getInventorystartdate().equals(that.getInventorystartdate())));
		result = result && (((getProjectCoc() == null) && (that.getProjectCoc() == null)) || (getProjectCoc() != null && getProjectCoc().getId().equals(that.getProjectCoc().getId())));
		result = result && (((getUnitinventory() == null) && (that.getUnitinventory() == null)) || (getUnitinventory() != null && getUnitinventory().equals(that.getUnitinventory())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}
}