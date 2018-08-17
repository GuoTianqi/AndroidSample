package com.daybreak.androidsample;

import android.support.v7.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by GuoTianqi on 2017/4/20.
 */

abstract public class BaseClassListActivity extends BaseToolBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_base_class_list);

        mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this, getClassList(), new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (BaseClassListActivity.this.onItemClick(position)) {
                    return;
                }

                Context context = BaseClassListActivity.this;
                if (context != null) {
                    context.startActivity(new Intent(context, getClassList()[position]));
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    abstract public Class[] getClassList();


    public boolean onItemClick(final int position) {
        return false;
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public static interface OnItemClickListener {
        public void onItemClick(int position);
    }

    private WeakReference<Context> mContextRef;
    private Class[] mActivityClasses;
    private OnItemClickListener mOnItemClickListener;

    public MyAdapter(Context context, Class[] activityClasses, OnItemClickListener listener) {
        mContextRef = new WeakReference<Context>(context);
        mActivityClasses = activityClasses;
        mOnItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(mActivityClasses[position].getSimpleName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mActivityClasses.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }
}
