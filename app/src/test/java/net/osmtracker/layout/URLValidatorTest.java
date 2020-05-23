package net.osmtracker.layout;


import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.util.Log;

import net.osmtracker.OSMTracker;

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


import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Log.class)
public class URLValidatorTest {

    public URLValidatorTask createTaskMock(){
       // URLValidatorTask validatorMock = mock(URLValidatorTask.class);
        URLValidatorTask validatorMock = new URLValidatorTask();
      //  when(validatorMock.doInBackground()).thenThrow(NullPointerException.class);
        return validatorMock;
    }


    public void validateCorrectURL(){
        URLValidatorTask validator = createTaskMock();
        String[] urlComponents = {"labexp","osmtracker-android-layouts","master"};
        boolean result = validator.doInBackground(urlComponents);
        verify(validator,atLeastOnce()).doInBackground(urlComponents);
        when(Log.e("STRING")).thenThrow(Exception.class);
        assertTrue(result);
    }


    @Test
    public void validateWrongURL(){
        URLValidatorTask validator = createTaskMock();
        String[] urlComponents = {"username", "repository","branch"};
        boolean result = validator.doInBackground(urlComponents);
        verify(validator,atLeastOnce()).doInBackground(urlComponents);
        assertFalse(result);
    }
}
