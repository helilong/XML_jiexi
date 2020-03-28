package com.xml.SAX2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WebPHandler extends DefaultHandler{
	private List<Entity> entitys = new ArrayList<Entity>();
	private List<Mapping> mappings = new ArrayList<Mapping>();
	private Entity entity;
	private Mapping mapping;
	private String tag;  //�洢������ǩ
	
	private boolean isMapping = false;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("---�����ĵ���ʼ----");
	}
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"������ʼ");
		if(arg2 != null) {
			tag = arg2;
		}
		if(arg2.equals("servlet")) {
			entity = new Entity();
			isMapping = false;
		}else if(arg2.equals("servlet-mapping")) {
			mapping = new Mapping();
			isMapping = true;
		}
	}
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(arg0,arg1,arg2).trim();
		if(contents.length()>0) {
			System.out.println("����Ϊ��"+contents);	
		}
		if(tag != null) {
			if(isMapping) {
				//����mapping
				if(tag.equals("servlet-name")) {
					mapping.setName(contents);
				}else if(tag.equals("url-pattern")) {
					mapping.addPattern(contents);
				}
			}else {
				//����servlet
				if(tag.equals("servlet-name")) {
					entity.setName(contents);
				}else if(tag.equals("servlet-class")) {
					entity.setClz(contents);
				}
			}
			
		}
		
			
		
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"��������");
		if(arg2 != null) {
			if(arg2.equals("servlet")) {
				entitys.add(entity);
			}else if(arg2.equals("mapping")) {
				mappings.add(mapping);
			}
		}
		tag = null;//����
	}
	
	public List<Entity> getEntitys() {
		return entitys;
	}
	public List<Mapping> getMappings() {
		return mappings;
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("---�����ĵ������----");
	}
}
