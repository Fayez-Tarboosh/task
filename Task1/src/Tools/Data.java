package Tools;

import AttributePackage.AttributeOperationFilter;
import AttributePackage.AttributeOperationName;
import AttributePackage.eOperationType;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fayez Tarboosh
 */
public class Data {
    private String name ;
    private Map<String,String> populations; 
    private Map<String,List<String>> subs; 
    static String FILE_NAME = "data.xml";
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the populations
     */
    public Map<String,String> getPopulations() {
        return populations;
    }

    /**
     * @param populations the populations to set
     */
    public void setPopulations(Map<String,String> populations) {
        this.populations = populations;
    }

    /**
     * @return the subs
     */
    public Map<String,List<String>> getSubs() {
        return subs;
    }
    
    public Data()
    {
        populations = new HashMap<String,String>();
        subs = new HashMap<String,List<String>>();
        //populations.put("population","601646"); test
    }
    
    public Data( HashMap<String,String> populations, HashMap<String,List<String>> subs)
    {
        this.populations = populations;
        this.subs = subs;
        //populations.put("population","601646"); test
    }
    
    
    public Map<Operation,List<Data>> ReadXMLFile(List<Operation> operations) throws SAXException, IOException, ParserConfigurationException, TransformerException
    {
//        Init Map Of Data
        Map<Operation,List<Data>> data =new HashMap<>();
        for (int z = 0; z < operations.size(); z++) 
        {
            Operation operation =operations.get(z);
            List<Data> list_value = new ArrayList<>();
            try 
            {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(new File(FILE_NAME));
 //            Root
                Element root=doc.getDocumentElement();
//              Data
                NodeList nodes = root.getChildNodes();
//            Foreach
                for (int i = 0; i < nodes.getLength(); i++) 
                {
//              To Save Many Value Nodes     
                    List<String> q =new ArrayList<>();
//              Init Data
                    Data value = new Data();
//                  Loop Node 
                    Node childNode = nodes.item(i);
//                 Check If Element
                    if (childNode.getNodeType() == Node.ELEMENT_NODE) 
                    {
//                      Get Selected Node As Element
                        Element eElement = (Element) childNode;
//                      Filter
                        Pattern p = Pattern.compile(operation.getFilter().getData(),Pattern.CASE_INSENSITIVE);//. represents single character  
                        Matcher m = p.matcher(eElement.getAttribute("name"));  
                        if( m.matches())
                        {
//                          If Operation Type Is Attrib Get The Data from attrib
                            if(operation.getType().getType()==eOperationType.Attrib)
                            {
//                              If There Are Round 
                                String number=eElement.getAttribute(operation.getAttrib().getData());
                                if(operation.getRound()!= null && !operation.getRound().getData().isEmpty())
                                {
                                    int round=Integer.parseInt(operation.getRound().getData());
                                    DecimalFormat df = new DecimalFormat("#."+("#".repeat(round))+"");
                                    df.setRoundingMode(RoundingMode.CEILING);
                                    number=df.format(Double.parseDouble(number));
               
                                }
                                value.populations.put(eElement.getAttribute("name"),number);
                            }
                            else if (operation.getType().getType()==eOperationType.Sub)
                            {
//                              Get Child Node
                                NodeList supNode = childNode.getChildNodes();
//                              Iterator 
                                for (int j = 0; j <supNode.getLength() ; j++) 
                                {
                                    if (supNode.item(j).getNodeType() == Node.ELEMENT_NODE ) 
                                    {
//                                      Set Value In List
                                        if(operation.getAttrib().getData().equals(supNode.item(j).getNodeName()))
                                        {
                                            String number = supNode.item(j).getTextContent();
                                            if(operation.getRound()!= null && !operation.getRound().getData().isEmpty())
                                            {
                                                int round=Integer.parseInt(operation.getRound().getData());
                                                DecimalFormat df = new DecimalFormat("#."+("#".repeat(round))+"");
                                                df.setRoundingMode(RoundingMode.CEILING);
                                                number=df.format(Double.parseDouble(number));
                                            }
                                            q.add(number);
                                            value.subs.put(operation.getAttrib().getData(),q);
                                        }
                                    }
                                }
                            }
                            list_value.add(value);          
                        }
                }
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
            data.put(operation,list_value);
        }
        new Result(data).WriteXmlFile();
        return  data;
    }

}