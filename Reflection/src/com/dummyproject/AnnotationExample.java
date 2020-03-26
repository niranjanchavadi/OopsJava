package com.dummyproject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    @Override
    @MethodInfo(author = "Niranjan", comments = "Main method", date = "Nov 27 2019", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "Nov 27 2019")
    public static void oldMethod() {
        System.out.println("old method,don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method : Annotation.class.getMethods()) {
//checks if MethodInfo annotation is present for method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
//iterates all the annotations available in method
                        for (java.lang.annotation.Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method" + method + ":" + annotation);
                        }
                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if (methodInfo.revision() == 1) {
                            System.out.println("Method with revision no 1 -" + method);
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}