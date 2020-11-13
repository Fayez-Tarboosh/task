/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AttributePackage;

/**
 *
 * @author Fayez Tarboosh
 */
public class AttributeOperationAttrib  extends Attribute{
    
    static String ATTRIB_ATTRIB = "attrib";
    
    public AttributeOperationAttrib ()
    {
        super.name = ATTRIB_ATTRIB;
    }
    
    public AttributeOperationAttrib (String data)
    {
        super.data = data;
        super.name = ATTRIB_ATTRIB;
    }
}
