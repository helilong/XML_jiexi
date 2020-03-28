package com.xml.DOM4J;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM4J  将数据写入到指定的xml
 * @author 小贺
 *
 */
public class writeXML {
public static void main(String[] args) throws IOException {
	//创建文档对象
	Document doc=DocumentHelper.createDocument();
	//使用文档对象创建根节点
	Element root=doc.addElement("root");
	//使用根节点创建子节点
	Element goodsInfo=root.addElement("goodsInfo");
	Element name=root.addElement("name");
	Element price=root.addElement("price");
	Element number=root.addElement("number");
	//封装数据
	goodsInfo.addAttribute("gid","1");
	name.addText("小贺");
	price.addText("20");
	number.addText("100");
	//写入
	XMLWriter xw=new XMLWriter(new FileOutputStream(new File("D:/web.xml")));
	xw.write(doc);
	xw.close();
	System.out.println("成功");
}
}
