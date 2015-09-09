/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HousingAssessmentDisposition;
import com.servinglynk.hmis.warehouse.enums.HousingassessmentdispositionAssessmentdispositionEnum;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HousingassessmentdispositionDaoImpl extends ParentDaoImpl
		implements HousingassessmentdispositionDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<HousingAssessmentDisposition> housingAssessmentDispositions = domain.getExport().getHousingAssessmentDisposition();
		if(housingAssessmentDispositions !=null && !housingAssessmentDispositions.isEmpty()) 
		{
			for(HousingAssessmentDisposition housingAssessmentDisposition : housingAssessmentDispositions)
			{
				Housingassessmentdisposition housingassessmentdispositionModel = new Housingassessmentdisposition();
				housingassessmentdispositionModel.setId(UUID.randomUUID());
				housingassessmentdispositionModel.setDateCreated(BasicDataGenerator.getLocalDate(housingAssessmentDisposition.getDateCreated()));
				housingassessmentdispositionModel.setDateUpdated(BasicDataGenerator.getLocalDate(housingAssessmentDisposition.getDateUpdated()));
				housingassessmentdispositionModel.setAssessmentdisposition(HousingassessmentdispositionAssessmentdispositionEnum.lookupEnum(BasicDataGenerator.getStringValue(housingAssessmentDisposition.getAssessmentDisposition())));
				housingassessmentdispositionModel.setOtherdisposition(housingAssessmentDisposition.getOtherDisposition());
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(housingAssessmentDisposition.getExitID()));
				housingassessmentdispositionModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				housingassessmentdispositionModel.setExport(exportEntity);
				exportEntity.addHousingassessmentdisposition(housingassessmentdispositionModel);
				insertOrUpdate(housingassessmentdispositionModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Housingassessmentdisposition> housingassessmentdispositions = export.getHousingassessmentdispositions();
		if(housingassessmentdispositions !=null && !housingassessmentdispositions.isEmpty()) {
			for(Housingassessmentdisposition housingassessmentdisposition : housingassessmentdispositions) {
				if(housingassessmentdisposition !=null) {
					com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition target = new com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition();
					BeanUtils.copyProperties(housingassessmentdisposition, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

}