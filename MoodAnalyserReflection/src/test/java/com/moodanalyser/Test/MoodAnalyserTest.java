package com.moodanalyser.Test;


import com.moodanalyserfactory.java.MoodAnalyser;
import com.moodanalyserfactory.java.MoodAnalyserReflector;
import com.moodanalyserfactory.java.MoodAnalysesException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void whenMood_IsSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void whenIn_AnyMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void whenMood_IsNull_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(" ");
        String mood = " ";
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void whenMood_IsNull_ShouldReturn_CustomException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            Assert.assertEquals("ENTERED_NULL", e.getMessage());
        }
    }

    @Test
    public void whenMood_IsNull_ShouldReturn_CustomException_WithExceptionType() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            Assert.assertEquals("ENTERED_NULL", e.getMessage());
        }
    }

    @Test
    public void whenMood_IsEmpty_ShouldReturn_CustomException_WithExceptionType() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            String mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            Assert.assertEquals("ENTERED_EMPTY", e.getMessage());
        }
    }

    @Test
    public void whenMood_ClassIsNotAvailable_ShouldReturn_CustomException_WithNoSuchMETHOD() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject();
       } catch (MoodAnalysesException e) {
           Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
      }
    }

    @Test
    public void whenMood_ConstructorIsNotValid_ShouldReturn_CustomException_WithNoSuchCLASS() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject();
        } catch (MoodAnalysesException e) {
            Assert.assertEquals("NO_SUCH_CLASS", e.getMessage());
        }
    }


    @Test
    public void givenHappyMessage_WithReflection_InCorrectMethod_ShouldReturn_NoSuchMethodError() {
        try {
            Object obj = MoodAnalyserReflector.createMoodAnalyserObject("I m in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(obj, "analyseMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenMoodAnalyser_onChangeMood_ShouldReturnHappy() {
        try {
            Object myobj = MoodAnalyserReflector.createMoodAnalyserObject("");
            MoodAnalyserReflector.setFieldValue(myobj, "message", "I m in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myobj, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
    }

}
