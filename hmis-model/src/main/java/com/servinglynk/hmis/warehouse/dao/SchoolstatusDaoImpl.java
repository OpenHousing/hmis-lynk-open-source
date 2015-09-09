/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SchoolStatus;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Schoolstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SchoolstatusDaoImpl extends ParentDaoImpl implements
		SchoolstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<SchoolStatus> schoolStatusList = domain.getExport().getSchoolStatus();
		if(schoolStatusList!=null && !schoolStatusList.isEmpty())
		{
			for(SchoolStatus schoolStatus : schoolStatusList)
			{
			Schoolstatus schoolstatusModel = new Schoolstatus();
			UUID id = UUID.randomUUID();
			schoolstatusModel.setId(id);
			schoolstatusModel.setDateCreated(BasicDataGenerator.getLocalDate(schoolStatus.getDateCreated()));
			schoolstatusModel.setDateUpdated(BasicDataGenerator.getLocalDate(schoolStatus.getDateUpdated()));
			schoolstatusModel.setInformationDate(BasicDataGenerator.getLocalDate(schoolStatus.getInformationDate()));
			schoolstatusModel.setSchoolStatus(BasicDataGenerator.getIntegerValue(schoolStatus.getSchoolStatus()));
			Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(schoolStatus.getProjectEntryID()));
			schoolstatusModel.setEnrollmentid(enrollmentModel);
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
			schoolstatusModel.setExport(exportEntity);
			exportEntity.addSchoolstatus(schoolstatusModel);
			insertOrUpdate(schoolstatusModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Schoolstatus> schoolstatuses = export.getSchoolstatuses();
		if(schoolstatuses !=null && !schoolstatuses.isEmpty()) {
			for(Schoolstatus schoolstatus : schoolstatuses) {
				if(schoolstatus != null) {
					com.servinglynk.hmis.warehouse.model.live.Schoolstatus target = new com.servinglynk.hmis.warehouse.model.live.Schoolstatus();
					BeanUtils.copyProperties(schoolstatus, target, getNonCollectionFields(target));
					insert(target);
				}
			}
		}
	}

}