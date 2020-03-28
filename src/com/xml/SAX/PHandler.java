package com.xml.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("---解析文档开始----");
	}
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"解析开始");
	}
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(arg0,arg1,arg2).trim();
		if(contents.length()>0) {
			System.out.println("内容为："+contents);	
		}
		
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"解析结束");
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("---解析文档结结束----");
	}
}
