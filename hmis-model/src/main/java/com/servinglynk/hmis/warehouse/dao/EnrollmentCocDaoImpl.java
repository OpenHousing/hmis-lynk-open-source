/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentCocDaoImpl extends ParentDaoImpl implements
		EnrollmentCocDao {
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		if(enrollmentCoCs!=null)
		{
			for(EnrollmentCoC enrollmentCoc : enrollmentCoCs)
			{
				EnrollmentCoc enrollmentCocModel = new EnrollmentCoc();
				enrollmentCocModel.setId(UUID.randomUUID());
				//enrollmentCocModel.setCocCode(enrollmentCoc.get;
				//enrollmentCocModel.setProjectCoId(projectCoId);
				//enrollmentCocModel.setProjectCoId(projectCoId);
				enrollmentCocModel.setDateCreated(BasicDataGenerator.getLocalDate(enrollmentCoc.getDateCreated()));
				enrollmentCocModel.setDateUpdated(BasicDataGenerator.getLocalDate(enrollmentCoc.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(enrollmentCoc.getProjectEntryID()));
				enrollmentCocModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				enrollmentCocModel.setExport(exportEntity);
				exportEntity.addEnrollmentCoc(enrollmentCocModel);
				insertOrUpdate(enrollmentCocModel);
			}
			factory.getProjectcocDao().hydrateStaging(domain);
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<EnrollmentCoc> enrollmentCocs = export.getEnrollmentCocs();
		if(enrollmentCocs !=null && !enrollmentCocs.isEmpty()) {
			for(EnrollmentCoc enrollmentCoc : enrollmentCocs) {
				if(enrollmentCoc != null) {
					com.servinglynk.hmis.warehouse.model.live.EnrollmentCoc target = new com.servinglynk.hmis.warehouse.model.live.EnrollmentCoc();
					BeanUtils.copyProperties(enrollmentCoc, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

}