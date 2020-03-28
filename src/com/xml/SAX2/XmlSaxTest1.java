package com.xml.SAX2;

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
		WebPHandler handler = new WebPHandler();
		//5.����
		sp.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohe/xml2/web.xml"),handler);
		//��ȡ����
		List<Entity> entitys = handler.getEntitys();
		for(Entity e:entitys) {
			System.out.println(e.getClz());
			System.out.println(e.getName());
		}
		
		List<Mapping> mappings = handler.getMappings();
		for(Mapping e:mappings) {
			System.out.println(e.getPatterns());
			System.out.println(e.getName());
		}
		WebContext webcontext = new WebContext(handler.getEntitys(),handler.getMappings());
	}

}
