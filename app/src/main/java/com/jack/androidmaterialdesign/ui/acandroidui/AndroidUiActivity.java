package com.jack.androidmaterialdesign.ui.acandroidui;


import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jack.androidmaterialdesign.R;

import com.jack.androidmaterialdesign.base.BaseActivity;

import at.markushi.ui.ActionView;
import at.markushi.ui.RevealColorView;
import at.markushi.ui.action.BackAction;
import at.markushi.ui.action.CloseAction;
import at.markushi.ui.action.DrawerAction;
import at.markushi.ui.action.PlusAction;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * android_ui 控件
 * RevealColorView、ActionView
 */
public class AndroidUiActivity extends BaseActivity {


    @BindView(R.id.actionView)
    //菜单控件
    public ActionView actionView;
    @BindView(R.id.start)
    public Button start;
    @BindView(R.id.reveal)
    public RevealColorView revealColorView;
    private View selectedView;
    private int backgroundColor;

    private int position;


    @Override
    protected void initAfter() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_androidui;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        backgroundColor = Color.parseColor("#212121");

    }


    @OnClick({R.id.start, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onClick(View v) {
        if (position < 3) {
            position++;
        } else {
            position = 0;
        }
        switch (v.getId()) {
            case R.id.start:
                setActionView(position);
                break;
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
                final int color = getColor(v);
                final Point p = getLocationInView(revealColorView, v);

                if (selectedView == v) {
                    revealColorView.hide(p.x, p.y, backgroundColor, 0, 300, null);
                    selectedView = null;
                } else {
                    revealColorView.reveal(p.x, p.y, color, v.getHeight() / 2, 340, null);
                    selectedView = v;
                }
                break;

        }


    }

    public void setActionView(int position) {
        // ROTATE_COUNTER_CLOCKWISE 顺时针
        // ROTATE_CLOCKWISE 逆时针
        switch (position) {
            case 0:
                // "返回"
                actionView.setAction(new BackAction(), ActionView.ROTATE_CLOCKWISE);
                break;
            case 1:
                // "关闭"
                actionView.setAction(new CloseAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                break;
            case 2:
                // "菜单"
                actionView.setAction(new DrawerAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                break;
            case 3:
                // "+"
                actionView.setAction(new PlusAction(), ActionView.ROTATE_COUNTER_CLOCKWISE);
                break;
        }
    }

    private Point getLocationInView(View src, View target) {
        final int[] l0 = new int[2];
        src.getLocationOnScreen(l0);

        final int[] l1 = new int[2];
        target.getLocationOnScreen(l1);

        l1[0] = l1[0] - l0[0] + target.getWidth() / 2;
        l1[1] = l1[1] - l0[1] + target.getHeight() / 2;

        return new Point(l1[0], l1[1]);
    }

    private int getColor(View view) {
        return Color.parseColor((String) view.getTag());
    }

}







