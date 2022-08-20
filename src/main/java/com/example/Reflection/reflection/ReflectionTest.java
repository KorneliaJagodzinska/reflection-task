package com.example.Reflection.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.lang.reflect.Modifier;

public class ReflectionTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<Student> descriptor = Student.class;

        for (Method method : descriptor.getMethods()) {
            System.out.println(method.getName());
        }

        int modifiers = descriptor.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);

        System.out.println(isPublic);
        System.out.println(isAbstract);

        Constructor<Student> constructor
                = descriptor.getConstructor(new Class[]{String.class, String.class, int.class});

        Student student = constructor.newInstance();
        System.out.println(student.getIndexNumber());
    }
}
