package com.xml.SAX;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
/**
 * Sax����
 * @author С��
 *
 */
public class XmlSaxTest {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		//Sax����
		//1.��ȡ��������
		SAXParserFactory spf = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser sp = spf.newSAXParser();
		//3.�����ĵ� Document ע�ᴦ����
	
		//4.�����ĵ� Document ע�ᴦ����
		PHandler handler = new PHandler();
		//5.����
		sp.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohe/xml/p.xml"),handler);
	}

}
