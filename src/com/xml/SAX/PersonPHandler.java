package com.xml.SAX;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonPHandler extends DefaultHandler{
	private List<Person> persons;
	private Person person;
	private String tag;
	
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<Person>();
		System.out.println("---解析文档开始----");
	}
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"解析开始");
		if(arg2 != null) {
			tag = arg2;
		}
		if(arg2.equals("person")) {
			person = new Person();
		}
	}
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		String contents = new String(arg0,arg1,arg2).trim();
		if(contents.length()>0) {
			System.out.println("内容为："+contents);	
		}
		if(tag != null) {
			if(tag.equals("name")) {
				person.setName(contents);
			}else if(tag.equals("age")){
				if(contents.length()>0) {
					person.setAge(Integer.valueOf(contents));
				}
			}
		}
		
			
		
	}
	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(arg2+"解析结束");
		if(arg2 != null) {
			if(arg2.equals("person")) {
				persons.add(person);
			}
		}
		tag = null;//丢弃
	}
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("---解析文档结结束----");
	}
}
