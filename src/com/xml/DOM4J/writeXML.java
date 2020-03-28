package com.xml.DOM4J;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

/**
 * ʹ��DOM4J  ������д�뵽ָ����xml
 * @author С��
 *
 */
public class writeXML {
public static void main(String[] args) throws IOException {
	//�����ĵ�����
	Document doc=DocumentHelper.createDocument();
	//ʹ���ĵ����󴴽����ڵ�
	Element root=doc.addElement("root");
	//ʹ�ø��ڵ㴴���ӽڵ�
	Element goodsInfo=root.addElement("goodsInfo");
	Element name=root.addElement("name");
	Element price=root.addElement("price");
	Element number=root.addElement("number");
	//��װ����
	goodsInfo.addAttribute("gid","1");
	name.addText("С��");
	price.addText("20");
	number.addText("100");
	//д��
	XMLWriter xw=new XMLWriter(new FileOutputStream(new File("D:/web.xml")));
	xw.write(doc);
	xw.close();
	System.out.println("�ɹ�");
}
}
