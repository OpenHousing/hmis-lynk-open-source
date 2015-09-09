package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Site;
import com.servinglynk.hmis.warehouse.enums.SitePrincipalSiteEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class SiteDaoImpl extends ParentDaoImpl implements SiteDao {

	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Site> sites = domain.getExport().getSite();
		if(sites !=null && !sites.isEmpty()) {
			for(Site site :sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.staging.Site siteModel = new com.servinglynk.hmis.warehouse.model.staging.Site();
					siteModel.setAddress(site.getAddress());
					siteModel.setCity(site.getCity());
					siteModel.setDateCreated(BasicDataGenerator.getLocalDate(site.getDateCreated()));
					siteModel.setDateUpdated(BasicDataGenerator.getLocalDate(site.getDateUpdated()));
					siteModel.setGeocode(site.getGeocode());
					siteModel.setPrincipalSite(SitePrincipalSiteEnum.lookupEnum(BasicDataGenerator.getStringValue(site.getPrincipalSite())));
//					Projectcoc projectCoc = (Projectcoc) get(Projectcoc.class,domain.getProjectCocMap().get(site.getProjectCoCID()));
//					siteModel.setProjectCoc(projectCoc);
					siteModel.setState(StateEnum.lookupEnum(site.getState()));
					com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
					siteModel.setExport(exportEntity);
					siteModel.setId(UUID.randomUUID());
					//site.getUserID()
					siteModel.setZip(String.valueOf(site.getZIP()));
					exportEntity.addSite(siteModel);
					insertOrUpdate(siteModel);
				}
			}
			
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Site> sites = export.getSites();
		if(sites !=null && !sites.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Site site : sites) {
				if(site !=null) {
					com.servinglynk.hmis.warehouse.model.live.Site target = new com.servinglynk.hmis.warehouse.model.live.Site();
					BeanUtils.copyProperties(site, target, getNonCollectionFields(target));
					insert(target);
				}
			}
		}
	}

}