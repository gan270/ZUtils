package com.chh.myutils.ioc;

import android.app.Activity;
import android.view.View;

/**
 * @ProjectName : chh.IntelliMattress
 * @Author : ganhs
 * @Time : 2021/4/16 9:02
 * @Description :
 */
public class ViewFinder {
    private Activity mActivity;
    private View mView;
    public ViewFinder(Activity activity){
        this.mActivity =activity;
    }
    public ViewFinder(View view){
        this.mView = view;
    }

    public View findViewById(int viewId){
        return mActivity!=null?mActivity.findViewById(viewId):mView.findViewById(viewId);
    }
}
