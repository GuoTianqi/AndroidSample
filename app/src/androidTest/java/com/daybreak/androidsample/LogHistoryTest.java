package com.daybreak.androidsample;

import android.os.Parcel;
import androidx.test.filters.SmallTest;
import androidx.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.daybreak.androidsample.data.LogHistory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by GuoTianqi on 2017/5/27.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class LogHistoryTest {
    public static final String TEST_STRING = "This is a string";
    public static final long TEST_LONG = 12345678L;

    private LogHistory mLogHistory;

    @Before
    public void createLogHistory() {
        mLogHistory = new LogHistory();
    }

    @Test
    public void logHistory_ParcelableWriteRead() {
        mLogHistory.addEntry(TEST_STRING, TEST_LONG);

        Parcel parcel = Parcel.obtain();
        mLogHistory.writeToParcel(parcel, mLogHistory.describeContents());

        parcel.setDataPosition(0);

        LogHistory createdFromParcel = LogHistory.CREATOR.createFromParcel(parcel);
        List<Pair<String, Long>> createdFromParcelData = createdFromParcel.getData();

        assertThat(createdFromParcelData.size(), is(1));
        assertThat(createdFromParcelData.get(0).first, is(TEST_STRING));
        assertThat(createdFromParcelData.get(0).second, is(TEST_LONG));
    }
}
