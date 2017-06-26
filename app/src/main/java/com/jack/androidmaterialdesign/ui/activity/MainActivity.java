package com.jack.androidmaterialdesign.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jack.androidmaterialdesign.R;
import com.jack.androidmaterialdesign.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.toolBar1)
//    public Toolbar toolbar;
    @BindView(R.id.listView)
    public ListView listView;


    @Override
    protected void initAfter() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        String[] str = new String[100];
        for (int i = 0; i < 100; i++) {
            str[i] = "" + i;

        }

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str));


    }
}
