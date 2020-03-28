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
 * ����jdom�޸�webxml���������
 * 
 * @author С��
 *
 */
public class UpdataXML {
public static void main(String[] args) throws FileNotFoundException, IOException, JDOMException {
	//����������
	SAXBuilder builder=new SAXBuilder();
	//����build��������xml�ļ� ���õ��ĵ�����
	Document doc=builder.build(new File("D:/web.xml"));
	//�����ĵ����� �õ����ڵ�
	Element root=doc.getRootElement();
	//���ݸ��ڵ�õ�������ӽڵ�
	List<Element> list=root.getChildren();
	for (Element stu : list) {
		if("1".equals(stu.getAttributeValue("stuno"))){
			stu.getChild("name").setText("С��");
			stu.getChild("sex").setText("��");
			stu.getChild("age").setText("20");
			}
		}
	//���ĵ�����д�뵽xml�ļ���
	XMLOutputter xo=new XMLOutputter();
	xo.output(doc,new FileOutputStream(new File("E:/stu.xml")));
	}
}
