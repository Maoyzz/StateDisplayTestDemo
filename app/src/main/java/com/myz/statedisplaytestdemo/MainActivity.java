package com.myz.statedisplaytestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
    }

    @Override
    protected void setUpView() {
        super.setUpView();
        findViewById(R.id.btn_loading).setOnClickListener(this);
        findViewById(R.id.btn_no_content).setOnClickListener(this);
        findViewById(R.id.btn_no_net).setOnClickListener(this);
        findViewById(R.id.btn_load_error).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_loading:
                startLoading();
                break;
            case R.id.btn_no_content:
                showNoContent();
                break;
            case R.id.btn_no_net:
                showNoNet();
                break;
            case R.id.btn_load_error:
                showLoadError();
                break;
            default:
        }
    }
}
