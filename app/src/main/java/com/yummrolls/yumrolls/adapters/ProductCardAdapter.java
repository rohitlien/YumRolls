package com.yummrolls.yumrolls.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.models.RealmProductInfoModel;

import java.util.ArrayList;

/**
 * Created by oust on 10/1/17.
 */

public class ProductCardAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RealmProductInfoModel> realmProductInfoModels;
    private LayoutInflater inflater;

    public ProductCardAdapter(Context context, ArrayList<RealmProductInfoModel> realmProductInfoModels) {
        this.context = context;
        this.realmProductInfoModels = realmProductInfoModels;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return realmProductInfoModels.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        convertView = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView=inflater.inflate(R.layout.cart_product,null);
            holder.productContent = (TextView) convertView.findViewById(R.id.product_content);
            holder.productName = (TextView) convertView.findViewById(R.id.product_name);
            holder.productCount = (TextView) convertView.findViewById(R.id.product_count);
            holder.productPrice=(TextView) convertView.findViewById(R.id.product_cost);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.productContent.setText(""+realmProductInfoModels.get(i).getProductContent());
        holder.productName.setText(""+realmProductInfoModels.get(i).getProductName());
        holder.productCount.setText(""+realmProductInfoModels.get(i).getProduct_count());
        holder.productPrice.setText("Rs "+realmProductInfoModels.get(i).getProductCost()+"/per item");


        return convertView;
    }
    public class ViewHolder{
        ImageView productImg;
        TextView productName,productContent,productPrice,productCount;
    }
}
