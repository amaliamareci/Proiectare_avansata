package compulsory;

import java.io.File;
import java.lang.reflect.*;
import java.net.URL;

public class MyTestFramework {

    public static void main(String[] args) throws Exception {
        var classLoader = new CustomClassLoader();
        File path = new File("C:\\Users\\Amalia\\Desktop\\Lab12\\src\\main\\java\\compulsory");
        URL url = path.toURI().toURL();
        classLoader.addURL(url);
        System.out.println("Methods:");
        for (Method m : Class.forName("compulsory.MyProgram").getMethods()) {
            System.out.printf("%s %s(", m.getReturnType(), m.getName());
            for (var parameter : m.getParameterTypes())
                System.out.printf("%s, ", parameter.getName());
            System.out.println(")");
        }

        System.out.println();
        int passed = 0, failed = 0;
        System.out.println("Test methods");
        for (Method m : Class.forName("compulsory.MyProgram").getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    System.out.printf("Test %s passed\n", m.getName());
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s \n",
                            m.getName(), ex.getCause());
                    failed++;
                }
            }
        }

    }

}
