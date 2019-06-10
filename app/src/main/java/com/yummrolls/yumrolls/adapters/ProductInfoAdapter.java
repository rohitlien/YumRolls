package com.yummrolls.yumrolls.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.activities.LandingActivity;
import com.yummrolls.yumrolls.models.ProductInfoModel;
import com.yummrolls.yumrolls.utils.RealmHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oust on 9/6/17.
 */

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoAdapter.MyViewHolder> {

private ArrayList<ProductInfoModel> productInfoModels;
private Context context;


public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView productImg,increment_img,decrement_img;
    public TextView productName,productPrice,productContent,product_count,addButton;
    LinearLayout product_count_ll;

    public MyViewHolder(View view) {
        super(view);
        productImg = (ImageView) view.findViewById(R.id.product_img);
        productName=(TextView)view.findViewById(R.id.product_name);
        productContent=(TextView)view.findViewById(R.id.product_content);
        productPrice=(TextView)view.findViewById(R.id.product_price);
        product_count_ll=(LinearLayout)view.findViewById(R.id.product_count_ll);
        product_count=(TextView)view.findViewById(R.id.product_count);
        increment_img=(ImageView)view.findViewById(R.id.increment_button);
        decrement_img=(ImageView)view.findViewById(R.id.decrement_button);
        addButton=(TextView)view.findViewById(R.id.addButton);
    }
}


    public ProductInfoAdapter(Context context, ArrayList<ProductInfoModel> productInfoModels) {
        this.productInfoModels = productInfoModels;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.productImg.setImageDrawable(productInfoModels.get(position).getProductImg());
        holder.productName.setText(""+productInfoModels.get(position).getProductName());
        holder.productPrice.setText("Rs "+productInfoModels.get(position).getProductCost());
        holder.productContent.setText(""+productInfoModels.get(position).getProductContent());

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LandingActivity.calculateProductCount(true);
                holder.addButton.setVisibility(View.GONE);
                holder.product_count_ll.setVisibility(View.VISIBLE);
                RealmHelper.addorUpdateProductCart(productInfoModels.get(position));
            }
        });

        holder.increment_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LandingActivity.calculateProductCount(true);
                String countStr=holder.product_count.getText().toString();
                int count=Integer.parseInt(countStr);
                holder.product_count.setText(""+(count+1));
                RealmHelper.updateProductCount(productInfoModels.get(position).getId(),count+1);
            }
        });
        holder.decrement_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LandingActivity.calculateProductCount(false);
                String countStr=holder.product_count.getText().toString();
                int count=Integer.parseInt(countStr);
                if(count==1){
                    holder.addButton.setVisibility(View.VISIBLE);
                    holder.product_count_ll.setVisibility(View.GONE);
                    RealmHelper.deleteProductFromCart(productInfoModels.get(position).getId());
                }else if(count>1){
                    holder.product_count.setText(""+(count-1));
                    RealmHelper.updateProductCount(productInfoModels.get(position).getId(),count+1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productInfoModels.size();
    }
}
