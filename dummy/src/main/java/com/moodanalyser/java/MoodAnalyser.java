package com.moodanalyser.java;

public class MoodAnalyser {


        public String analyseMood(String message) throws MoodAnalyserException {
            try {
                if (message.length()==0)
                    throw new MoodAnalyserException("Please Enter Some message");
                else if (message.contains("happy"))
                    return "happy";
                else
                    return "sad";
            }
            catch (NullPointerException e){
                throw new MoodAnalyserException("Please Enter proper Value");
            }
        }
    }
