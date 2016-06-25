package tools;

import java.io.File;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import org.dom4j.Document;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.HTMLWriter;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;

/**
 * 借助XSL渲染模板，将XML文件生成为 HTML 格式的字符串
 */
public class Xml2HtmlTransformer
{
    /**
     * 获取html字符串，通过servlet打印
     * @param xmlPath xml路径
     * @param xslPath 扩展样式表文件路径
     * @return
     */
    public static String getHtmlString(String xmlPath,String xslPath){
        String htmlStr = null;
        try {
        	Document doc = new SAXReader().read(new File(xmlPath));
            Document transformDoc = transformXml2Document(doc,xslPath);
            htmlStr = returnHtmlString(transformDoc);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return htmlStr;
    }
    
    /**
     * 
     * @param doc
     * @param xslPath xsl路径
     * @return
     */
    private static Document transformXml2Document(Document doc,String xslPath){
        TransformerFactory factory = TransformerFactory.newInstance();
        Document transformerDoc = null;
        try {
        	//利用XSLT文档对象创建转换器
            Transformer transformer = factory.newTransformer(new StreamSource(xslPath));
            DocumentSource docSource = new DocumentSource(doc);
            DocumentResult docResult = new DocumentResult();
            transformer.transform(docSource, docResult);
            transformerDoc = docResult.getDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transformerDoc;
    }
    
    /**
     * 将文档对象写入字符输出流
     * @param transformDoc xml生成的文档对象
     * @return
     */
    private static String returnHtmlString(Document transformDoc){
        StringWriter strWriter = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();
        //设置编码格式
        format.setEncoding("UTF-8");
        format.setXHTML(true);
        HTMLWriter htmlWriter = new HTMLWriter(strWriter,format);
        format.setExpandEmptyElements(false);
        try {
        	//将文档对象写入字符输出流
            htmlWriter.write(transformDoc);
            //关闭字符输出流
            strWriter.close();
            htmlWriter.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println(strWriter.toString());
        return strWriter.toString();
    }
    
}
