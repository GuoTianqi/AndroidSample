package com.daybreak.androidsample.databinding.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;


import java.lang.ref.WeakReference;

/**
 * Created by guotianqi on 15/12/17.
 */
public class User {
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableBoolean isFriend = new ObservableBoolean();
    public ObservableBoolean isAdult = new ObservableBoolean();
    public ObservableField<String> email = new ObservableField<>();

    private WeakReference<Context> mContextRef;

    private static final String[] firstNames = {
            "AAAA",
            "BBBB",
            "CCCCCn",
            "DDDDDDD",
    };
    private static final String[] lastNames = {
            "GuoAA",
            "LinLLL",
            "GuoBBn",
            "GuoCCC",
    };

    private static final boolean[] isFriends = {
            true,
            true,
            false,
            false,
    };

    private static final boolean[] isAdults = {
            false,
            false,
            true,
            true,
    };

    public User(Context context, String firstName, String lastName,
                boolean isFriend, boolean isAdult) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.isFriend.set(isFriend);
        this.isAdult.set(isAdult);

        mContextRef = new WeakReference<Context>(context);
    }

    public void onClickFriend(View view) {
        Toast.makeText(mContextRef.get(), "isFriend", Toast.LENGTH_SHORT).show();
    }

    public void onClickEnemy(View view) {
        Toast.makeText(mContextRef.get(), "isEnemy", Toast.LENGTH_SHORT).show();
    }

    private int index = 0;
    public void changeAttr(View view) {
        index = (index + 1) % firstNames.length;
        this.firstName.set(firstNames[index]);
        this.lastName.set(lastNames[index]);
        this.isFriend.set(isFriends[index]);
        this.isAdult.set(isAdults[index]);
    }
}
