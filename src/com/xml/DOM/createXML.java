package com.xml.DOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class createXML {
	/**
	 * 创建xml的方法
	 * 
	 */
	public static void create(){
		//1.创建DocumentBuilderFactory对象
		DocumentBuilderFactory docBF=DocumentBuilderFactory.newInstance();
		//2.通过DocumentBuilderFactory来获取一个DocumentBuilder的对象
		try {
			DocumentBuilder docbu=docBF.newDocumentBuilder();
			//3.创建一个文件对象
			Document doc=docbu.newDocument();
			//Element表示一个元素  创建一个根节点
			Element emt=doc.createElement("StuList");
			doc.appendChild(emt);
			//创建子节点》 学生节点
			Element emt_stu=doc.createElement("StuInfo");
			//把学生节点添加到根节点中
			emt.appendChild(emt_stu);
			//创建学生姓名节点
			Element emt_stuName=doc.createElement("stuName");
			//创建文本节点
			Text emt_stuNameval=doc.createTextNode("张三");
			//把文本节点添加到学生姓名节点
			emt_stuName.appendChild(emt_stuNameval);
			//把学生姓名节点再添加到学生节点
			emt_stu.appendChild(emt_stuName);
			
			
			Element emt_sex=doc.createElement("stuSex");
			Text emt_sexval=doc.createTextNode("男");
			emt_sex.appendChild(emt_sexval);
			emt_stu.appendChild(emt_sex);
			
			//把文档对象转换为源
			DOMSource dom=new DOMSource(doc);
			File f= new File("Student.xml");
			PrintWriter pw=null;
			try {
				pw=new PrintWriter(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//获取一个result对象
			StreamResult sr=new StreamResult(pw);
			
			
			TransformerFactory tfmf=TransformerFactory.newInstance();
			try {
				Transformer tf=tfmf.newTransformer();
				//设置属性
				tf.setOutputProperty(OutputKeys.ENCODING,"GB2312");
				tf.setOutputProperty(OutputKeys.INDENT,"yes");
				
				try {
					//写入文件
					tf.transform(dom,sr);
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	public static void main(String[] args) {
		create();
	}

}
