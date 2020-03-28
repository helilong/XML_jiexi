package com.xml.JDOM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * ����jdomɾ��xml
 * 
 * @author С��
 *
 */
public class RemoveXML {
	public static void main(String[] args) throws JDOMException, IOException {
		//����������
		SAXBuilder builder=new SAXBuilder();
		//����build��������xml�ļ� ���õ��ĵ�����
		Document doc=builder.build(new File("D:/web.xml"));
		//�����ĵ����� �õ����ڵ�
		Element root=doc.getRootElement();
		//���ݸ��ڵ�õ�������ӽڵ�
		List<Element> list=root.getChildren();
		for (Element stu : list) {
			//��stunoΪ1ʱ���ɵ�web.xml���������
			if("1".equals(stu.getAttributeValue("stuno"))){
				root.removeContent(stu);
				break;
			}	
		}
		//���ĵ�����д�뵽xml�ļ���
		XMLOutputter xo=new XMLOutputter();
		xo.output(doc,new FileOutputStream(new File("D:/web.xml")));
	}
}
