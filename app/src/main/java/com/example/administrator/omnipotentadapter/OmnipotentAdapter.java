package com.example.administrator.omnipotentadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/4/17.
 */
public abstract class OmnipotentAdapter<T> extends BaseAdapter {
    private List<T> data;
    private int itemLayoutId;
    private Context context;
    public OmnipotentAdapter(Context context,List<T> data,int itemLayoutId) {
        this.data = data;
        this.context = context;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        return null == data ? 0 :data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OmnipotentViewHolder holder = getViewHolder(position,convertView,parent);
        convert(holder,getItem(position));
        return holder.getConvertView();
    }


    public abstract void convert(OmnipotentViewHolder holder,T item);
    private OmnipotentViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {

        return OmnipotentViewHolder.getInstance(context,position,itemLayoutId,parent,convertView);
    }
}
