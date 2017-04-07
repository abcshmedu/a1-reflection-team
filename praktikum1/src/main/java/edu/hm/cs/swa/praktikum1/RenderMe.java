package edu.hm.cs.swa.praktikum1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to create a presentation of the attributes.
 * 
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {
    
    /**
     * Annoation parameter.
     * @return a string with the presentation of the attributes of the render class
     */
    String with() default "";
}
