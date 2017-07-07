package com.daybreak.androidsample.rxandroid.items;

import android.os.Bundle;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class RxSingleActivity extends BaseToolBarActivity {
    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_rx_single);

        ButterKnife.bind(this);

        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> e) throws Exception {
                e.onSuccess("Hello world!");
            }
        }).subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                mTextView.append(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }
}
