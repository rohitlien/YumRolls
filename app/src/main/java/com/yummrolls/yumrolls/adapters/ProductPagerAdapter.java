package com.yummrolls.yumrolls.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yummrolls.yumrolls.fragments.ProductListFragment;
import com.yummrolls.yumrolls.models.ProductCategoryData;

import java.util.ArrayList;

/**
 * Created by oust on 9/6/17.
 */

public class ProductPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private ArrayList<ProductCategoryData> productCategoryDatas;
    public ProductPagerAdapter(FragmentManager fm,Context context,ArrayList<ProductCategoryData> productCategoryDatas) {
        super(fm);
        this.context=context;
        this.productCategoryDatas=productCategoryDatas;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment= ProductListFragment.newInstance(productCategoryDatas.get(position).getProductInfoModels());
        return fragment;
    }

    @Override
    public int getCount() {
        return productCategoryDatas.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Burgers";
            case 1:
                return "Rolls";
            case 2:
                return "Momos";
            case 3:
                return "Fries";
            default:
                return null;
        }
    }
}
