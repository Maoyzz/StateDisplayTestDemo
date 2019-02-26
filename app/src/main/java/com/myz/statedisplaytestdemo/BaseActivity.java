package com.myz.statedisplaytestdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;

/**
 * @author myz
 * @date 2019/2/26
 * desc:所有Activity的基类
 */
public class BaseActivity extends AppCompatActivity{

    private View mViewLoadError;

    private View mViewNoContent;

    private View mViewNoNet;

    private ProgressBar mViewLoading;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setUpView();
    }

    protected void setUpView(){
        mViewLoading = findViewById(R.id.loading);
    }

    protected void startLoading(){
        mViewLoading.setVisibility(View.VISIBLE);
        hideLoadError();
        hideNoContent();
        hideNoNet();
    }


    protected void showLoadError(){
        if(mViewLoading.getVisibility() == View.VISIBLE){
            mViewLoading.setVisibility(View.GONE);
        }
        hideNoContent();
        hideNoNet();

        if(mViewLoadError != null){
            mViewLoadError.setVisibility(View.VISIBLE);
        }

        ViewStub viewStub = findViewById(R.id.loadErrorView);
        if(viewStub != null){
            mViewLoadError = viewStub.inflate();
        }
    }

    protected void hideLoadError(){
        if(mViewLoadError != null){
            mViewLoadError.setVisibility(View.GONE);
        }
    }

    protected void showNoContent(){
        if(mViewLoading.getVisibility() == View.VISIBLE){
            mViewLoading.setVisibility(View.GONE);
        }
        hideNoNet();
        hideLoadError();
        if(mViewNoContent != null){
            mViewNoContent.setVisibility(View.VISIBLE);
        }

        ViewStub viewStub = findViewById(R.id.noContentView);
        if(viewStub != null){
            mViewNoContent = viewStub.inflate();
        }
    }

    protected void hideNoContent(){
        if(mViewNoContent != null){
            mViewNoContent.setVisibility(View.GONE);
        }
    }

    protected void showNoNet(){
        if(mViewLoading.getVisibility() == View.VISIBLE){
            mViewLoading.setVisibility(View.GONE);
        }
        hideNoContent();
        hideLoadError();
        if(mViewNoNet != null){
            mViewNoNet.setVisibility(View.VISIBLE);
        }

        ViewStub viewStub = findViewById(R.id.badNetworkView);
        if(viewStub != null){
            mViewNoNet = viewStub.inflate();
        }
    }

    protected void hideNoNet(){
        if(mViewNoNet != null){
            mViewNoNet.setVisibility(View.GONE);
        }
    }
}
