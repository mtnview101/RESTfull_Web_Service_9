package core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML_builder {

       public static void main(String argv[]) throws ParserConfigurationException, TransformerException {

              DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
              DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

              // root elements
              Document doc = docBuilder.newDocument();
              Element rootElement = doc.createElement("calc");
              rootElement.setAttribute("conversion", "kg to lb");
              doc.appendChild(rootElement);

              // id element
              Element a = doc.createElement("kg");
              a.appendChild(doc.createTextNode("100.00"));
              // a.setAttribute("attr", "value");
              rootElement.appendChild(a);

              // name element
              Element b = doc.createElement("lb");
              b.appendChild(doc.createTextNode("220.46"));
              rootElement.appendChild(b);
              
              // write the content into xml file
              TransformerFactory transformerFactory = TransformerFactory.newInstance();
              Transformer transformer = transformerFactory.newTransformer();
              DOMSource source = new DOMSource(doc);
              StreamResult result = new StreamResult(new File("hw_9_xml.xml"));
              // StreamResult result = new StreamResult(System.out);
              
              System.out.println("Done");

              transformer.transform(source, result);
       }
}
