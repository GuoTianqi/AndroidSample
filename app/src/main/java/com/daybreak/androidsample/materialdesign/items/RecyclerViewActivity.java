package com.daybreak.androidsample.materialdesign.items;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daybreak.androidsample.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }

    ItemData[] myDataset = new ItemData[] {
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
            new ItemData(R.drawable.flower, "" +
                    "咬定青山不放松，立根原在破岩中。\n" +
                    "千磨万击还坚劲，任尔东西南北风。\n" +
                    "(坚劲 一作：韧"),
    };
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ItemData[] mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.image_view);
            mTextView = (TextView) v.findViewById(R.id.info_text);
        }
    }

    public MyAdapter(ItemData[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_view_item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(mDataset[position].imageResId);
        holder.mTextView.setText(mDataset[position].text);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}

class ItemData {
    public final int imageResId;
    public final String text;

    public ItemData(final int imageResId, final String text) {
        this.imageResId = imageResId;
        this.text = text;
    }
}
