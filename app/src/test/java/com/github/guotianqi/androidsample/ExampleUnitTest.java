package com.github.guotianqi.androidsample;

import android.content.Context;

import com.daybreak.androidsample.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    private static final String FAKE_STRING = "AndroidSample";

    @Mock
    Context mMockContext;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void readStringFromContext_LocalizedString() {
        when(mMockContext.getString(R.string.app_name))
                .thenReturn(FAKE_STRING);

        ClassUnderTest myObjectUnderTest = new ClassUnderTest(mMockContext);

        String appName = myObjectUnderTest.getAppNameString();

        assertThat(appName, is(FAKE_STRING));
    }

    @Test
    public void mockedTest() {
        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        // when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        // System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));

        verify(mockedList).get(0);
    }
}