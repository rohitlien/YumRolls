package com.yummrolls.yumrolls.utils;

import android.content.Context;

import com.yummrolls.yumrolls.models.ProductInfoModel;
import com.yummrolls.yumrolls.models.RealmProductInfoModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by oust on 10/1/17.
 */

public class RealmHelper {

    public static void setDefaultConfig(Context context) {
        RealmConfiguration config = new RealmConfiguration.Builder(context)
                .name("yumrolls.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public static void addorUpdateProductCart(final ProductInfoModel productInfoModel) {
        if(productInfoModel!=null){
            final RealmProductInfoModel realmProductInfoModel=new RealmProductInfoModel();
            realmProductInfoModel.setId(productInfoModel.getId());
            realmProductInfoModel.setProduct_count(1);
            realmProductInfoModel.setProductContent(productInfoModel.getProductContent());
            realmProductInfoModel.setProductName(productInfoModel.getProductName());
            realmProductInfoModel.setProductCost(productInfoModel.getProductCost());
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {

                @Override
                public void execute(Realm realm) {
                    realm.copyToRealmOrUpdate(realmProductInfoModel);
                }
            });
            realm.close();

        }
    }
    public static void updateProductCount(int id,int count){
        Realm realm=Realm.getDefaultInstance();
        RealmResults<RealmProductInfoModel> results=realm.where(RealmProductInfoModel.class).equalTo("id",id).findAll();
        if(results.size()>0){
            RealmProductInfoModel realmProductInfoModel=results.first();
            realm.beginTransaction();
            realmProductInfoModel.setProduct_count(count);
            realm.commitTransaction();
        }
        realm.close();
    }
    public static void deleteProductFromCart(int id){
        Realm realm=Realm.getDefaultInstance();
        RealmResults<RealmProductInfoModel> results=realm.where(RealmProductInfoModel.class).equalTo("id",id).findAll();
        if(results.size()>0){
            RealmProductInfoModel realmProductInfoModel=results.first();
            realm.beginTransaction();
            realmProductInfoModel.deleteFromRealm();
            realm.commitTransaction();
        }
        realm.close();
    }


    public static ArrayList<RealmProductInfoModel> getAddedProducts(){
        Realm realm = Realm.getDefaultInstance();
        ArrayList<RealmProductInfoModel> realmProductInfoModels=new ArrayList<>();
        RealmResults<RealmProductInfoModel> results=realm.where(RealmProductInfoModel.class).findAll();
        for(RealmProductInfoModel realmProductInfoModel:results){
            realmProductInfoModels.add(realmProductInfoModel);
        }
        return realmProductInfoModels;
    }

    public static void deleteAll(){
        Realm realm=Realm.getDefaultInstance();
        RealmResults<RealmProductInfoModel> results=realm.where(RealmProductInfoModel.class).findAll();
        if(results.size()>0){
            realm.beginTransaction();
            results.deleteAllFromRealm();
            realm.commitTransaction();
        }
        realm.close();
    }
}
