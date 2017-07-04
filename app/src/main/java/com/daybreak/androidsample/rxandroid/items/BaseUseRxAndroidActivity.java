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
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
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
                .repeat(2)
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
        }).compose(new ObservableTransformer<Integer, String>() {
            @Override
            public ObservableSource<String> apply(@NonNull final Observable<Integer> upstream) {
                return new ObservableSource<String>() {

                    @Override
                    public void subscribe(@NonNull final Observer<? super String> observer) {
                        upstream.subscribe(new Observer<Integer>() {

                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                observer.onSubscribe(d);
                            }

                            @Override
                            public void onNext(@NonNull Integer integer) {
                                observer.onNext("" + integer);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                observer.onError(e);
                            }

                            @Override
                            public void onComplete() {
                                observer.onComplete();
                            }
                        });
                    }
                };
            }
        }).subscribe(new Observer<String>() {
            private String mStr;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mStr = "";
            }

            @Override
            public void onNext(@NonNull String s) {
                mStr += s;
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                mTextView.append("\n" + mStr);
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
        }).lift(new ObservableOperator<String, Integer>() {
            @Override
            public Observer<? super Integer> apply(@NonNull final Observer<? super String> observer) throws Exception {
                return new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        observer.onSubscribe(d);
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        observer.onNext("" + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        observer.onError(e);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }
                };
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

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
                for (int i = 0; i < 10; i++) {
                    e.onNext(i);
                }

                e.onComplete();
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull final Integer integer) throws Exception {
                return new ObservableSource<String>() {
                    @Override
                    public void subscribe(@NonNull Observer<? super String> observer) {
                        observer.onNext("String " + integer);
                        observer.onComplete();
                    }
                };
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mTextView.append("----------------\n");
            }

            @Override
            public void onNext(@NonNull String s) {
                mTextView.append(s + " || ");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                mTextView.append("--------------------\n");
            }
        });
    }
}
