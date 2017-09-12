/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

/**
 * @author Sandeep
 *
 */
public interface DisabilitiesDao extends ParentDao {



	   com.servinglynk.hmis.warehouse.model.v2017.Disabilities createDisabilities(com.servinglynk.hmis.warehouse.model.v2017.Disabilities disabilities);
	   com.servinglynk.hmis.warehouse.model.v2017.Disabilities updateDisabilities(com.servinglynk.hmis.warehouse.model.v2017.Disabilities disabilities);
	   void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2017.Disabilities disabilities);
	   com.servinglynk.hmis.warehouse.model.v2017.Disabilities getDisabilitiesById(UUID disabilitiesId);
	   List<com.servinglynk.hmis.warehouse.model.v2017.Disabilities> getAllEnrollmentDisabilitiess(UUID enrollmentId,Integer startIndex, Integer maxItems);
	   long getEnrollmentDisabilitiessCount(UUID enrollmentId);
}
