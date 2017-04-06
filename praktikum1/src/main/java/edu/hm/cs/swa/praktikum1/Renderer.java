package edu.hm.cs.swa.praktikum1;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
/**
 *  .
 * 
 *
 */
public class Renderer {
    private final Object obj;
    /**
	 * 
	 * @param args .
	 * @throws Exception .
	 */
	public static void main(String[] args) throws Exception {
		Renderer r = new Renderer(new SomeClass(5));
		r.render();
		
	}
	/**
	 * .
	 * @param o .
	 */
	public Renderer(Object o) {
		obj = o;
	}
	/**
	 * .
	 * @return .
	 */
	public String render() {
	    String fields = renderFields();
	    //System.out.println(fields);
		return fields;
	}
	private String renderFields(){
	    String tmp = "";
	    try{
	        Class< ? > cut = Class.forName("edu.hm.cs.swa.praktikum1.SomeClass");
	        tmp += "Instance of " + cut.getName() + ":\n";
	        Field[] fields = cut.getDeclaredFields();
	        for (Field f : fields) {
	            Annotation[] annos = f.getAnnotations();
	            for(Annotation anno : annos){
	                if(anno instanceof RenderMe){
	                    RenderMe myAnno = (RenderMe) anno;
	                    String withParam = myAnno.with();
	                    if(!withParam.equals("")){
	                        Class < ? > objClass = Class.forName(withParam);
	                        CustomRenderInterface cri = (CustomRenderInterface)objClass.newInstance();
	                        tmp += f.getName() + " (Type " + f.getType().getSimpleName() + ") " + cri.render(f.get(obj));
	                    }else{
	                        tmp += f.getName() + " (Type " + f.getType().getName() + "): " + f.get(obj) + "\n"; 
	                    }
	                }
	            }
	        }
	        return tmp;
	    }catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        return tmp;
	    }
	}
}
