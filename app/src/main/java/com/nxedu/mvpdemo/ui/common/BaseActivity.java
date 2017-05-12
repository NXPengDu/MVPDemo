package com.nxedu.mvpdemo.ui.common;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

public class BaseActivity extends AppCompatActivity {

    protected CircleProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setProgressBar(CircleProgressBar progressBar) {
        mProgressBar = progressBar;
    }

    public void showLoading() {
        if (mProgressBar == null) {
            throw new RuntimeException("you need invoke setProgressBar first");
        }
        if (isKeyboardShown(getWindow().getDecorView())) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
        mProgressBar.setVisibility(View.VISIBLE);
        setActivityBackground(0.5f);
    }

    public void closeLoading() {
        if (mProgressBar == null) {
            throw new RuntimeException("you need invoke setProgressBar first");
        }
        mProgressBar.setVisibility(View.INVISIBLE);
        setActivityBackground(1.0f);
        mProgressBar.setVisibility(View.GONE);
    }

    public void setActivityBackground(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    public boolean isKeyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }
}
