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
public class AttributeOperationType extends  Attribute{
    
    static String TYPE_ATTRIB = "type";
    
    eOperationType type;
    
    public AttributeOperationType()
    {
        super.name = TYPE_ATTRIB;
    }

    public AttributeOperationType (String data)
    {
        super.data = data;
        super.name = TYPE_ATTRIB;
        FullEOperatioType();
    }
    
    public void FullEOperatioType()
    {
        switch (this.data.toLowerCase()) {
            case "sub":
                this.type = eOperationType.Sub;
                break;
            case "attrib":
                this.type = eOperationType.Attrib;
                break;
        }
    }

    public eOperationType getType() {
        return type;
    }

    public void setType(eOperationType type) {
        this.type = type;
    }
}
