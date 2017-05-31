package com.daybreak.androidsample.suite;

import com.daybreak.androidsample.LogHistoryTest;
import com.daybreak.androidsample.MainActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by GuoTianqi on 2017/5/27.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MainActivityTest.class,
        LogHistoryTest.class
})
public class UnitTestSuite {
}
