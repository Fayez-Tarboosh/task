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
public class AttributeOperationRound  extends Attribute{
    
    static String ATTRIB_Round = "round";
    
    public AttributeOperationRound ()
    {
        super.name = ATTRIB_Round;
    }
    
    public AttributeOperationRound (String data)
    {
        super.data = data;
        super.name = ATTRIB_Round;
    }
}
