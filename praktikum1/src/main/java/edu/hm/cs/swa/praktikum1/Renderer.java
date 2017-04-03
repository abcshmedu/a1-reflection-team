package edu.hm.cs.swa.praktikum1;
import java.lang.reflect.*;
/**
 *  .
 * 
 *
 */
public class Renderer {
    /**
	 * 
	 * @param args .
	 * @throws Exception .
	 */
	public static void main(String[] args) throws Exception {
		//Class<?> cut = Class.forName(args[0]);
		Class< ? > cut = Class.forName("edu.hm.cs.swa.praktikum1.SomeClass");
		Field[] fields = cut.getDeclaredFields();
		String tmp = "";
		for (Field f : fields) {
			if (f.getAnnotation(edu.hm.cs.swa.praktikum1.RenderMe.class) != null) {
				tmp = "";
				tmp += f.getName() + " " + f.getType() + " " + f.get(new SomeClass(5)) + "\n"; 
			}
			System.out.println(tmp);
		}
	}
	/**
	 * .
	 * @param o .
	 */
	public Renderer(Object o) {
		
	}
	/**
	 * .
	 * @return .
	 */
	public String renderer() {
		return "";
	}
}
