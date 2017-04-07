package edu.hm.cs.swa.praktikum1;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class SomeClass {
    public static final long DATEPARA = 123456789;
    public static final int ARRAYPARA = 3;
    
    //Variables must be public
    @RenderMe public int foo;
    @RenderMe(with = "edu.hm.cs.swa.praktikum1.ArrayRenderer") int[] array = {1, 2, ARRAYPARA, };
    @RenderMe public Date date = new Date(DATEPARA);
    
    /**
     * Constructs a SomeClass Object.
     * @param foo integer for the annotation
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }
}