package edu.hm.cs.swa.praktikum1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * JUnit Test for the render method from the class Renderer.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
@RunWith(Parameterized.class)
public class RendererTest {

    private Renderer renderer;
    public static final int[] TESTINTS = {5, 6, 7}; 
    private Object toTest;
    private String expected;
    
    /**
     * Creates a collection with test objects.
     * @return a collection with test objects
     */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {new SomeClass(TESTINTS[0]), "Instance of edu.hm.cs.swa.praktikum1.SomeClass:\n" + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"}, 
            {new SomeClass(TESTINTS[1]), "Instance of edu.hm.cs.swa.praktikum1.SomeClass:\n" + "foo (Type int): 6\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"},
            {new SomeClass(TESTINTS[2]), "Instance of edu.hm.cs.swa.praktikum1.SomeClass:\n" + "foo (Type int): 7\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"}
           });
    }
    
    /**
     * Constructs a Testobject.
     * @param toTest object for the render method
     * @param expected return string from the render method
     */    
    public RendererTest(Object toTest, String expected) {
        this.toTest = toTest;
        this.expected = expected;
    }
    
    /**
     * Creates a renderer object for the test.
     */ 
    @Before
    public void setUp() {
        renderer = new Renderer(toTest);
    }
    
    /**
     * Tests the renderer object.
     */
    @Test
    public void testRendering() {
        assertEquals(expected, renderer.render());
    }
}
