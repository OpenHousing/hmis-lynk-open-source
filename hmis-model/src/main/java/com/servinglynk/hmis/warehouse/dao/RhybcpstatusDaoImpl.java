/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class RhybcpstatusDaoImpl extends ParentDaoImpl implements
		RhybcpstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<RHYBCPStatus> rhybcpStatusList = domain.getExport().getRHYBCPStatus();
		if(rhybcpStatusList !=null && !rhybcpStatusList.isEmpty())
		{
			for(RHYBCPStatus rhybcpStatus : rhybcpStatusList)
			{
				Rhybcpstatus rhybcpstatusModel = new Rhybcpstatus();
				UUID id = UUID.randomUUID();
				rhybcpstatusModel.setId(id);
				rhybcpstatusModel.setDateCreated(BasicDataGenerator.getLocalDate(rhybcpStatus.getDateCreated()));
				rhybcpstatusModel.setDateUpdated(BasicDataGenerator.getLocalDate(rhybcpStatus.getDateUpdated()));
				rhybcpstatusModel.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getFYSBYouth())));
				rhybcpstatusModel.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getReasonNoServices())));
				rhybcpstatusModel.setStatusDate(BasicDataGenerator.getLocalDate(rhybcpStatus.getStatusDate()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(rhybcpStatus.getProjectEntryID()));
				rhybcpstatusModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				rhybcpstatusModel.setExport(exportEntity);
				exportEntity.addRhybcpstatus(rhybcpstatusModel);
				insertOrUpdate(rhybcpstatusModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Rhybcpstatus> rhybcpstatuses = export.getRhybcpstatuses();
		if(rhybcpstatuses !=null && !rhybcpstatuses.isEmpty()) {
			for(Rhybcpstatus rhybcpstatus : rhybcpstatuses) {
				if(rhybcpstatus !=null) {
					com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus target = new com.servinglynk.hmis.warehouse.model.live.Rhybcpstatus();
					BeanUtils.copyProperties(rhybcpstatus, target, getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

}