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
 * 利用jdom删除xml
 * 
 * @author 小贺
 *
 */
public class RemoveXML {
	public static void main(String[] args) throws JDOMException, IOException {
		//创建解析器
		SAXBuilder builder=new SAXBuilder();
		//调用build方法解析xml文件 ，得到文档对象
		Document doc=builder.build(new File("D:/web.xml"));
		//根据文档对象 拿到根节点
		Element root=doc.getRootElement();
		//根据根节点得到下面的子节点
		List<Element> list=root.getChildren();
		for (Element stu : list) {
			//当stuno为1时，干掉web.xml里面的内容
			if("1".equals(stu.getAttributeValue("stuno"))){
				root.removeContent(stu);
				break;
			}	
		}
		//将文档对象写入到xml文件中
		XMLOutputter xo=new XMLOutputter();
		xo.output(doc,new FileOutputStream(new File("D:/web.xml")));
	}
}
