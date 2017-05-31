package com.github.guotianqi.androidsample.suite;

import com.github.guotianqi.androidsample.ClassUnderTest;
import com.github.guotianqi.androidsample.ExampleUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by GuoTianqi on 2017/5/27.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExampleUnitTest.class
})
public class UnitTestSuite {
}
