package com.moodanalyserfactory.java;

public class MoodAnalysesException extends Throwable {

    public enum exceptionType { ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, METHOD_INVOCATION_ISSUE,
        NO_ACCESS, OBJECT_CREATION_ISSUE, NO_SUCH_FIELD,FIELD_SETTING_ISSUE};
    exceptionType type;

    public MoodAnalysesException(String message) {
        super(message);
    }

    public MoodAnalysesException( exceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
