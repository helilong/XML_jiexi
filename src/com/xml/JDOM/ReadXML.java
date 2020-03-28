package com.xml.JDOM;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.*;
import org.jdom.input.SAXBuilder;

/**
 * ʹ��jdom�������� ��ȡxml����
 * @author С��
 *
 */
public class ReadXML {
	public static void main(String[] args) throws JDOMException, IOException {	
		//����������
		SAXBuilder sb=new SAXBuilder();
		//����build��������xml�ļ����õ��ĵ�����
		 Document doc= sb.build(new File("D:/web.xml"));
		//�����ĵ������õ����ڵ�
		Element root = doc.getRootElement();
		//���ݸ��ڵ�õ�������ӽڵ�
		List<Element> list = root.getChildren();
		//����
		for (Element element : list) {
			System.out.println(element.getAttributeValue("stuno")+"\t"+element.getChildText("name")+"\t"+element.getChildText("sex")+"\t"+element.getChildText("age"));
		}
	}
}
