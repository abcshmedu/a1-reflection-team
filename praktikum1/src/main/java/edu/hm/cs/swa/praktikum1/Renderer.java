package edu.hm.cs.swa.praktikum1;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * 
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class Renderer {
    private final Object obj;

    /**
     * Constructor for a Renderer Object.
     * @param obj object to render
     */
    public Renderer(Object obj) {
        this.obj = obj;
    }
    /**
     * Returns a string with the presentation of the attributes of the object.
     * @return a string with the presentation of the attributes
     */
    public String render() {
        String fields = renderFields();
        //System.out.println(fields);
        System.out.println(renderMethods());
        return fields;
    }
    /**
     * Creates a String representation of the Methods.
     * @return String representation of Methods
     */
    private String renderMethods() {
        String tmp = "";
        try {
            Class < ? > cut = obj.getClass();
            Method[] methods = cut.getDeclaredMethods();
            for (Method m: methods) {
                Annotation[] annos = m.getAnnotations();
                for (Annotation anno:annos) {
                    if (anno instanceof RenderMe) {
                        RenderMe myAnno = (RenderMe) anno;
                        String withParam = myAnno.with();
                        if (!withParam.equals("")) {
                            Class < ? > objClass = Class.forName(withParam);
                            Method renderMethod = objClass.getMethod("render", m.getReturnType());                      
                            tmp += renderMethod.invoke(objClass.newInstance(), m.invoke(obj));
                        } else {
                            Parameter[] array = m.getParameters();
                            String helper = "";
                            for (Parameter p: array) {
                                helper += p.getType().getSimpleName() + ", ";
                            }
                            helper = helper.substring(0, helper.length() - 2);
                            tmp += m.getReturnType().getSimpleName() + " " + m.getName() + "(" + helper + ")\n"; 
                        }
                    }
                }
            }
            return tmp;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            return tmp;
        }
    }

    /**
     * Returns a string with the presentation of the attributes of the object.
     * @return a string with the presentation of the attributes
     */
    private String renderFields() {
        String tmp = "";
        try {
            Class < ? > cut = obj.getClass();
            tmp += "Instance of " + cut.getName() + ":\n";
            Field[] fields = cut.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] annos = f.getAnnotations();
                for (Annotation anno : annos) {
                    if (anno instanceof RenderMe) {
                        f.setAccessible(true);
                        RenderMe myAnno = (RenderMe) anno;
                        String withParam = myAnno.with();
                        if (!withParam.equals("")) {
                            Class < ? > objClass = Class.forName(withParam);
                            Method m = objClass.getMethod("render", f.getType());                           
                            tmp += f.getName() + " (Type " + f.getType().getSimpleName() + ") " +  m.invoke(objClass.newInstance(), f.get(obj));
                        } else {
                            tmp += f.getName() + " (Type " + f.getType().getName() + "): " + f.get(obj) + "\n"; 
                        }
                    }
                }
            }
            return tmp;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            return tmp;
        }
    }
}
