package edu.hm.cs.swa.praktikum1;

/**
 * Beispiel
 *
 */
import java.io.*;
import java.util.*;
import edu.hm.cs.swa.praktikum1.Renderer;
public class SomeClass {
	@RenderMe public int foo;
	@RenderMe(with="edu.hm.renderer.ArrayRenderer") int[] array = {1, 2, 3, };
	@RenderMe public Date date = new Date(123456789);
	public SomeClass(int foo) {
		this.foo = foo;
	}
}