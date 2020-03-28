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
	 * ����xml�ķ���
	 * 
	 */
	public static void create(){
		//1.����DocumentBuilderFactory����
		DocumentBuilderFactory docBF=DocumentBuilderFactory.newInstance();
		//2.ͨ��DocumentBuilderFactory����ȡһ��DocumentBuilder�Ķ���
		try {
			DocumentBuilder docbu=docBF.newDocumentBuilder();
			//3.����һ���ļ�����
			Document doc=docbu.newDocument();
			//Element��ʾһ��Ԫ��  ����һ�����ڵ�
			Element emt=doc.createElement("StuList");
			doc.appendChild(emt);
			//�����ӽڵ㡷 ѧ���ڵ�
			Element emt_stu=doc.createElement("StuInfo");
			//��ѧ���ڵ���ӵ����ڵ���
			emt.appendChild(emt_stu);
			//����ѧ�������ڵ�
			Element emt_stuName=doc.createElement("stuName");
			//�����ı��ڵ�
			Text emt_stuNameval=doc.createTextNode("����");
			//���ı��ڵ���ӵ�ѧ�������ڵ�
			emt_stuName.appendChild(emt_stuNameval);
			//��ѧ�������ڵ�����ӵ�ѧ���ڵ�
			emt_stu.appendChild(emt_stuName);
			
			
			Element emt_sex=doc.createElement("stuSex");
			Text emt_sexval=doc.createTextNode("��");
			emt_sex.appendChild(emt_sexval);
			emt_stu.appendChild(emt_sex);
			
			//���ĵ�����ת��ΪԴ
			DOMSource dom=new DOMSource(doc);
			File f= new File("Student.xml");
			PrintWriter pw=null;
			try {
				pw=new PrintWriter(f);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//��ȡһ��result����
			StreamResult sr=new StreamResult(pw);
			
			
			TransformerFactory tfmf=TransformerFactory.newInstance();
			try {
				Transformer tf=tfmf.newTransformer();
				//��������
				tf.setOutputProperty(OutputKeys.ENCODING,"GB2312");
				tf.setOutputProperty(OutputKeys.INDENT,"yes");
				
				try {
					//д���ļ�
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
