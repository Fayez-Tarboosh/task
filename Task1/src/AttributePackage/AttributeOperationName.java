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
public class AttributeOperationName extends  Attribute {
    static String NAME_ATTRIB = "name";
    
    public AttributeOperationName()
    {
         super.name = NAME_ATTRIB;
    }

    public AttributeOperationName(String data ) 
    {
        super.name = NAME_ATTRIB;
        super.data = data;
    }
}
