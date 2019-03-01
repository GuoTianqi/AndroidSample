package com.daybreak.androidsample.materialdesign.items;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guotianqi on 2017/4/20.
 */

public class PageFragment extends Fragment {

    public static PageFragment newInstance() {
        PageFragment fragment = new PageFragment();
        return fragment;
    }

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecyclerView = new RecyclerView(getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return mRecyclerView;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(getContext());
                textView.setPadding(20, 20, 20, 20);
                ViewHolder viewHolder = new ViewHolder(textView);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.textView.setText("Item " + position);
            }

            @Override
            public int getItemCount() {
                return 20;
            }
        });
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}
