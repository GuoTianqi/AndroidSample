package com.daybreak.androidsample.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daybreak.androidsample.R;
import com.daybreak.androidsample.customview.view.PlaygroundView;

import java.lang.ref.WeakReference;

public class CustomViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Class[] myDataset = new Class[] {
                PlaygroundViewActivity.class,
                SloopViewActivity.class,
                PieViewActivity.class,
        };

        mAdapter = new MyAdapter(this, myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private WeakReference<Context> mContextRef;
    private Class[] mActivityClasses;
    public MyAdapter(Context context, Class[] activityClasses) {
        mContextRef = new WeakReference<Context>(context);
        mActivityClasses = activityClasses;
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
                Context context = mContextRef.get();
                if (context != null) {
                    context.startActivity(new Intent(context, mActivityClasses[position]));
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
