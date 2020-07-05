package net.osmtracker.util;

import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.util.Log;

import net.osmtracker.OSMTracker;
import net.osmtracker.layout.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;




@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
public class URLValidatorTest extends URLValidatorTask{

    

    public URLValidatorTask createTaskMock(){
        // URLValidatorTask validatorMock = mock(URLValidatorTask.class);
        URLValidatorTask validatorMock = new URLValidatorTask();
        //  when(validatorMock.doInBackground()).thenThrow(NullPointerException.class);
        return validatorMock;
    }

    @Test
    public void validateCorrectURL(){
        URLValidatorTask validator = createTaskMock();
        String[] urlComponents = {"labexp","osmtracker-android-layouts","master"};
        boolean result = doInBackground(urlComponents);
        //Mockito.verify(validator, Mockito.atLeastOnce()).doInBackground(urlComponents);
        assertTrue(result);
    }


    //@Test
    public void validateWrongURL(){
        URLValidatorTask validator = createTaskMock();
        String[] urlComponents = {"username", "repository","branch"};
        boolean result = doInBackground(urlComponents);
        //Mockito.verify(validator, Mockito.atLeastOnce()).doInBackground(urlComponents);
        assertFalse(result);
    }
}