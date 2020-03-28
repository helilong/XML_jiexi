package com.xml.JDOM;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.*;
import org.jdom.input.SAXBuilder;

/**
 * 使用jdom方法解析 读取xml数据
 * @author 小贺
 *
 */
public class ReadXML {
	public static void main(String[] args) throws JDOMException, IOException {	
		//创建解析器
		SAXBuilder sb=new SAXBuilder();
		//调用build方法解析xml文件，得到文档对象
		 Document doc= sb.build(new File("D:/web.xml"));
		//根据文档对象拿到根节点
		Element root = doc.getRootElement();
		//根据根节点得到下面的子节点
		List<Element> list = root.getChildren();
		//遍历
		for (Element element : list) {
			System.out.println(element.getAttributeValue("stuno")+"\t"+element.getChildText("name")+"\t"+element.getChildText("sex")+"\t"+element.getChildText("age"));
		}
	}
}
