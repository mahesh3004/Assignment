package com.cts.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.cts.dao.RCSP_Record_Dao;

public class XML_Reader {

	public List<RCSP_Record_Dao> readXMLFromPath(String FilePath) {

		List<RCSP_Record_Dao> returnList = new ArrayList<RCSP_Record_Dao>();

		try {

			File fXmlFile = new File(FilePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("record");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					RCSP_Record_Dao dao = new RCSP_Record_Dao();

					dao.setReference((Integer.parseInt(eElement.getAttribute("reference"))));
					dao.setAccountNumber(eElement.getElementsByTagName("accountNumber").item(0).getTextContent());
					dao.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
					dao.setStart_Balance(
							Double.parseDouble(eElement.getElementsByTagName("startBalance").item(0).getTextContent()));
					dao.setMutation(
							Double.parseDouble(eElement.getElementsByTagName("mutation").item(0).getTextContent()));
					dao.setEnd_Balance(
							Double.parseDouble(eElement.getElementsByTagName("endBalance").item(0).getTextContent()));

					returnList.add(dao);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnList;
	}
}
