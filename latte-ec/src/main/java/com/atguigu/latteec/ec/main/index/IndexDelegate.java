package com.atguigu.latteec.ec.main.index;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;

import com.atguigu.latte.delegates.bottom.BottomItemDelegate;
import com.atguigu.latteec.ec.R;

/**
 * Created by su on 2018/5/8.
 */
public class IndexDelegate extends BottomItemDelegate { //内容fragment


    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }
}