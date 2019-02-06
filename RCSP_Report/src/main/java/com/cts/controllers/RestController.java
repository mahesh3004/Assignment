package com.cts.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cts.business.FileReader;
import com.cts.objects.ObjectTxn;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public ObjectTxn getData() {

		FileReader fr = new FileReader();
		return fr.getFileProcessingResult();
	}
}
