package edu.hm.cs.swa.praktikum1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RenderMe {
    String with() default "";
}
