package oop.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("oop.reflection.Human");

        System.out.println(aClass.getName());

//        Field fields[] = aClass.getFields();
        Field fields[] = aClass.getDeclaredFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field.getName());
        }

//        Constructor constructor = aClass.getConstructor();
//        Human human = (Human) constructor.newInstance(1);
//        System.out.println(human.getHeigth());

        Constructor constructor = aClass.getDeclaredConstructor(double.class);
        constructor.setAccessible(true);
        Human human = (Human) constructor.newInstance(1.85);
        System.out.println(human.getHeigth());

        Method methods[] = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " " +
                    method.getReturnType() + " " +
                    method.getParameterCount());
        }


        Method method = aClass.getMethod("grow", Double.TYPE);
        method.invoke(human,0.2);
        System.out.println(human.getHeigth());

        Method methodWithReturn = aClass.getMethod("getHeigth");
        Double result = (Double) methodWithReturn.invoke(human);
        System.out.println(result.getClass());
    }
}