package AttributePackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fayez Tarboosh
 */
public class Attribute {

    String name;
    String data;
    
    public Attribute() {
        this.name = "";
        this.data = "";
    }
    
    public Attribute(String name )
    {
       this.name=name;
    }

    public Attribute(String name , String data)
    {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
