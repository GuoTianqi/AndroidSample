package com.daybreak.androidsample.materialdesign.items;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daybreak.androidsample.BaseToolBarActivity;
import com.daybreak.androidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeRefreshLayoutActivity extends BaseToolBarActivity {
    private static final String TAG = SwipeRefreshLayoutActivity.class.getSimpleName();

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private int mItemCount = 16;
    private boolean mLoadingMore = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_swipe_refresh_layout);

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
                            mItemCount += 10;
                            mRecyclerView.getAdapter().notifyDataSetChanged();
                        }
                    }, 1000);
                }
            }
        });

        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
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

        mRecyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_refresh_layout_item_view, parent, false);

                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.mTitleTv.setText("TITLE " + position);
                holder.mDescTv.setText("DESC " + position + "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
            }

            @Override
            public int getItemCount() {
                return mItemCount;
            }
        });
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
}
