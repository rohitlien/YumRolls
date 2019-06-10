package com.yummrolls.yumrolls.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.adapters.ProductCardAdapter;
import com.yummrolls.yumrolls.models.RealmProductInfoModel;
import com.yummrolls.yumrolls.utils.RealmHelper;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView cartProductListView;
    private ImageView backButton;
    private LinearLayout order_ll;
    private TextView tv_total_price;
    private ArrayList<RealmProductInfoModel> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();
    }

    private void initViews() {
        backButton = (ImageView) findViewById(R.id.back_button);
        cartProductListView = (ListView) findViewById(R.id.cart_product_lv);
        order_ll = (LinearLayout) findViewById(R.id.order_ll);
        tv_total_price=(TextView)findViewById(R.id.total_cost_tv);
        tv_total_price.setVisibility(View.GONE);

        products= RealmHelper.getAddedProducts();
        ProductCardAdapter productCardAdapter=new ProductCardAdapter(this,products);
        cartProductListView.setAdapter(productCardAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        int total=0;
        if(products!=null){
            for(int i=0;i<products.size();i++){
                total=total+products.get(i).getProduct_count()*(Integer.parseInt(products.get(i).getProductCost()));
            }
        }
        if(total>0){
            tv_total_price.setVisibility(View.VISIBLE);
            tv_total_price.setText("Total price (Rs "+total+")");
        }
    }

    @Override
    protected void onDestroy() {
        //RealmHelper.deleteAll();
        super.onDestroy();
    }
}
