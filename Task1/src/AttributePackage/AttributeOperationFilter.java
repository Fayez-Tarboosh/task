/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttributePackage;

import java.util.regex.*;  

/**
 *
 * @author Fayez Tarboosh
 */
public class AttributeOperationFilter extends Attribute{
    
    static String FILTER_ATTRIB = "filter";
    
    public AttributeOperationFilter()
    {
        super.name = FILTER_ATTRIB;
    }
    
    public AttributeOperationFilter (String data)
    {
        super.data = data;
        super.name = FILTER_ATTRIB;
    }
    
    public boolean Check (String str)
    {
        Pattern p = Pattern.compile(data);//. represents single character  
        Matcher m = p.matcher(str);  
        return m.matches();  
    }
    
}
