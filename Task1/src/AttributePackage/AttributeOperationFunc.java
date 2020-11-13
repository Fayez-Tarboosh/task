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
public class AttributeOperationFunc extends Attribute{
    
    static String FUNC_ATTRIB = "func";
    eOpertionFunc func; 
    
    public AttributeOperationFunc()
    {
        super.name = FUNC_ATTRIB;
    }
    
    public AttributeOperationFunc(String data)
    {
        super.data = data;
        super.name = FUNC_ATTRIB;
        FullEOpertionFunc();
    }
    
    private void FullEOpertionFunc()
    {
        switch (super.data.toLowerCase()) {
            case "average":
                this.func = eOpertionFunc.Average;
            break;
            case "sum":
                this.func = eOpertionFunc.Sum;
            break;
            case "min":
                this.func = eOpertionFunc.Min;
            break;
            case "max":
                this.func = eOpertionFunc.Max;
            break;
        }
    }

    public eOpertionFunc getFunc() {
        return func;
    }

}
