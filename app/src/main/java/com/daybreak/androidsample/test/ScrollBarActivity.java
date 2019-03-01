package com.daybreak.androidsample.test;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.daybreak.androidsample.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollBarActivity extends AppCompatActivity {
    private static final String TAG = ScrollBarActivity.class.getSimpleName();

    @BindView(R.id.listView)
    MyListView mListView;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.editText)
    EditText mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_bar);

        ButterKnife.bind(this);

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("Guo Tianqi " + i);
        }

        mListView.setAdapter(new ArrayAdapter<String>(ScrollBarActivity.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, datas));
        mListView.setSmoothScrollbarEnabled(true);
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                try {
                    mTextView.setText("scrollRange = " + mListView.computeVerticalScrollRange() + "\n" +
                            "scrollOffset = " + mListView.computeVerticalScrollOffset() + "\n" +
                            "scrollExtend = " + mListView.computeVerticalScrollExtent() + "\n" +
                            "scrollBarSize = " + mListView.getScrollBarSize() + "\n" +
                            "scrollY = " + mListView.getScrollY() + "\n" +
                            "can scroll up = " + mListView.canScrollVertically(-1) + "\n" +
                            "can scroll down = " + mListView.canScrollVertically(1) + "\n" +
                            "child At 0 top = " + mListView.getChildAt(0).getTop() + "\n" +
                            "child At last bottom = " + mListView.getChildAt(mListView.getChildCount() - 1).getBottom() + "\n" +
                            "DecorViewHeight = " + getWindow().getDecorView().getHeight());
                } catch (NullPointerException npe) {

                }

            }
        });

        mEditText.setText("积分了文件反文儿积分乐网 福建我恩了反文儿老骥伏枥沃尔夫恩无机肥料沃尔夫\n" +
                "福建乐网积分加我恩了积分我力困筋乏拉弯儿风口浪尖我恩了积分乐网恩积分了加我恩老骥伏枥维吉尔服务恩了积分乐网二级风\n" +
                "发了库我恩及复礼克己我恩连接服务iofwpfqohfef曲颈瓶恩\n" +
                "佛二位加富尔了我房间里玩儿佛方可几碗饭");
        mEditText.setScrollX(-200);
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG,"scrollX = " + mEditText.getScrollX() + ", scrollY = " + mEditText.getScrollY());

                return false;
            }
        });
    }
}

class MyListView extends ListView {

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override
    public int computeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }
}