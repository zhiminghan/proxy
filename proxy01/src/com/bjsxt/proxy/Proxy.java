package com.bjsxt.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static void main(String args[]) throws Exception{ //JDK6 Complier API, CGLib, ASM
//		String methodStr = "";
		
		String rt = "\r\n";
		
//		Method[] methods = infce.getMethods();
		
//		for(Method m : methods) {
//			methodStr += "@Override" + rt + 
//						 "public void " + m.getName() + "() {" + rt +
//						 	"   long start = System.currentTimeMillis();" + rt +
//							"   System.out.println(\"starttime:\" + start);" + rt +
//							"   t." + m.getName() + "();" + rt +
//							"   long end = System.currentTimeMillis();" + rt +
//							"   System.out.println(\"time:\" + (end-start));" + rt +
//						 "}";
//		}
//		
//		for(Method m : methods) {
//			methodStr += "@Override" + rt + 
//						 "public void " + m.getName() + "() {" + rt +
//						 "    try {" + rt +
//						 "    Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
//						 "    h.invoke(this, md);" + rt +
//						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
//						
//						 "}";
//		}
		
		String src = 
			"package com.bjsxt.proxy;" +  rt +
			"import java.lang.reflect.Method;" + rt +
			  "public class Tank2 implements Moveable" +  "{" + rt +
			    " @Override" + rt + 
			         "public void move() {" + rt +
			"             Tank t=new Tank();" + rt +
			"             long startTime= System.currentTimeMillis();     " + rt +
			"             t.move();" + rt +
			"             long endTime= System.currentTimeMillis();" + rt +
			"             System.out.println(\"totalTime:\"+(endTime-startTime));" + rt +
			"            }"+ rt +
			"     }";	
			
			
		String fileName = System.getProperty("user.dir");
			
		File f = new File(fileName+"/src/com/bjsxt/proxy/Tank2.java");
		System.out.println(f.getAbsolutePath());
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		//compile
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();
		
		//load into memory and create an instance
//		URL[] urls = new URL[] {new URL("file:/" +System.getProperty("user.dir")+"/src")};
//		URLClassLoader ul = new URLClassLoader(urls);
//		Class c = ul.loadClass("com.bjsxt.proxy.Tank2");
//		System.out.println(c);
//		
//		Constructor ctr = c.getConstructor();
//    	Moveable m = (Moveable) ctr.newInstance();
//        m.move();
//		
	}
}
