/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import AttributePackage.AttributeOperationFunc;
import AttributePackage.eOpertionFunc;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import AttributePackage.eOpertionFunc;

/**
 *
 * @author Fayez Tarboosh
 */
public class Funcations {
    
    public static float CalculateFuncation(AttributeOperationFunc funcation,List<Data> data){
        float result=0.0f;
        switch (funcation.getFunc()){
            case Min : 
                result=min(data);
                break;
            case Max : 
                result=max(data);
                break;
            case Average: 
                result=average(data);
                break;
            case Sum : 
                result=sum(data);
                break;
        }
        return result;
    }
    
    
    private static float average(List<Data> list_data){
        float average=0.0f;
        for (int i = 0; i < list_data.size(); i++)
        {
            Data data=list_data.get(i);
            if(!data.getPopulations().isEmpty()){
                for (Map.Entry<String,String> entry : data.getPopulations().entrySet()){  
                    average+=Float.parseFloat(entry.getValue());
                }
            }else{
                for (Map.Entry<String,List<String>> entry : data.getSubs().entrySet())  {
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        average+=Float.parseFloat(entry.getValue().get(j));
                    }
                }
            }
        }
        average/=list_data.size();
        return average;
    }
    private static float sum(List<Data> list_data){
        float sum=0.0f;
        for (int i = 0; i < list_data.size(); i++) 
        {
            Data data=list_data.get(i);
            if(!data.getPopulations().isEmpty()){
                 for (Map.Entry<String,String> entry : data.getPopulations().entrySet())  
                    sum+=Float.parseFloat(entry.getValue());
            }else{
                for (Map.Entry<String,List<String>> entry : data.getSubs().entrySet())  
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        sum+=Float.parseFloat(entry.getValue().get(j));
                    }
            }
        }
        return sum;
    }
    
    private static float min(List<Data> list_data)
    {
        float min = 0.0f;
        if(!list_data.isEmpty() && !list_data.get(0).getPopulations().isEmpty())
            min = Float.parseFloat(list_data.get(0).getPopulations().get(list_data.get(0).getPopulations().keySet().toArray()[0]));
        else if(!list_data.isEmpty()&& !list_data.get(0).getSubs().isEmpty())
            min = Float.parseFloat(list_data.get(0).getSubs().get(list_data.get(0).getSubs().keySet().toArray()[0]).get(0));
        for (int i = 0; i < list_data.size(); i++) 
        {
            Data data=list_data.get(i);
            if(!data.getPopulations().isEmpty())
            {
                for (Map.Entry<String,String> entry : data.getPopulations().entrySet()){  
                    float value=Float.parseFloat(entry.getValue());
                    if(min > value)
                        min = value;
                }
            }else
            {
                for (Map.Entry<String,List<String>> entry : data.getSubs().entrySet()) 
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        float value=Float.parseFloat(entry.getValue().get(j));
                        if(min > value)
                            min = value;
                    }
            }
        }
        return min;
    }
    
    
    private static float max(List<Data> list_data)
    {
        float max=0.0f;
        if(!list_data.isEmpty() && !list_data.get(0).getPopulations().isEmpty())
        {
            max=Float.parseFloat(list_data.get(0).getPopulations().get(list_data.get(0).getPopulations().keySet().toArray()[0]));
        }
        else if(!list_data.isEmpty()&& !list_data.get(0).getSubs().isEmpty())
        {
            max=Float.parseFloat(list_data.get(0).getSubs().get(list_data.get(0).getSubs().keySet().toArray()[0]).get(0));
        }
        for (int i = 0; i < list_data.size(); i++) {
            Data data=list_data.get(i);
            if(!data.getPopulations().isEmpty()){

                 for (Map.Entry<String,String> entry : data.getPopulations().entrySet()){  
                     float value=Float.parseFloat(entry.getValue());
                     if(max < value)
                        max = value;
                 }
            }else{

                for (Map.Entry<String,List<String>> entry : data.getSubs().entrySet())  
                    for (int j = 0; j < entry.getValue().size(); j++) {
                        float value=Float.parseFloat(entry.getValue().get(j));
                        if(max < value)
                         max = value;
                    }
            }
        }
        return max;
    }
}
