package com.jack.androidmaterialdesign.ui;


import android.content.Context;
import android.content.Intent;

import com.jack.androidmaterialdesign.ui.acandroidui.AndroidUiActivity;
import com.jack.androidmaterialdesign.ui.acmaterialdrawer.MaterialDrawerActivity;

public class UIManager {


    public static void mainToAndroidUi(Context context) {
        context.startActivity(new Intent(context, AndroidUiActivity.class));
    }

    public static void mainToMaterialDrawer(Context context) {
        context.startActivity(new Intent(context, MaterialDrawerActivity.class));
    }

}
