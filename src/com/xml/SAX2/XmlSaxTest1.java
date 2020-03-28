package com.xml.SAX2;

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
		WebPHandler handler = new WebPHandler();
		//5.解析
		sp.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/xiaohe/xml2/web.xml"),handler);
		//获取数据
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
