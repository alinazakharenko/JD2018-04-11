package by.it.lanevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method [] methods = structMath.getDeclaredMethods();
        for (Method method : methods){
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println(method.toString().replaceAll("java.lang.Math.", ""));
        }
        Field[] fields = structMath.getFields();
        for (Field field : fields){
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
            System.out.println(field.toString().replaceAll("java.lang.Math.", ""));
        }

    }


}
