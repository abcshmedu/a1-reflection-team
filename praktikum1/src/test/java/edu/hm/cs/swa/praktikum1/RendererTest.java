package edu.hm.cs.swa.praktikum1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * JUnit Test for the render method from the class Renderer.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
@RunWith(Parameterized.class)
public class RendererTest {

    //private SomeClass toRender;
    private Renderer renderer;
    public static final int TESTINT = 5; 
    
    /**
     * Creates a collection with test objects.
     * @return a collection with test objects
     */
    @Parameters
    public static Collection<Object[]> test() {
        return Arrays.asList(new Object[][] {
            {new SomeClass(TESTINT), "foo (Type int): 5\narray (Type int[]): [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"},
            {},
           });
    }
    
    @Parameter
    private Object toTest;
    
    @Parameter(1)
    private String expected;
    
    /**
     * Creates a renderer object for the test.
     */
    @Before
    public void setUp() {
        //toRender = new SomeClass(5);
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
