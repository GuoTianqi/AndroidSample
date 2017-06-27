package com.daybreak.androidsample.rxandroid.items;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.schedulers.Schedulers;

public class BaseUseRxAndroidActivity extends BaseToolBarActivity {
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_base_use_rx_android);

        ButterKnife.bind(this);

        Observable.just("Hello", "Hi", "Aloha")
                .subscribe(new Observer<String>() {
                    private String mStr;
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mStr = "";
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        mStr += s + " ";
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mTextView.setText(mStr);
                    }
                });

        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> emitter) throws Exception {
                Drawable drawable = ContextCompat.getDrawable(BaseUseRxAndroidActivity.this, R.drawable.flower);
                emitter.onNext(drawable);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Drawable>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Drawable drawable) {
                        mImageView.setImageDrawable(drawable);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i <= 20; i += 2) {
                    e.onNext(i);
                }

                e.onComplete();
            }
        });

    }
}
