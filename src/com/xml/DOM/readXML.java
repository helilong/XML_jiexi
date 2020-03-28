package com.xml.DOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class readXML {
	public static void read(){
		//1.创建DocumentBuilderFactory对象
		DocumentBuilderFactory docBF=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docbu=docBF.newDocumentBuilder();
			
			try {
				//通过文件获取文档
				Document doc=docbu.parse(new File("Student.xml"));
				//通过文档获取节点集合
				NodeList node_arr=doc.getChildNodes();
				//循环遍历节点集合
				for(int i=0;i<node_arr.getLength();i++){
					//通过下标拿到遍历后的节点
					Node nod=node_arr.item(i);
					//判断是否有子节点，并且判断第一个节点是否为文本节点
					if(nod.hasChildNodes()&&nod.getFirstChild().getNodeType()!=Node.TEXT_NODE){
					}
					//拿到遍历后子节点的下面所有的节点集合
					NodeList node_arr_child=nod.getChildNodes();
					//循环遍历得到的集合
					for(int j=0;j<node_arr_child.getLength();j++){
						//拿到节点
						Node node_child=node_arr_child.item(j);
						
						//通过节点拿到子节点的集合
						NodeList node_c_c=node_child.getChildNodes();
						//遍历集合
						for(int k=0;k<node_c_c.getLength();k++){
							//获取子节点
							Node node_cc=node_c_c.item(k);
							//判断节点是否为元素节点，如果为元素节点 输出节点名字
							if(node_cc.getNodeType()==Node.ELEMENT_NODE){
								
								System.out.println(node_cc.getNodeName());
								System.out.println(node_cc.getFirstChild().getNodeValue());
								
							}else {
								//如果不为节点输出内容
								System.out.println(node_cc.getNodeValue());
							}
							
							
						}
						
					}
					
					
				}
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		read();
	}

}
