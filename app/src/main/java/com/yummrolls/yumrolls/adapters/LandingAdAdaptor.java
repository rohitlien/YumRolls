package com.yummrolls.yumrolls.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yummrolls.yumrolls.R;

import java.util.List;

public class LandingAdAdaptor extends PagerAdapter {

    private List<Drawable> horizontalList;
    private Context context;

    public LandingAdAdaptor(Context context,List<Drawable> horizontalList){
        this.context=context;
        this.horizontalList=horizontalList;
    }

    @Override
    public int getCount() {
        return horizontalList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout =  inflater.inflate(R.layout.banner_layout, collection, false);
        ImageView banner_img=(ImageView) layout.findViewById(R.id.banner_img);
        banner_img.setImageDrawable(horizontalList.get(position));
        collection.addView(layout);
        return layout;
    }
}