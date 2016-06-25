package tools;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


public class ParseXMLFile{
	/*
	 * 将xml解析为host中的所需数据
	 * 虽然每次获取到的结果不一样，但是只需要解析出有用的关键字就可以
	 * */
	public Map xml2Host(String url) throws DocumentException{
		SAXReader reader = new SAXReader();
		//路径可以更改
		Document document = reader.read(new File("F:\\书籍\\工程实践\\zoomeye\\zoomeye\\WebContent\\result\\result.xml"));
		Element root = document.getRootElement();
		org.dom4j.Attribute scanner =   root.attribute("scanner");
		HashMap map = new HashMap();
		map.put("scanner", scanner.getText());
		Element host = root.element("host");
		Element address = host.element("address");
		System.out.println("address.attr = "+address.attribute("addr").getText());
		map.put("address",address.attribute("addr").getText());
		Element ports = host.element("ports");
		Element port = ports.element("port");
		System.out.println("address.attr = "+port.attribute("portid").getText());
		map.put("port",port.attribute("portid").getText());
		Element service = port.element("service");
		System.out.println("address.attr = "+service.attribute("name").getText());
		map.put("service",service.attribute("name").getText());
		map.put("os","windows");
		map.put("city","suzhou");
		return map;
	}
}