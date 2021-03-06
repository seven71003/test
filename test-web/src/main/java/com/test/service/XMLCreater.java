package com.test.service;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author ：qixuewei@jinlianchu.com
 * @Description ：
 * @ClassName ：XMLCreater
 * @date ：2018/2/26 16:07
 */
public class XMLCreater {

	public static String createXML(){
		String strXML = null;
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");

		Element phone = root.addElement("TelePhone");
		Element nokia = phone.addElement("type");
		nokia.addAttribute("name", "nokia");
		Element price_nokia = nokia.addElement("price");
		price_nokia.addText("599");
		Element operator_nokia = nokia.addElement("operator");
		operator_nokia.addText("CMCC");
		Element xiaomi = phone.addElement("type");
		xiaomi.addAttribute("name", "xiaomi");
		Element price_xiaomi = xiaomi.addElement("price");
		price_xiaomi.addText("699");
		Element operator_xiaomi = xiaomi.addElement("operator");
		operator_xiaomi.addText("ChinaNet");

		StringWriter strWtr = new StringWriter();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter =new XMLWriter(strWtr, format);
		try {
			xmlWriter.write(document);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		strXML = strWtr.toString();

		File file = new File("TelePhone.xml");
		if (file.exists()) {
			file.delete();
		}
		try {
			file.createNewFile();
			XMLWriter out = new XMLWriter(new FileWriter(file));
			out.write(document);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(strXML);
		return strXML;
	}
}
