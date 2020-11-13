/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import AttributePackage.AttributeOperationFilter;
import AttributePackage.AttributeOperationFunc;
import AttributePackage.AttributeOperationAttrib;
import AttributePackage.AttributeOperationType;
import AttributePackage.AttributeOperationName;
import AttributePackage.AttributeOperationRound;
import Tools.Data;
import Tools.Operation;
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fayez Tarboosh
 */
public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.print("Start App ");
       Operation op = new Operation();  
       op.ReadXMLFile();
       System.out.print("output file generated !");
    }
}
