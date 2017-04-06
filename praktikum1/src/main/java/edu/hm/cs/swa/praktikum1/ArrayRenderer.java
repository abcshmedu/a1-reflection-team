package edu.hm.cs.swa.praktikum1;

import java.lang.reflect.Array;

public class ArrayRenderer implements CustomRenderInterface {
    ArrayRenderer(){}
    
    public String render(Object o){
        int length = Array.getLength(o);
        String ret ="";
        if(length!=0)
            ret += "[";
        for(int i =0; i<length;i++)
            ret+= Array.get(o, i) + ", ";
        return ret+"]\n";
    }

}

