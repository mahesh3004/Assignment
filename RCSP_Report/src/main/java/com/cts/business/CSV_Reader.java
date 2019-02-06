package com.cts.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.cts.dao.RCSP_Record_Dao;

public class CSV_Reader {

	public List<RCSP_Record_Dao> readCSVFromPath(String FilePath) {

		BufferedReader br = null;
		String line = null;
		final String COMMA_DEL = ",";
		List<RCSP_Record_Dao> returnList = new ArrayList<RCSP_Record_Dao>();

		try {
			br = new BufferedReader(new FileReader(FilePath));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] tmpArray = line.split(COMMA_DEL);
				RCSP_Record_Dao dao = new RCSP_Record_Dao();
				dao.setReference(Integer.parseInt(tmpArray[0]));
				dao.setAccountNumber(tmpArray[1]);
				dao.setDescription(tmpArray[2]);
				dao.setStart_Balance(Double.parseDouble(tmpArray[3]));
				dao.setMutation(Double.parseDouble(tmpArray[4]));
				dao.setEnd_Balance(Double.parseDouble(tmpArray[5]));

				returnList.add(dao);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnList;
	}
}
