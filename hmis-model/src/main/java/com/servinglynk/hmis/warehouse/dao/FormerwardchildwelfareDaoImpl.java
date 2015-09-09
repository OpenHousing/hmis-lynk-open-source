/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardchildwelfareDaoImpl extends ParentDaoImpl implements
		FormerwardchildwelfareDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FormerWardChildWelfare> formerWardChildWelfares = domain.getExport().getFormerWardChildWelfare();
		if(formerWardChildWelfares !=null && !formerWardChildWelfares.isEmpty() ) 
		{
			for(FormerWardChildWelfare formerWardChildWelfare : formerWardChildWelfares)
			{
				Formerwardchildwelfare formerwardchildwelfareModel = new Formerwardchildwelfare();
				formerwardchildwelfareModel.setId(UUID.randomUUID());
				formerwardchildwelfareModel.setChildwelfaremonths(BasicDataGenerator.getIntegerValue(formerWardChildWelfare.getChildWelfareMonths()));
				formerwardchildwelfareModel.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getChildWelfareYears())));
				formerwardchildwelfareModel.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getFormerWardChildWelfare())));
				formerwardchildwelfareModel.setDateCreated(BasicDataGenerator.getLocalDate(formerWardChildWelfare.getDateCreated()));
				formerwardchildwelfareModel.setDateUpdated(BasicDataGenerator.getLocalDate(formerWardChildWelfare.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(formerWardChildWelfare.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				formerwardchildwelfareModel.setExport(exportEntity);
				formerwardchildwelfareModel.setEnrollmentid(enrollmentModel);
				exportEntity.addFormerwardchildwelfare(formerwardchildwelfareModel);
				insertOrUpdate(formerwardchildwelfareModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Formerwardchildwelfare> formerwardchildwelfares = export.getFormerwardchildwelfares();
		if(formerwardchildwelfares != null && !formerwardchildwelfares.isEmpty()) {
			for(Formerwardchildwelfare formerwardchildwelfare : formerwardchildwelfares) {
				if(formerwardchildwelfare !=null) {
					com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare target = new com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare();
					BeanUtils.copyProperties(formerwardchildwelfare, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

}