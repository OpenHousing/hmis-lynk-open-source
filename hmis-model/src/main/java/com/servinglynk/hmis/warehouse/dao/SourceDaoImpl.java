/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.rmi.server.ExportException;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.model.staging.Export;

/**
 * @author Sandeep
 *
 */
public class SourceDaoImpl extends ParentDaoImpl implements SourceDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Source source = domain.getSource();
		com.servinglynk.hmis.warehouse.model.staging.Source sourceModel = new com.servinglynk.hmis.warehouse.model.staging.Source();
		sourceModel.setSoftwarevendor(source.getSoftwareVendor());
		//sourceModel.setSoftwareversion(BasicDataGenerator.getStringValue(source.getSoftwareVersion()));
		sourceModel.setSourcecontactemail(source.getSourceContactEmail());
		sourceModel.setSourcecontactextension(String.valueOf(source.getSourceContactExtension()));
		sourceModel.setSourcecontactfirst(source.getSourceContactFirst());
		sourceModel.setSourcecontactlast(source.getSourceContactLast());
		sourceModel.setSourceid(String.valueOf(source.getSourceID()));
		sourceModel.setSourcename(source.getSourceName());
		UUID id = UUID.randomUUID();
		domain.setSourceId(id);
		sourceModel.setId(id);
		insertOrUpdate(sourceModel);
	}

	@Override
	public void hydrateLive(Export export) {
		// TODO Auto-generated method stub
		com.servinglynk.hmis.warehouse.model.staging.Source source = export.getSource();
		if(source !=null) {
			com.servinglynk.hmis.warehouse.model.live.Source target = new com.servinglynk.hmis.warehouse.model.live.Source();
			BeanUtils.copyProperties(source, target, getNonCollectionFields(target));
			insert(target);
		}
	}
	
}