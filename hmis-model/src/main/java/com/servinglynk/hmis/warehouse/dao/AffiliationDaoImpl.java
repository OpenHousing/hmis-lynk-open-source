package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Affiliation;
import com.servinglynk.hmis.warehouse.model.staging.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class AffiliationDaoImpl extends ParentDaoImpl implements AffiliationDao {

		@Override
		public void hydrateStaging(ExportDomain domain) 
		{
			Export export = domain.getExport();
			List<Affiliation> affiliations = export.getAffiliation();
			if(affiliations!=null && !affiliations.isEmpty())
			{
				for(Affiliation affiliation :affiliations )
				{
					com.servinglynk.hmis.warehouse.model.staging.Affiliation affiliationModel = new com.servinglynk.hmis.warehouse.model.staging.Affiliation();
					affiliationModel.setId(UUID.randomUUID());
					affiliationModel.setResprojectid(affiliation.getResProjectID());
					affiliationModel.setDateCreated(BasicDataGenerator.getLocalDate(affiliation.getDateCreated()));
					affiliationModel.setDateUpdated(BasicDataGenerator.getLocalDate(affiliation.getDateUpdated()));
					Project project = (Project) get(Project.class,domain.getAffiliationProjectMap().get(affiliation.getProjectID()));
					affiliationModel.setProjectid(project);
					com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
					affiliationModel.setExport(exportEntity);
					exportEntity.addAffiliation(affiliationModel);
					insertOrUpdate(affiliationModel);
				}
			}
		}

		@Override
		public void hydrateLive(
				com.servinglynk.hmis.warehouse.model.staging.Export export) {
			Set<com.servinglynk.hmis.warehouse.model.staging.Affiliation> affiliations = export.getAffiliations();
			if(affiliations !=null && !affiliations.isEmpty()) {
				for(com.servinglynk.hmis.warehouse.model.staging.Affiliation affiliation : affiliations ) {
					 com.servinglynk.hmis.warehouse.model.live.Affiliation target = new com.servinglynk.hmis.warehouse.model.live.Affiliation();
					 BeanUtils.copyProperties(affiliation, target,getNonCollectionFields(target));
					 insert(target);
				}
			}
		}
}
