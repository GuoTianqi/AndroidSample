package com.daybreak.androidsample.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by GuoTianqi on 2017/5/27.
 */

public class LogHistory implements Parcelable {
    public static class Entry implements Parcelable {
        public String first;
        public long second;

        public Entry(String first, long second) {
            this.first = first;
            this.second = second;
        }

        protected Entry(Parcel in) {
            first = in.readString();
            second = in.readLong();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(first);
            dest.writeLong(second);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<Entry> CREATOR = new Creator<Entry>() {
            @Override
            public Entry createFromParcel(Parcel in) {
                return new Entry(in);
            }

            @Override
            public Entry[] newArray(int size) {
                return new Entry[size];
            }
        };
    }

    private List<Entry> mEntryList = new ArrayList<>();

    public LogHistory() {

    }

    protected LogHistory(Parcel in) {
        mEntryList = in.createTypedArrayList(Entry.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mEntryList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LogHistory> CREATOR = new Creator<LogHistory>() {
        @Override
        public LogHistory createFromParcel(Parcel in) {
            return new LogHistory(in);
        }

        @Override
        public LogHistory[] newArray(int size) {
            return new LogHistory[size];
        }
    };

    public void addEntry(String first, long second) {
        mEntryList.add(new Entry(first, second));
    }

    public List<Pair<String, Long>> getData() {
        List<Pair<String, Long>> list = new ArrayList<>(mEntryList.size());
        for (Entry entry : mEntryList) {
            list.add(new Pair<String, Long>(entry.first, entry.second));
        }

        return list;
    }
}
