package com.xml.JDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * 利用jdom修改webxml里面的数据
 * 
 * @author 小贺
 *
 */
public class UpdataXML {
public static void main(String[] args) throws FileNotFoundException, IOException, JDOMException {
	//创建解析器
	SAXBuilder builder=new SAXBuilder();
	//调用build方法解析xml文件 ，得到文档对象
	Document doc=builder.build(new File("D:/web.xml"));
	//根据文档对象 拿到根节点
	Element root=doc.getRootElement();
	//根据根节点得到下面的子节点
	List<Element> list=root.getChildren();
	for (Element stu : list) {
		if("1".equals(stu.getAttributeValue("stuno"))){
			stu.getChild("name").setText("小贺");
			stu.getChild("sex").setText("男");
			stu.getChild("age").setText("20");
			}
		}
	//将文档对象写入到xml文件中
	XMLOutputter xo=new XMLOutputter();
	xo.output(doc,new FileOutputStream(new File("E:/stu.xml")));
	}
}
