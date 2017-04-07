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
    public static final int TESTINT = 5;
    /**
     * Main.
     * @param args parameter
     */
    public static void main(String[] args) {
        Renderer r = new Renderer(new SomeClass(TESTINT));
        r.render();
        
    }
    /**
     * Constructor for a Renderer Object.
     * @param o object to render
     */
    public Renderer(Object o) {
        obj = o;
    }
    /**
     * Returns a string with the presentation of the attributes of the object.
     * @return a string with the presentation of the attributes
     */
    public String render() {
        String fields = renderFields();
        //System.out.println(fields);
        return fields;
    }

    /**
     * Returns a string with the presentation of the attributes of the object.
     * @return a string with the presentation of the attributes
     */
    private String renderFields() {
        String tmp = "";
        try {
            //Class< ? > cut = Class.forName("edu.hm.cs.swa.praktikum1.SomeClass");
            Class < ? > cut = obj.getClass();
            tmp += "Instance of " + cut.getName() + ":\n";
            Field[] fields = cut.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] annos = f.getAnnotations();
                for (Annotation anno : annos) {
                    if (anno instanceof RenderMe) {
                        RenderMe myAnno = (RenderMe) anno;
                        String withParam = myAnno.with();
                        if (!withParam.equals("")) {
                            Class < ? > objClass = Class.forName(withParam);
                            CustomRenderInterface cri = (CustomRenderInterface)objClass.newInstance();
                            tmp += f.getName() + " (Type " + f.getType().getSimpleName() + ") " + cri.render(f.get(obj));
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
