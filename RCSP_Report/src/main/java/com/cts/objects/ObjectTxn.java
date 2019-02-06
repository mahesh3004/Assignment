package com.cts.objects;

import com.cts.dao.RCSP_Record_Dao;
import java.util.List;

public class ObjectTxn {

	List<RCSP_Record_Dao> hotList;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<RCSP_Record_Dao> getHotList() {
		return hotList;
	}

	public void setHotList(List<RCSP_Record_Dao> hotList) {
		this.hotList = hotList;
	}

}
