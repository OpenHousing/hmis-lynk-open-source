package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitRHY;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYAssistanceMainstreamBenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYEarlyExitReasonEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYExitCounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFamilyReunificationAchievedEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYFurtherFollowUpServicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYOtherAftercarePlanOrActionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYPermanentHousingPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYResourcePackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYScheduledFollowUpContactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYTemporaryShelterPlacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitRHYWrittenAfterCarePlanEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ExitrhyDaoImpl extends ParentDaoImpl implements ExitrhyDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExitrhyDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class, getProjectGroupCode(domain));
		List<ExitRHY> exitrhys = export.getExitRHY();
		if (exitrhys != null && exitrhys.size() > 0) {
			for (ExitRHY exitrhy : exitrhys) {
				com.servinglynk.hmis.warehouse.model.v2017.Exitrhy exitrhyModel = null;
				try {
					exitrhyModel = getModelObject(domain, exitrhy,data,modelMap);
					exitrhyModel.setEarlyExitReason(ExitRHYEarlyExitReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(exitrhy.getEarlyExitReason())));
					exitrhyModel.setProjectCompletionStatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum( BasicDataGenerator.getStringValue(exitrhy.getProjectCompletionStatus())));
				//	exitrhyModel.setExchageForSex(EntryRHYExchangeForSexEnum.lookupEnum(exitrhy.getE));
//					exitrhyModel.setExchangeForSexPastThreeMonths(0);;
//					exitrhyModel.setCountOfExchangeForSex(0);
//					exitrhyModel.setAskedOrForcedToExchangeForSex(0);
//					exitrhyModel.setAskedOrForcedToExchangeForSexPastThreeMonths(0);
//					exitrhyModel.setWorkPlaceViolenceThreats(0);
//					exitrhyModel.setWorkPlacePromiseDifference(0);
//					exitrhyModel.setCoercedToContinueWork(0);
//					exitrhyModel.setLaborExploitPastThreeMonths(0);
//					exitrhyModel.setCounselingReceived(0);
//					exitrhyModel.setCounselingType(0);
//					exitrhyModel.setSessionCountAtExit(0);
//					exitrhyModel.setSessionsInPlan(0);
//					exitrhyModel.setPostExitCounselingPlan(0);
//					exitrhyModel.setDestinationSafeClient(0);
//					exitrhyModel.setDestinationSafeWorker(0);
//					exitrhyModel.setPosAdultConnections(0);
//					exitrhyModel.setPosPeerConnections(0);
//					exitrhyModel.setPosCommunityConnections(0);
//					
					
					com.servinglynk.hmis.warehouse.model.v2017.Exit exit = (com.servinglynk.hmis.warehouse.model.v2017.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2017.Exit.class,exitrhy.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					exitrhyModel.setExitid(exit);
					exitrhyModel.setDeleted(false);
					exitrhyModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitrhy.getDateCreated()));
					exitrhyModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitrhy.getDateUpdated()));
					exitrhyModel.setExport(exportEntity);
					exitrhyModel.setSync(false);
					performSaveOrUpdate(exitrhyModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the exitrhy::"+exitrhy.getExitRHYID() +" Exception ::"+e.getMessage();
					if(exitrhyModel != null){
						Error2017 error = new Error2017();
						error.model_id = exitrhyModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = exitrhyModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = exitrhyModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class.getSimpleName(), domain,exportEntity);
	}

	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy exitrhy) {
			if(exitrhy !=null) {
				com.servinglynk.hmis.warehouse.model.v2017.Exitrhy target = new com.servinglynk.hmis.warehouse.model.v2017.Exitrhy();
				BeanUtils.copyProperties(exitrhy, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) get(com.servinglynk.hmis.warehouse.model.v2017.Export.class, exitrhy.getExport().getId());
				exportEntity.addExitrhy(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2017.Exitrhy ExitrhyByDedupCliendId = getExitrhyByDedupExitrhyId(exitrhy.getId(),exitrhy.getProjectGroupCode());
				if(ExitrhyByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	public com.servinglynk.hmis.warehouse.model.v2017.Exitrhy getModelObject(ExportDomain domain, ExitRHY exitrhy ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Exitrhy modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Exitrhy) getModel(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class, exitrhy.getExitRHYID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Exitrhy();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Exitrhy model = new com.servinglynk.hmis.warehouse.model.v2017.Exitrhy();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitrhy.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,exitrhy.getExitRHYID(),data);
		return model;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Exitrhy createExitrhy(Exitrhy exitrhy) {
		exitrhy.setId(UUID.randomUUID());
			insert(exitrhy);
		return exitrhy;
	}


	@Override
	public Exitrhy updateExitrhy(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy exitrhy) {
			update(exitrhy);
		return exitrhy;
	}


	@Override
	public void deleteExitrhy(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy exitrhy) {
			delete(exitrhy);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Exitrhy getExitrhyById(UUID ExitrhyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);
		criteria.add(Restrictions.eq("id", ExitrhyId));
		List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy>) findByCriteria(criteria);
		if(exitrhy.size()>0) return exitrhy.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Exitrhy getExitrhyByDedupExitrhyId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy>) findByCriteria(criteria);
		if(exitrhy !=null && exitrhy.size()>0) return exitrhy.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> getAllExitrhy(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> exitrhy = (List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy>) findByCriteria(criteria,startIndex,maxItems);
		return exitrhy;
	}
	
	
	public long getExitrhyCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);	
		return countRows(criteria);
	}
	
	
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy> getAllExitExitrhys(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Exitrhy>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitExitrhysCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Exitrhy.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return countRows(criteria);
	   }


}
