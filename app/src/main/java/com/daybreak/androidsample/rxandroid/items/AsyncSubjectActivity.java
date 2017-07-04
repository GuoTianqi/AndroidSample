package com.daybreak.androidsample.rxandroid.items;

import android.os.Bundle;
import android.widget.EditText;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectActivity extends BaseToolBarActivity {
    @BindView(R.id.editText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_async_subject);

        ButterKnife.bind(this);

        AsyncSubject<String> asyncSubject = AsyncSubject.create();
        asyncSubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mEditText.append("onSubscribe()\n");
            }

            @Override
            public void onNext(@NonNull String s) {
                mEditText.append(s + "\n");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                mEditText.append("onComplete()\n");
            }
        });

        asyncSubject.onNext("Hello");
        asyncSubject.onNext("World!");
        asyncSubject.onComplete();
    }
}
