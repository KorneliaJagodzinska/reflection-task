package com.example.Reflection.reflection;

import java.awt.print.Book;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ReflectiontestPrivate {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        Student student = new Student(generateRandomString());
        Field signatureField = Student.class.getDeclaredField("signature");
        signatureField.setAccessible(true);

        String value = (String)signatureField.get(student);
        System.out.println(value);

        Method rentBookMethod = Student.class.getDeclaredMethod("getIndexNumber");
        rentBookMethod.setAccessible(true);

        boolean result = (boolean)rentBookMethod.invoke(student);
        System.out.println(result);

        Method setDetailsMethod
                = Book.class.getDeclaredMethod("setDetails", new Class[]{String.class, int.class});

        setDetailsMethod.setAccessible(true);
        setDetailsMethod.invoke(student, "new Signature", 1990);
        System.out.println(student.getIndexNumber());

    }

    public static String generateRandomString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
