package com.iteris.main;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	static String ddlUsedInProcedure = "ItemClsnIdSk DECIMAL(8,0),\r\n"
			+ "      ItemClsnId SMALLINT,\r\n"
			+ "      ItemClsnCdId SMALLINT,\r\n"
			+ "      ItemClsnCdIdSk DECIMAL(12,0),\r\n"
			+ "      MdlId CHAR(25) CHARACTER SET LATIN NOT CASESPECIFIC,\r\n"
			+ "      MdlIdSk CHAR(31) CHARACTER SET LATIN NOT CASESPECIFIC,\r\n"
			+ "      VendId DECIMAL(10,0),\r\n"
			+ "      ItemColorId CHAR(10) CHARACTER SET LATIN NOT CASESPECIFIC,\r\n"
			+ "      CeaWkId INTEGER,\r\n"
			+ "      CEAWeekIDL2Y INTEGER,\r\n"
			+ "      CEAYearID INTEGER,\r\n"
			+ "      MdlTratValIdSk INTEGER,\r\n"
			+ "      AsrtSeasonId INTEGER,\r\n"
			+ "      SsonId SMALLINT NOT NULL,\r\n"
			+ "      PhId SMALLINT NOT NULL,\r\n"
			+ "      PrcRngIdSk INTEGER NOT NULL,\r\n"
			+ "      L2YCmprLocTotStkItemInvQt INTEGER,\r\n"
			+ "      L2YCmprLocTotStkItemInvMrkQt INTEGER,\r\n"
			+ "      L2YCmprLocTotStkItemInvRevnAmt DECIMAL(18,6),\r\n"
			+ "      L2YCmprLocTotStkItemInvMrkRevnAmt DECIMAL(18,6),\r\n"
			+ "      L2YCmprLocMkdownStkAmt DECIMAL(18,6),\r\n"
			+ "      L2YTotStrStkItemInvQt INTEGER NOT NULL,\r\n"
			+ "      L2YTotStrStkItemInvRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L2YTotStkItemInvCostAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L2YTotStkItemInvQt INTEGER,\r\n"
			+ "      L2YTotStkItemInvMrkQt INTEGER,\r\n"
			+ "      L2YTotStkItemInvRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L2YTotStkItemInvMrkRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L2YMkdownStkAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L2YOrigMdlPrcAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YCmprLocTotStkItemInvQt INTEGER,\r\n"
			+ "      L3YCmprLocTotStkItemInvMrkQt INTEGER,\r\n"
			+ "      L3YCmprLocTotStkItemInvRevnAmt DECIMAL(18,6),\r\n"
			+ "      L3YCmprLocTotStkItemInvMrkRevnAmt DECIMAL(18,6),\r\n"
			+ "      L3YCmprLocMkdownStkAmt DECIMAL(18,6),\r\n"
			+ "      L3YTotStrStkItemInvQt INTEGER NOT NULL,\r\n"
			+ "      L3YTotStrStkItemInvRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YTotStkItemInvCostAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YTotStkItemInvQt INTEGER,\r\n"
			+ "      L3YTotStkItemInvMrkQt INTEGER,\r\n"
			+ "      L3YTotStkItemInvRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YTotStkItemInvMrkRevnAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YMkdownStkAmt DECIMAL(18,6) NOT NULL,\r\n"
			+ "      L3YOrigMdlPrcAmt DECIMAL(18,6) NOT NULL";
	
	static String executionSimulationMappingResult = "\"ItemClsnIdSk\",\r\n"
			+ "	\"ItemClsnId\",\r\n"
			+ "	\"ItemClsnCdId\",\r\n"
			+ "	\"ItemClsnCdIdSk\",\r\n"
			+ "	\"MdlId\",\r\n"
			+ "	\"MdlIdSk\",\r\n"
			+ "	\"VendId\",\r\n"
			+ "	\"ItemColorId\",\r\n"
			+ "	\"CeaWkId\",\r\n"
			+ "	\"CEAWeekIDL2Y\",\r\n"
			+ "	\"CEAYearID\",\r\n"
			+ "	\"MdlTratValIdSk\",\r\n"
			+ "	\"AsrtSeasonId\",\r\n"
			+ "	\"SsonId\",\r\n"
			+ "	\"PhId\",\r\n"
			+ "	\"PrcRngIdSk\",\r\n"
			+ "	\"L2YCmprLocTotStkItemInvQt\",\r\n"
			+ "	\"L2YCmprLocTotStkItemInvMrkQt\",\r\n"
			+ "	\"L2YCmprLocTotStkItemInvRevnAmt\",\r\n"
			+ "	\"L2YCmprLocTotStkItemInvMrkRevnAmt\",\r\n"
			+ "	\"L2YCmprLocMkdownStkAmt\",\r\n"
			+ "	\"L2YTotStrStkItemInvQt\",\r\n"
			+ "	\"L2YTotStrStkItemInvRevnAmt\",\r\n"
			+ "	\"L2YTotStkItemInvCostAmt\",\r\n"
			+ "	\"L2YTotStkItemInvQt\",\r\n"
			+ "	\"L2YTotStkItemInvMrkQt\",\r\n"
			+ "	\"L2YTotStkItemInvRevnAmt\",\r\n"
			+ "	\"L2YTotStkItemInvMrkRevnAmt\",\r\n"
			+ "	\"L2YMkdownStkAmt\",\r\n"
			+ "	\"L2YOrigMdlPrcAmt\",\r\n"
			+ "	\"L3YCmprLocTotStkItemInvQt\",\r\n"
			+ "	\"L3YCmprLocTotStkItemInvMrkQt\",\r\n"
			+ "	\"L3YCmprLocTotStkItemInvRevnAmt\",\r\n"
			+ "	\"L3YCmprLocTotStkItemInvMrkRevnAmt\",\r\n"
			+ "	\"L3YCmprLocMkdownStkAmt\",\r\n"
			+ "	\"L3YTotStrStkItemInvQt\",\r\n"
			+ "	\"L3YTotStrStkItemInvRevnAmt\",\r\n"
			+ "	\"L3YTotStkItemInvCostAmt\",\r\n"
			+ "	\"L3YTotStkItemInvQt\",\r\n"
			+ "	\"L3YTotStkItemInvMrkQt\",\r\n"
			+ "	\"L3YTotStkItemInvRevnAmt\",\r\n"
			+ "	\"L3YTotStkItemInvMrkRevnAmt\",\r\n"
			+ "	\"L3YMkdownStkAmt\",\r\n"
			+ "	\"L3YOrigMdlPrcAmt\" ";

	public static void main(String[] args) {
		
		executionSimulationMappingResult = executionSimulationMappingResult.replaceAll("\"", "").replaceAll(",", "");
		
		List<String> fieldsCreateList = generateListFields(ddlUsedInProcedure);
		List<String> executionFields = generateListFields(executionSimulationMappingResult);
		
		executionFields.removeAll(fieldsCreateList);
		
		
		for(String f : executionFields) {
			System.out.println(f);
		}
	}
	
	public static List<String> generateListFields(String fields) {
		String[] fieldsArray = fields.trim().split("\r\n");
		List<String> fieldsList = new ArrayList<String>();
		
		
		for(String fieldCreate : fieldsArray) {
			String value = fieldCreate.trim().split(" ")[0];
			fieldsList.add(value);
		}
		
		return fieldsList;
	}

}
