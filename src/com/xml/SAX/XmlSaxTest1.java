package com.xml.SAX;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * Sax解析并保存值
 * @author 小贺
 *
 */
public class XmlSaxTest1 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		//Sax解析
		//1.获取解析工厂
		SAXParserFactory spf = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser sp = spf.newSAXParser();
		//3.加载文档 Document 注册处理器
	
		//4.加载文档 Document 注册处理器
		PersonPHandler handler = new PersonPHandler();
		//5.解析
		sp.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohe/xml/p.xml"),handler);
		//获取数据
		List<Person> persons = handler.getPersons();
		for(Person p:persons) {
			System.out.println(p.getAge());
			System.out.println(p.getName());
		}
	
	}

}
