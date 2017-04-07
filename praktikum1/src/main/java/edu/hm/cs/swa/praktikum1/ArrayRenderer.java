package edu.hm.cs.swa.praktikum1;

import java.lang.reflect.Array;

/**
 * Renderer for arrays.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class ArrayRenderer implements CustomRenderInterface {
    /**
     * DefaultConstructor.
     */
    ArrayRenderer() { }
   
    /**
     * Returns a string with the presentation of the attributes of the object.
     * @param o object to render.
     * @return a string with the presentation of the attributes
     */
    public String render(Object o) {
        int length = Array.getLength(o);
        String ret = "";
        if (length != 0) {
            ret += "[";
        }
        for (int i = 0; i < length; i++) {
            ret += Array.get(o, i) + ", ";
        }
        return ret + "]\n";
    }

}

