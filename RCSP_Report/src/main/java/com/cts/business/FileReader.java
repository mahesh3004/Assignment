package com.cts.business;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.cts.dao.RCSP_Record_Dao;
import com.cts.objects.ObjectTxn;
import com.cts.utils.PropertyLoader;

public class FileReader {

	public ObjectTxn getFileProcessingResult() {
		ObjectTxn returnObject = new ObjectTxn();

		Properties properties = PropertyLoader.getPropertiesFromResources();
		String FileName = properties.getProperty("FileName");

		if (FileName.length() < 3) {
			returnObject.setMessage("Invalid File");
		} else if (FileName.substring(FileName.length() - 3).equalsIgnoreCase("csv")) {
			CSV_Reader csvReader = new CSV_Reader();
			returnObject = invokeBusinessLogic(csvReader.readCSVFromPath(FileName));

		} else if (FileName.substring(FileName.length() - 3).equalsIgnoreCase("xml")) {
			XML_Reader xmlReader = new XML_Reader();
			returnObject = invokeBusinessLogic(xmlReader.readXMLFromPath(FileName));
		}
		return returnObject;
	}

	public ObjectTxn invokeBusinessLogic(List<RCSP_Record_Dao> srcDao) {

		Map<Integer, RCSP_Record_Dao> mapObject = new HashMap<Integer, RCSP_Record_Dao>();
		List<RCSP_Record_Dao> hotList = new ArrayList<RCSP_Record_Dao>();
		ObjectTxn returnObject = new ObjectTxn();

		for (RCSP_Record_Dao dao : srcDao) {
			if (mapObject.containsKey(dao.getReference())) {
				dao.setValid(false);
				dao.setRemarks("Reference Already Exists");
			} else {
				DecimalFormat df = new DecimalFormat("#.##");
				double calEndBal = Double.parseDouble(df.format(dao.getStart_Balance() + dao.getMutation()));
				if (calEndBal == dao.getEnd_Balance()) {
					dao.setValid(true);
					dao.setRemarks("valid Record");
					mapObject.put(dao.getReference(), dao);

				} else {
					dao.setValid(false);
					dao.setRemarks("Incorrect End Balance");
					mapObject.put(dao.getReference(), dao);
				}
			}

			if (!dao.isValid()) {
				hotList.add(dao);
			}
		}
		returnObject.setHotList(hotList);
		returnObject.setMessage("success");
		return returnObject;
	}
}
