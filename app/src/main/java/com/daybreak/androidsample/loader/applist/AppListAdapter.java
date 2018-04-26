package com.daybreak.androidsample.loader.applist;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daybreak.androidsample.R;
import com.daybreak.androidsample.glide.GlideApp;
import com.daybreak.androidsample.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {
    private List<AppEntry> mDatas;
    private Activity mOwnerActivity;

    private OnItemClickListener<AppEntry> mOnItemClickListener;

    public AppListAdapter(Activity ownerActivitgy) {
        mDatas = new ArrayList<>();
        mOwnerActivity = ownerActivitgy;
    }

    public void setData(List<AppEntry> data) {
        mDatas.clear();
        if (data != null) {
            mDatas.addAll(data);
        }

        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<AppEntry> listener) {
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list_item_icon_text, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final AppEntry entry = mDatas.get(position);
        GlideApp.with(mOwnerActivity)
                .load(entry.getIcon())
                .into(holder.icon);
        holder.name.setText(entry.getLabel());

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClicked(position, entry);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.text)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}