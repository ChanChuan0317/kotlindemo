package com.chanchuan.kotlindemo;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.chanchuan.data.Data;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author : Chanchuan
 * Date       : 2020/12/11/011    下午 1:29
 */
public class Gank2Adapter extends BaseAdapter {
    private List<com.chanchuan.kotlindemo.Data> mData;
    private Context mContext;

    public Gank2Adapter(List<com.chanchuan.kotlindemo.Data> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        com.chanchuan.kotlindemo.Data data = mData.get(position);
        return data;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_gank, parent, false);
            holder = new ViewHolder();

            holder.simpleDraweeView = convertView.findViewById(R.id.sdv_image);
            com.chanchuan.kotlindemo.Data data = mData.get(position);
            holder.simpleDraweeView.setImageURI(Uri.parse(data.getUrl()));
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    class ViewHolder {
        SimpleDraweeView simpleDraweeView;
    }
}
