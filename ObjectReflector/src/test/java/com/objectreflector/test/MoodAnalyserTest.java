package com.objectreflector.test;

import com.ObjectReflector.dump.MoodAnalyser;
import com.ObjectReflector.dump.MoodAnalyserReflector;
import com.ObjectReflector.dump.MoodAnalysesException;
import com.ObjectReflector.dump.ObjectReflector;
import org.hamcrest.CoreMatchers;
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
    public void whenMood_ClassIsNotAvailable_ShouldReturn_CustomException_WithNoSuchCLASS() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject();
        } catch (MoodAnalysesException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
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
    public void givenMoodMessage_ShouldReturnMessage() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("Testing my mood");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysesException e) {
            e.printStackTrace();
        }
        String dump = ObjectReflector.dump(moodAnalyser,0);
        Assert.assertThat(dump, CoreMatchers.containsString("Testing my mood"));

    }

}