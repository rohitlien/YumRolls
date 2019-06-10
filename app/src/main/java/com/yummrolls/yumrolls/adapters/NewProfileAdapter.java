package com.yummrolls.yumrolls.adapters;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yummrolls.yumrolls.R;

/**
 * Created by shilpysamaddar on 09/03/17.
 */

public class NewProfileAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater mInflater;
    private String userDisplayName,temporaryProfileImageDisplayName;

    public NewProfileAdapter(Activity activity) {
        this.activity = activity;
        mInflater = LayoutInflater.from(activity);
    }

    public void notifyDataChange(){
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        mInflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(R.layout.new_drawer_row, null);
        try {
//            RelativeLayout newprofile_layout=(RelativeLayout) convertView.findViewById(R.id.newprofile_layout);
//            TextView progresstext_val=(TextView) convertView.findViewById(R.id.progresstext_val);
//            TextView appversion_text=(TextView) convertView.findViewById(R.id.appversion_text);
//            ImageView avatar = (ImageView) convertView.findViewById(R.id.avatar);
//            TextView userprofileImageText= (TextView) convertView.findViewById(R.id.userprofileImageText);
//            TextView profileprogresstext=(TextView) convertView.findViewById(R.id.profileprogresstext);
//            TextView avatarName = (TextView) convertView.findViewById(R.id.userName);
//            TextView userId=(TextView) convertView.findViewById(R.id.userId);
//            RelativeLayout reportproblem_layout=(RelativeLayout) convertView.findViewById(R.id.reportproblem_layout);
//            RelativeLayout ousteventlayout=(RelativeLayout) convertView.findViewById(R.id.ousteventlayout);
//
//            RelativeLayout historylayout=(RelativeLayout) convertView.findViewById(R.id.historylayout);
//            TextView history_text=(TextView) convertView.findViewById(R.id.history_text);
//
//            RelativeLayout settinglayout=(RelativeLayout) convertView.findViewById(R.id.settinglayout);
//            TextView setting_text=(TextView) convertView.findViewById(R.id.setting_text);
//
//            RelativeLayout user_profile_layout=(RelativeLayout) convertView.findViewById(R.id.user_profile_layout);
//            TextView user_profile=(TextView) convertView.findViewById(R.id.user_profile);
//
//            RelativeLayout appratelayout=(RelativeLayout) convertView.findViewById(R.id.appratelayout);
//            TextView apprate_text=(TextView) convertView.findViewById(R.id.apprate_text);
//
//            RelativeLayout logoutLayout=(RelativeLayout) convertView.findViewById(R.id.logoutLayout);
//            TextView logout_text=(TextView) convertView.findViewById(R.id.logout_text);
//
//            RelativeLayout assessmentAnalytics_Layout=(RelativeLayout) convertView.findViewById(R.id.assessmentAnalytics_Layout);
//            TextView myassessment_text=(TextView) convertView.findViewById(R.id.myassessment_text);
//
//            RelativeLayout leaderboardlayout=(RelativeLayout) convertView.findViewById(R.id.leaderboardlayout);
//            TextView leaderboard_text=(TextView) convertView.findViewById(R.id.leaderboard_text);
//
//            RelativeLayout formfill_layout=(RelativeLayout) convertView.findViewById(R.id.formfill_layout);
//


        }catch (Exception e){
            e.printStackTrace();
        }
        return convertView;
    }
}
