package com.daybreak.androidsample.materialdesign.items;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeRefreshLayoutActivity extends BaseToolBarActivity {
    private static final String TAG = SwipeRefreshLayoutActivity.class.getSimpleName();

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<ItemData> mItemDatas;
    private MyAdapter mMyAdapter;

    private LinearLayoutManager mLayoutManager;
    private boolean mLoadingMore = false;

    public static class ItemData {
        private static AtomicLong ID_GEN = new AtomicLong(0);

        public long id = ID_GEN.getAndIncrement();
        public String title;
        public String desc;

        public ItemData(String title, String desc) {
            this.title = id + "  " + title;
            this.desc = id + "  " + desc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);

        ButterKnife.bind(this);

        initRefreshLayout();
        initRecyclerView();
    }

    private void initRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeColors(
                Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.GRAY
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }

    private void initRecyclerView() {
        mLayoutManager = new LinearLayoutManager(SwipeRefreshLayoutActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.d(TAG, String.format("onScrolled:(%d, %d)", dx, dy));
                super.onScrolled(recyclerView, dx, dy);
                if (dy == 0) {
                    return;
                }

                int lastVisibleItemPos = mLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPos + 1 == mRecyclerView.getAdapter().getItemCount()) {
                    if (mSwipeRefreshLayout.isRefreshing()) {
                        return;
                    }

                    if (mLoadingMore) {
                        return;
                    }

                    mLoadingMore = true;

                    Log.d(TAG, "load more");

                    recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mLoadingMore = false;
                            int oldSize = mItemDatas.size();
                            generateItemData();
                            int newSize = mItemDatas.size();
                            mMyAdapter.notifyItemRangeInserted(oldSize, newSize - oldSize);
                        }
                    }, 1000);
                }
            }
        });

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            private Paint mPaint;
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                if (mPaint == null) {
                    mPaint = new Paint();
                    mPaint.setColor(Color.RED);
                }
                int padding = (int) (8 * parent.getResources().getDisplayMetrics().density);
                for (int i = 0; i < parent.getChildCount(); i++) {
                    View child = parent.getChildAt(i);
                    c.drawRect(child.getLeft(), child.getTop() - padding,
                            child.getRight(), child.getTop(), mPaint);

                    if (i == parent.getChildCount() - 1) {
                        c.drawRect(child.getLeft(), child.getBottom(), child.getRight(),
                                child.getBottom() + padding, mPaint);
                    }
                }
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildLayoutPosition(view) == 0) {
                    outRect.top = (int) (8 * parent.getResources().getDisplayMetrics().density);
                }

                outRect.left = outRect.right = outRect.bottom =
                        (int) (8 * parent.getResources().getDisplayMetrics().density);

            }
        });

        mItemDatas = new ArrayList<>();
        generateItemData();
        mMyAdapter = new MyAdapter(mItemDatas);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    private void generateItemData() {
        for (int i = 0; i < 10; i++) {
            ItemData itemData = new ItemData("TITLE", "DESC 哈哈哈哈哦哦哦哦哦 啦啦啦啦啦 有有有有有有有有有由于");
            mItemDatas.add(itemData);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_swipe_refresh_layout_activity, menu);
//        for(int i = 0; i < menu.size(); i++){
//            Drawable drawable = menu.getItem(i).getIcon();
//            if(drawable != null) {
//                drawable.mutate();
//                drawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
//            }
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                ItemData itemData = new ItemData("ADD", "ADD hahhahhhhhhhhhh");
                mItemDatas.add(7, itemData);
                mMyAdapter.notifyItemInserted(7);
                mRecyclerView.scrollToPosition(7);
                return true;
            case R.id.delete_item:
                mItemDatas.remove(1);
                mMyAdapter.notifyItemRemoved(1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView mTitleTv;

        @BindView(R.id.desc)
        TextView mDescTv;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    static class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<ItemData> mItemDatas;

        public MyAdapter(List<ItemData> itemDatas) {
            mItemDatas = itemDatas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_refresh_layout_item_view, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ItemData itemData = mItemDatas.get(position);
            holder.mTitleTv.setText(itemData.title);
            holder.mDescTv.setText(itemData.desc);
        }

        @Override
        public int getItemCount() {
            return mItemDatas.size();
        }
    }
}
