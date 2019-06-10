package com.yummrolls.yumrolls.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.activities.LandingActivity;
import com.yummrolls.yumrolls.adapters.ProductInfoAdapter;
import com.yummrolls.yumrolls.models.ProductInfoModel;

import java.util.ArrayList;

/**
 * Created by oust on 9/6/17.
 */

public class ProductListFragment extends Fragment {
    private ArrayList<ProductInfoModel> productInfoModels;
    private RecyclerView productRecyclerView;

    public static ProductListFragment newInstance(ArrayList<ProductInfoModel> productInfoModels){
        ProductListFragment productListFragment=new ProductListFragment();
        productListFragment.productInfoModels=productInfoModels;
        return productListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_product_list,container,false);

        initViews(v);
        return v;
    }

    private void initViews(View v) {
        productRecyclerView=(RecyclerView)v.findViewById(R.id.productRecyclerView);
        LinearLayoutManager verticalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        productRecyclerView.setLayoutManager(verticalLayoutManagaer);

        ProductInfoAdapter productInfoAdapter=new ProductInfoAdapter(getActivity(),productInfoModels);
        productRecyclerView.setAdapter(productInfoAdapter);
    }
}
