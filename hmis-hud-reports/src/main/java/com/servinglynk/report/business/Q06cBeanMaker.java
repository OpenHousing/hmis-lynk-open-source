package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.servinglynk.report.bean.Q06cDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ExitModel;
import com.servinglynk.report.model.IncomeAndSourceModel;

import jodd.util.StringUtil;

public class Q06cBeanMaker {

	public static Long destinationErroCount;
	public static Long iseErrorCount;
	public static Long isaaErrorCount;
	public static Long isaeErrorCount;
	
	public static List<Q06cDataBean> getQ06cPointInTimeCountPersonsLastWednesdayList(ReportData data){
		
		Q06cDataBean q06cDataBean =new Q06cDataBean();
		List<ExitModel> exits = data.getExits();
		exits.parallelStream().forEach(exit -> { 
			
			if(StringUtil.equals("8", exit.getDestination()) || StringUtil.equals("9", exit.getDestination()) || StringUtil.equals("30", exit.getDestination())
					|| StringUtil.equals("99", exit.getDestination())
					) {
				destinationErroCount++;
			}
		}
		);
		List<IncomeAndSourceModel> incomeAndSources = data.getIncomeAndSources();
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtil.equals("1", incomeAndSource.getDataCollectionStage()) ) {
				iseErrorCount++;
			}
		}
		);
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtil.equals("3", incomeAndSource.getDataCollectionStage()) ) {
				isaeErrorCount++;
			}
		}
		);
		incomeAndSources.parallelStream().forEach(incomeAndSource -> { 
			
			if(StringUtil.equals("5", incomeAndSource.getDataCollectionStage()) ) {
				isaaErrorCount++;
			}
		}
		);
		q06cDataBean.setDestinationStatusErrorCount(BigInteger.valueOf(destinationErroCount));
		q06cDataBean.setDestinationStatusErrorRate(BigInteger.valueOf(destinationErroCount/exits.size() ));
		q06cDataBean.setIseErrorCount(BigInteger.valueOf(iseErrorCount));
		q06cDataBean.setIseErrorRate(BigInteger.valueOf(0));
		q06cDataBean.setIsaaErrorCount(BigInteger.valueOf(isaaErrorCount));
		q06cDataBean.setIsaaErrorRate(BigInteger.valueOf(0));
		q06cDataBean.setIsaeErrorCount(BigInteger.valueOf(isaeErrorCount));
		q06cDataBean.setIsaeErrorRate(BigInteger.valueOf(0));
		
		return Arrays.asList(q06cDataBean);
	}
	
}