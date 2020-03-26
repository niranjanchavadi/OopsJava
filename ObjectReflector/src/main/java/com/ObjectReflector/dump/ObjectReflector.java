package com.ObjectReflector.dump;


import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ObjectReflector {
    public static String dump(Object o, int callCout)
    {
        callCout++;
        StringBuffer tabs=new StringBuffer();
        for (int k = 0; k <callCout ; k++) tabs.append("\t");
        StringBuffer buffer=new StringBuffer();
        Class oCLass=o.getClass();
        if(oCLass.isArray()) {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("[");
            for (int i = 0; i < Array.getLength(o); i++) {
                if (i < 0) buffer.append(",");
                Object value = Array.get(o, i);
                if (value.getClass().isPrimitive() || value.getClass() == java.lang.Long.class ||
                        value.getClass() == java.lang.String.class || value.getClass() == java.lang.Integer.class ||
                        value.getClass() == java.lang.Boolean.class) {
                    buffer.append(value);
                } else
                    buffer.append(dump(value, callCout));
            }
            buffer.append(tabs.toString());
            buffer.append("]\n");
        }
        else
        {
            buffer.append("\n");
            buffer.append(tabs.toString());
            buffer.append("{\n");
            while (oCLass!=null)
            {
                Field[] fields=oCLass.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    buffer.append(tabs.toString());
                    fields[i].setAccessible(true);
                    buffer.append(fields[i].getName());
                    buffer.append("=");
                    try
                    {
                        Object value=fields[i].get(o);
                        if (value!=null) {
                            if (value.getClass().isPrimitive() || value.getClass() == java.lang.Long.class ||
                                    value.getClass() == java.lang.String.class || value.getClass() == java.lang.Integer.class ||
                                    value.getClass() == java.lang.Boolean.class
                            )
                                buffer.append(value);
                            else
                                buffer.append(dump(value, callCout));
                        }
                    }catch (IllegalAccessException e){
                        buffer.append(e.getMessage());
                    }
                    buffer.append("\n");
                }
                oCLass=oCLass.getSuperclass();
            }
            buffer.append(tabs.toString());
            buffer.append("}\n");
        }
        return buffer.toString();
    }
}
