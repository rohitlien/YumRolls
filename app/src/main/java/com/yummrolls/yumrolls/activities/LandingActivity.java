package com.yummrolls.yumrolls.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yummrolls.yumrolls.R;
import com.yummrolls.yumrolls.adapters.LandingAdAdaptor;
import com.yummrolls.yumrolls.adapters.NewProfileAdapter;
import com.yummrolls.yumrolls.adapters.ProductPagerAdapter;
import com.yummrolls.yumrolls.models.ProductCategoryData;
import com.yummrolls.yumrolls.models.ProductInfoModel;
import com.yummrolls.yumrolls.utils.RealmHelper;

import java.util.ArrayList;

public class LandingActivity extends AppCompatActivity {

    //RecyclerView adRecyclerView;
    private ArrayList<Drawable> adList=new ArrayList<>();
    private ArrayList<ProductCategoryData> productCategoryModels;
    private ViewPager productPager,bannerPager;
    ListView drawer_listview;
    DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView title;
    private static TextView tv_products_count;
    private static LinearLayout product_count_ll;
    public static int productCount=0;
    private ProductPagerAdapter productPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        toolbar = (Toolbar) findViewById(R.id.tabanim_toolbar);

        initViews();
        addDrower();
        getProductList();

        showLoader();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoader();
            }
        },1000);

    }
    private NewProfileAdapter newProfileAdapter;
    ActionBarDrawerToggle actionBarDrawerToggle;
    public void addDrower() {
        try {
            newProfileAdapter = new NewProfileAdapter(this);
            drawer_listview.setAdapter(newProfileAdapter);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("");

            // Getting reference to the ActionBarDrawerToggle
            actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.menu, 0, 0) {
                public void onDrawerClosed(View view) {}
                public void onDrawerOpened(View drawerView) {}
            };
            mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void initViews() {
        productPager=(ViewPager)findViewById(R.id.tabanim_viewpager);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh_layout);
        bannerPager=(ViewPager)findViewById(R.id.topbanner_viewpager);
        product_count_ll=(LinearLayout)findViewById(R.id.product_count_ll);
        tv_products_count=(TextView)findViewById(R.id.products_count);

        adList.add(getResources().getDrawable(R.drawable.chart1));
        adList.add(getResources().getDrawable(R.drawable.chart2));
        adList.add(getResources().getDrawable(R.drawable.chart3));

        LandingAdAdaptor landingAdapter = new LandingAdAdaptor(this,adList);
        bannerPager.setAdapter(landingAdapter);
        drawer_listview=(ListView)findViewById(R.id.newlanding_drawerlist);

        product_count_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LandingActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getProductList() {
        productCategoryModels=new ArrayList<>();
        ProductCategoryData productCategoryData1=new ProductCategoryData();
        productCategoryData1.setId("1");
        ArrayList<ProductInfoModel> products1=new ArrayList<>();
        ProductInfoModel productInfoModel1=new ProductInfoModel();
        productInfoModel1.setId(1);
        productInfoModel1.setProductName("Big Chicken Burger");
        productInfoModel1.setProductContent("Two slice chicken,Three slice cheese ,Mayonaaise and lot more");
        productInfoModel1.setProductCost("150");
        productInfoModel1.setProductImg(getResources().getDrawable(R.drawable.big_burger));
        products1.add(productInfoModel1);

        ProductInfoModel productInfoModel2=new ProductInfoModel();
        productInfoModel2.setProductName("Simple Veg Burger");
        productInfoModel2.setProductContent("One slice paneer-veg slice,One slice cheese ,Mayonaaise and lot more");
        productInfoModel2.setProductCost("140");
        productInfoModel2.setId(2);
        productInfoModel2.setProductImg(getResources().getDrawable(R.drawable.veg_cheese_burger));
        products1.add(productInfoModel2);

        ProductInfoModel productInfoModel3=new ProductInfoModel();
        productInfoModel3.setProductName("Double Chicken Cheese Burger");
        productInfoModel3.setProductContent("Two slice chicken,Three slice cheese ,Mayonaaise and lot more");
        productInfoModel3.setProductCost("150");
        productInfoModel3.setId(3);
        productInfoModel3.setProductImg(getResources().getDrawable(R.drawable.double_chicken_cheese));
        products1.add(productInfoModel3);

        productCategoryData1.setProductInfoModels(products1);
        productCategoryModels.add(productCategoryData1);

        ProductCategoryData productCategoryData2=new ProductCategoryData();
        productCategoryData2.setId("2");
        ArrayList<ProductInfoModel> products2=new ArrayList<>();
        ProductInfoModel productInfoModel4=new ProductInfoModel();
        productInfoModel4.setProductName("Chicken Roll");
        productInfoModel4.setProductContent("Freshly grinded chicken,fried and mixed onion,beans,carrot,Mayonaaise and lot more");
        productInfoModel4.setProductCost("70");
        productInfoModel4.setId(4);
        productInfoModel4.setProductImg(getResources().getDrawable(R.drawable.chicken_roll));
        products2.add(productInfoModel4);

        ProductInfoModel productInfoModel5=new ProductInfoModel();
        productInfoModel5.setProductName("Veg Roll");
        productInfoModel5.setProductContent("Fresh paneer mixed with freshly cut cucumber, mixed onion,beans,carrot,Mayonaaise and lot more");
        productInfoModel5.setProductCost("60");
        productInfoModel5.setId(5);
        productInfoModel5.setProductImg(getResources().getDrawable(R.drawable.paneer_roll));
        products2.add(productInfoModel5);

        ProductInfoModel productInfoModel6=new ProductInfoModel();
        productInfoModel6.setProductName("Egg Kathi Roll");
        productInfoModel6.setProductContent("Egg with fresh vegetables fried together.");
        productInfoModel6.setProductCost("50");
        productInfoModel6.setId(6);
        productInfoModel6.setProductImg(getResources().getDrawable(R.drawable.egg_kathi_roll));
        products2.add(productInfoModel6);

        productCategoryData2.setProductInfoModels(products2);
        productCategoryModels.add(productCategoryData2);

        ProductCategoryData productCategoryData3=new ProductCategoryData();
        productCategoryData3.setId("3");
        ArrayList<ProductInfoModel> products3=new ArrayList<>();
        ProductInfoModel productInfoModel7=new ProductInfoModel();
        productInfoModel7.setProductName("Chicken Momo");
        productInfoModel7.setProductContent("Fresh chicken slowly cooked with fresh vegetables.");
        productInfoModel7.setProductCost("80");
        productInfoModel7.setId(7);
        productInfoModel7.setProductImg(getResources().getDrawable(R.drawable.chicken_momos));
        products3.add(productInfoModel7);

        ProductInfoModel productInfoModel8=new ProductInfoModel();
        productInfoModel8.setProductName("Veg Momo");
        productInfoModel8.setProductContent("Fresh vegetables slowly cooked with mayonaaise and various dips.");
        productInfoModel8.setProductCost("50");
        productInfoModel8.setId(8);
        productInfoModel8.setProductImg(getResources().getDrawable(R.drawable.veg_momo));
        products3.add(productInfoModel8);

        ProductInfoModel productInfoModel9=new ProductInfoModel();
        productInfoModel9.setProductName("Chicken Fried Momo");
        productInfoModel9.setProductContent("Fresh momos fried in apt temperature.");
        productInfoModel9.setProductCost("100");
        productInfoModel9.setId(9);
        productInfoModel9.setProductImg(getResources().getDrawable(R.drawable.chicken_fried_momos));
        products3.add(productInfoModel9);

        productCategoryData3.setProductInfoModels(products3);
        productCategoryModels.add(productCategoryData3);

        ProductCategoryData productCategoryData4=new ProductCategoryData();
        productCategoryData1.setId("1");
        ArrayList<ProductInfoModel> products4=new ArrayList<>();
        ProductInfoModel productInfoModel10=new ProductInfoModel();
        productInfoModel10.setProductName("Simple French Fries");
        productInfoModel10.setProductContent("Great French fries with usual salty taste");
        productInfoModel10.setProductCost("40");
        productInfoModel10.setId(10);
        productInfoModel10.setProductImg(getResources().getDrawable(R.drawable.french_fries));
        products4.add(productInfoModel10);

        ProductInfoModel productInfoModel11=new ProductInfoModel();
        productInfoModel11.setProductName("Crispy Fries");
        productInfoModel11.setProductContent("Extra crispy , Extra masala fries");
        productInfoModel11.setProductCost("50");
        productInfoModel11.setId(11);
        productInfoModel11.setProductImg(getResources().getDrawable(R.drawable.crisp_fries));
        products4.add(productInfoModel11);

        ProductInfoModel productInfoModel12=new ProductInfoModel();
        productInfoModel12.setProductName("French fries with dip");
        productInfoModel12.setProductContent("Masala French fries with selected dip and with extra crisp");
        productInfoModel12.setProductCost("65");
        productInfoModel12.setId(12);
        productInfoModel12.setProductImg(getResources().getDrawable(R.drawable.masalafrieswithdip));
        products4.add(productInfoModel12);

        productCategoryData4.setProductInfoModels(products4);
        productCategoryModels.add(productCategoryData4);


        productPagerAdapter=new ProductPagerAdapter(getSupportFragmentManager(),this,productCategoryModels);
        productPager.setAdapter(productPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(productPager);

    }

    private void showLoader(){
        try {
            //swipeRefreshLayout.setColorSchemeColors(OustSdkTools.getColorBack(R.color.Orange), OustSdkTools.getColorBack(R.color.LiteGreen), OustSdkTools.getColorBack(R.color.Orange), OustSdkTools.getColorBack(R.color.LiteGreen));
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void hideLoader(){
        try{
            swipeRefreshLayout.setRefreshing(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        swipeRefreshLayout.setVisibility(View.GONE);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the drawer is open, hide action items related to the content view
        mDrawerLayout.isDrawerOpen(drawer_listview);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();


        if (mDrawerLayout.isDrawerOpen(drawer_listview)) {
            mDrawerLayout.closeDrawer(drawer_listview);
        } else {
            mDrawerLayout.openDrawer(drawer_listview);
        }
        return true;
    }
    public static void calculateProductCount(boolean addProduct){
        if(addProduct){
            productCount++;
            product_count_ll.setVisibility(View.VISIBLE);
        }else{
            if(productCount==1){
                product_count_ll.setVisibility(View.GONE);
            }
            if(productCount>=1)
                productCount--;

        }
        tv_products_count.setText(""+productCount);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        RealmHelper.deleteAll();
        productCount=0;
        super.onDestroy();
    }
}
