package com.example.administrator.omnipotentadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/17.
 */
public class OmnipotentViewHolder {
    /**
     * 稀疏数组里面存放的是item里面所有的控件
     */
    private SparseArray<View> mViews;
    private int position;
    private View convertView;
    private OmnipotentViewHolder(Context context, int position, int layoutId, ViewGroup parent){
        mViews = new SparseArray<>();
        this.position = position;
        convertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        convertView.setTag(this);
    }

    /**
     * 单例模式
     * @param context
     * @param position
     * @param layoutId
     * @param parent
     * @param convertView
     * @return
     */
    public static OmnipotentViewHolder getInstance(Context context,int position, int layoutId, ViewGroup parent,View convertView){
        if (null == convertView){
            return new OmnipotentViewHolder(context,position,layoutId,parent);
        }
        return (OmnipotentViewHolder) convertView.getTag();
    }

    /**
     * 通过view的id获取相应的控件，因为不知道控件的类型，则使用泛型
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getViewById(int viewId){
        View view = mViews.get(viewId);
        if (null == view){
            view = convertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 为TextView填充数据
     * @param viewId
     * @param text
     * @return
     */
    public OmnipotentViewHolder setText(int viewId,String text){
        TextView view = getViewById(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为imageView设置图片
     * @param viewId
     * @param bitmap
     * @return
     */
    public OmnipotentViewHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView imageView = getViewById(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    public int getPosition(){
        return position;
    }

    public View getConvertView(){
        return convertView;
    }
}
