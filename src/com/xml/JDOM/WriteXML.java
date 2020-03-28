package com.xml.JDOM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * ʹ��JDOM��ʽ����  д��xml����
 * 
 * @author С��
 *
 */
public class WriteXML {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//�����ļ�����
		Document doc=new Document();
		//����Ԫ�ؽڵ�
		Element root=new Element("root");
		Element stu=new Element("student");
		Element name=new Element("name");
		Element sex=new Element("sex");
		Element age=new Element("age");
		//����Ԫ�ؽڵ�֮��Ĺ�ϵ
		root.addContent(stu);
		stu.addContent(name);
		stu.addContent(sex);
		stu.addContent(age);
		doc.addContent(root);
		//��װ����
		name.setText("����");
		sex.setText("Ů");
		age.setText("18");
		//���ýڵ����� �Լ�����ֵ
		stu.setAttribute("stuno","1");
		//���ĵ�����д�뵽xml�ļ���
		XMLOutputter xo=new XMLOutputter();
		xo.output(doc,new FileOutputStream(new File("D:/web.xml")));
		System.out.println("�ɹ�");
	}
}
