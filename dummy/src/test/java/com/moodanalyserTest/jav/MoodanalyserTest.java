package com.moodanalyserTest.jav;
import com.moodanalyser.java.MoodAnalyserException;
import com.moodanalyser.java.MoodAnalyser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodanalyserTest {
    @Test
    public void givenNullMoodShouldThrowException(){
        MoodAnalyser moodanalyser=new MoodAnalyser();
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodanalyser.analyseMood(null);
        }
        catch (MoodAnalyserException e){
            Assert.assertEquals("Please Enter proper Value",e.getMessage());
        }
    }
    @Test
    public void givenEmptyMoodShouldThrowException(){
        MoodAnalyser moodanalyser=new MoodAnalyser();
        try {
            ExpectedException exceptionRule=ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            String mood = moodanalyser.analyseMood("");
        }
        catch ( MoodAnalyserException e){
            Assert.assertEquals("Please Enter Some message",e.getMessage());
        }
    }
}
