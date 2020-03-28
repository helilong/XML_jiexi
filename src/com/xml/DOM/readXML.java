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
		//1.����DocumentBuilderFactory����
		DocumentBuilderFactory docBF=DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docbu=docBF.newDocumentBuilder();
			
			try {
				//ͨ���ļ���ȡ�ĵ�
				Document doc=docbu.parse(new File("Student.xml"));
				//ͨ���ĵ���ȡ�ڵ㼯��
				NodeList node_arr=doc.getChildNodes();
				//ѭ�������ڵ㼯��
				for(int i=0;i<node_arr.getLength();i++){
					//ͨ���±��õ�������Ľڵ�
					Node nod=node_arr.item(i);
					//�ж��Ƿ����ӽڵ㣬�����жϵ�һ���ڵ��Ƿ�Ϊ�ı��ڵ�
					if(nod.hasChildNodes()&&nod.getFirstChild().getNodeType()!=Node.TEXT_NODE){
					}
					//�õ��������ӽڵ���������еĽڵ㼯��
					NodeList node_arr_child=nod.getChildNodes();
					//ѭ�������õ��ļ���
					for(int j=0;j<node_arr_child.getLength();j++){
						//�õ��ڵ�
						Node node_child=node_arr_child.item(j);
						
						//ͨ���ڵ��õ��ӽڵ�ļ���
						NodeList node_c_c=node_child.getChildNodes();
						//��������
						for(int k=0;k<node_c_c.getLength();k++){
							//��ȡ�ӽڵ�
							Node node_cc=node_c_c.item(k);
							//�жϽڵ��Ƿ�ΪԪ�ؽڵ㣬���ΪԪ�ؽڵ� ����ڵ�����
							if(node_cc.getNodeType()==Node.ELEMENT_NODE){
								
								System.out.println(node_cc.getNodeName());
								System.out.println(node_cc.getFirstChild().getNodeValue());
								
							}else {
								//�����Ϊ�ڵ��������
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
