package com.xml.JDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * 使用JDOM方式解析  写入xml数据
 * 
 * @author 小贺
 *
 */
public class WriteXML {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建文件对象
		Document doc=new Document();
		//创建元素节点
		Element root=new Element("root");
		Element stu=new Element("student");
		Element name=new Element("name");
		Element sex=new Element("sex");
		Element age=new Element("age");
		//设置元素节点之间的关系
		root.addContent(stu);
		stu.addContent(name);
		stu.addContent(sex);
		stu.addContent(age);
		doc.addContent(root);
		//封装数据
		name.setText("张三");
		sex.setText("女");
		age.setText("18");
		//设置节点属性 以及属性值
		stu.setAttribute("stuno","1");
		//将文档对象写入到xml文件中
		XMLOutputter xo=new XMLOutputter();
		xo.output(doc,new FileOutputStream(new File("D:/web.xml")));
		System.out.println("成功");
	}
}
