package com.xml.SAX;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Sax����������ֵ
 * @author С��
 *
 */
public class XmlSaxTest1 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		//Sax����
		//1.��ȡ��������
		SAXParserFactory spf = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser sp = spf.newSAXParser();
		//3.�����ĵ� Document ע�ᴦ����
	
		//4.�����ĵ� Document ע�ᴦ����
		PersonPHandler handler = new PersonPHandler();
		//5.����
		sp.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohe/xml/p.xml"),handler);
		//��ȡ����
		List<Person> persons = handler.getPersons();
		for(Person p:persons) {
			System.out.println(p.getAge());
			System.out.println(p.getName());
		}
	
	}

}
