package com.daybreak.androidsample.listener;

public interface OnItemClickListener<T> {
    void onItemClicked(int position, T data);
}
