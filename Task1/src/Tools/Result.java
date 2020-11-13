/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import static Tools.Data.FILE_NAME;
import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Fayez Tarboosh
 */

public class Result {
    static String FILE_NAME = "output.xml";
    Map<Operation,List<Data>> map;    
    
    public Result(Map<Operation,List<Data>> map){
      this.map=map;
    }
    public void WriteXmlFile() throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        // root element
        Element root = document.createElement("results");
        document.appendChild(root);
        for (Map.Entry<Operation,List<Data>> entry : map.entrySet())
        {  
            Operation operation=entry.getKey();
            List<Data> data=entry.getValue();      
            Element result = document.createElement("result");
            root.appendChild(result);
            Attr attr = document.createAttribute("name");
            attr.setValue(operation.getName().getData());
            result.setAttributeNode(attr);
            result.setTextContent(Funcations.CalculateFuncation(operation.getFunc(), data)+"");
            root.insertBefore(document.createTextNode("\n"),result);
        }
        root.appendChild(document.createTextNode("\n"));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File(FILE_NAME));
        transformer.transform(domSource, streamResult);          
    }                  
}
        

  

