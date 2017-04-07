package edu.hm.cs.swa.praktikum1;


/**
 * Renderer for arrays.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class ArrayRenderer {
    /**
     * DefaultConstructor.
     */
    ArrayRenderer() { }
   
    /**
     * Returns a string with the presentation of the attributes of the object.
     * @param array to render.
     * @return a string with the presentation of the attributes
     */
    public String render(int[] array) {
        String ret = "[";
        for (int elem:array) {
            ret += elem + ", ";
        }
        ret += "]\n";
        return ret;     
    }

}

