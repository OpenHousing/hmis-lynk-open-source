package com.servinglynk.hmis.warehouse.upload.service;
import com.servinglynk.hmis.warehouse.upload.business.service.core.IParentService;

public interface IRollupWorker extends IParentService{
	public void processWorkerLine() throws Exception;

}