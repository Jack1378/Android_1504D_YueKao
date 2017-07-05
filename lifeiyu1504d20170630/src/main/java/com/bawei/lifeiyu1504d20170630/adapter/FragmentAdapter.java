package com.bawei.lifeiyu1504d20170630.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lifeiyu1504d20170630.R;
import com.bawei.lifeiyu1504d20170630.bean.HomeBean;
import com.bawei.lifeiyu1504d20170630.bean.MyBean;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * name ：李飞宇
 * Date: 2017/6/30
 * desc:
 */

public class FragmentAdapter extends BaseAdapter {
    private Context context;
    private List<MyBean.DataBean> Home_List = new ArrayList<>();

    public FragmentAdapter(Context context, List<MyBean.DataBean> Home_List) {
        this.context = context;
        this.Home_List = Home_List;
    }

    @Override
    public int getCount() {
        return Home_List.size();
    }

    @Override
    public Object getItem(int position) {
        return Home_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.listview_image_text, null);
            holder.imageView = (PhotoView) convertView.findViewById(R.id.photoView);
            holder.textView = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(Home_List.get(position).getNews_title());
        x.image().bind(holder.imageView, Home_List.get(position).getPic_url());
        return convertView;
    }

    class ViewHolder {
        TextView textView;
        PhotoView imageView;
    }
}
