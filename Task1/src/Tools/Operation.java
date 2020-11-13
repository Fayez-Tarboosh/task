package Tools;



import AttributePackage.AttributeOperationAttrib;
import AttributePackage.AttributeOperationFilter;
import AttributePackage.AttributeOperationFunc;
import AttributePackage.AttributeOperationName;
import AttributePackage.AttributeOperationRound;
import AttributePackage.AttributeOperationType;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fayez Tarboosh
 */
public class Operation {

    /**
     * @return the round
     */
    public AttributeOperationRound getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(AttributeOperationRound round) {
        this.round = round;
    }

    /**
     * @return the name
     */
    public AttributeOperationName getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(AttributeOperationName name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public AttributeOperationType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(AttributeOperationType type) {
        this.type = type;
    }

    /**
     * @return the func
     */
    public AttributeOperationFunc getFunc() {
        return func;
    }

    /**
     * @param func the func to set
     */
    public void setFunc(AttributeOperationFunc func) {
        this.func = func;
    }

    /**
     * @return the attrib
     */
    public AttributeOperationAttrib getAttrib() {
        return attrib;
    }

    /**
     * @param attrib the attrib to set
     */
    public void setAttrib(AttributeOperationAttrib attrib) {
        this.attrib = attrib;
    }

    /**
     * @return the filter
     */
    public AttributeOperationFilter getFilter() {
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(AttributeOperationFilter filter) {
        this.filter = filter;
    }
    static String FILE_NAME = "operations.xml";
    
    private AttributeOperationName name ;
    private AttributeOperationType type;
    private AttributeOperationFunc func;
    private AttributeOperationAttrib attrib; 
    private AttributeOperationFilter filter ; 
    private AttributeOperationRound round ; 

    


    public Operation ()
    {
        this.name = new AttributeOperationName();
        this.type = new AttributeOperationType();
        this.func = new AttributeOperationFunc();
        this.attrib = new AttributeOperationAttrib();
        this.filter = new AttributeOperationFilter();
    }
    public Operation (String name,String type,String func,String attrib,String filter)
    {
        this.name = new AttributeOperationName(name);
        this.type = new AttributeOperationType(type);
        this.func = new AttributeOperationFunc(func);
        this.attrib = new AttributeOperationAttrib(attrib);
        this.filter = new AttributeOperationFilter(filter);
    }
    
    
    public List<Operation> ReadXMLFile()
    {
        List<Operation> operations=new ArrayList<>();
        try 
        {
//       Init Document Xml
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(FILE_NAME));
//            Root Element Node
            Element root=doc.getDocumentElement();
//            Child Nodes
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) 
            {
                Node childNode = nodes.item(i);
//                 Get Attributes
                NamedNodeMap attributes = childNode.getAttributes();
//                 If Element (Not Space)
                if (childNode.getNodeType() == Node.ELEMENT_NODE) 
                {
//                  Convert Node To Element
                    //Element eElement = (Element) childNode;
//                  Get Attributes Of Elements
                    for (int j = 0; j < attributes.getLength(); j++) 
                    {
//                      Node Name
                        String nName=attributes.item(j).getNodeName();
//                      Node Value
                        String nValue=attributes.item(j).getNodeValue();
//                      Attrubute Name
                        if(nName==getName().getName())
                             getName().setData(nValue);
                        else if(nName==getType().getName())
                             getType().setData(nValue);
                        else if(nName==getFunc().getName())
                             getFunc().setData(nValue);
                        else if(nName==getAttrib().getName())
                             getAttrib().setData(nValue);
                        else if(nName==getFilter().getName())
                             getFilter().setData(nValue);
                        else if (getRound()!=null && nName==getRound().getName())
                                 getRound().setData(nValue);
                    }
//                    Init Operation
                    Operation operation=new Operation(getName().getData(), getType().getData(), getFunc().getData(), getAttrib().getData(), getFilter().getData());
                    operations.add(operation);
                }
            }
//          Final Send Operations To Data
            new Data().ReadXMLFile(operations);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return  operations;
    }
}
