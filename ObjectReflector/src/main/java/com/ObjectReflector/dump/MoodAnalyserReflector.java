package com.ObjectReflector.dump;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyserObject(String msg) throws MoodAnalysesException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyserfactory.java.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            return (MoodAnalyser) moodConstructor.newInstance(msg);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_SUCH_CLASS,"NO_SUCH_CLASS_ERROR");
        } catch (InstantiationException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.METHOD_INVOCATION_ISSUE,"METHOD_INVOCATION_ISSUE");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD_ERROR");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_ACCESS,"NO_ACCESS");
        }
    }

    public static MoodAnalyser createMoodAnalyserObject() throws MoodAnalysesException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyserfactory.java.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(Object.class);
            return (MoodAnalyser) moodConstructor.newInstance();
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_SUCH_CLASS,"NO_SUCH_CLASS_ERROR");
        } catch (InstantiationException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.OBJECT_CREATION_ISSUE,"OBJECT_CREATION_ISSUE");
        } catch (InvocationTargetException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.METHOD_INVOCATION_ISSUE,"METHOD_INVOCATION_ISSUE");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_SUCH_METHOD,"NO_SUCH_METHOD_ERROR");
        } catch (IllegalAccessException e) {
            throw new MoodAnalysesException(MoodAnalysesException.exceptionType.NO_ACCESS,"NO_ACCESS");
        }
    }
}