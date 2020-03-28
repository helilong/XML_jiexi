package com.xml.DOM4J;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用dom4j读取xml中的数据
 * @author 小贺
 *
 */
public class ReadXML {
public static void main(String[] args) throws DocumentException {
	//创建解析器对象
	SAXReader  reader=new SAXReader();
	//得到文档对象
	Document doc=reader.read(new File("D:/web.xml"));
	//得到根节点对象
	Element root=doc.getRootElement();
	//得到子元素
	List<Element> list=root.elements();	
	//  迭代器
	Iterator<Element> it=root.elementIterator();
	while(it.hasNext()){
		Element gi=it.next();
		System.out.println(gi.attributeValue("gid")+"\t"+gi.elementText("name")+"\t"+gi.elementText("price")+"\t"+gi.elementText("number"));
	}
}
}
