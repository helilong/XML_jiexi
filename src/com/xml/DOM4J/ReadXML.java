package com.xml.DOM4J;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��dom4j��ȡxml�е�����
 * @author С��
 *
 */
public class ReadXML {
public static void main(String[] args) throws DocumentException {
	//��������������
	SAXReader  reader=new SAXReader();
	//�õ��ĵ�����
	Document doc=reader.read(new File("D:/web.xml"));
	//�õ����ڵ����
	Element root=doc.getRootElement();
	//�õ���Ԫ��
	List<Element> list=root.elements();	
	//  ������
	Iterator<Element> it=root.elementIterator();
	while(it.hasNext()){
		Element gi=it.next();
		System.out.println(gi.attributeValue("gid")+"\t"+gi.elementText("name")+"\t"+gi.elementText("price")+"\t"+gi.elementText("number"));
	}
}
}
