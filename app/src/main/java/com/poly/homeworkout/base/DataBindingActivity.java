package com.poly.homeworkout.base;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.poly.homeworkout.constants.Constants;
import com.poly.homeworkout.utils.ViewAnimationUtils;

public abstract class DataBindingActivity <B extends ViewDataBinding, V extends AndroidViewModel>
        extends AppCompatActivity implements Constants {
    protected B mBinding;

    protected V mViewModel;

    protected abstract int getContentViewLayoutId();

    protected Context context() {
        return this;
    }

    protected abstract void initListeners();

    protected abstract void initData();

    protected abstract void subscribeToViewModel();

    protected ProgressDialog mProgressDialog;

    protected boolean mIsResume;
    protected BroadcastReceiver mNetworkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            onConnectionChanged(NetworkUtils.isConnectingToInternet(context));
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getContentViewLayoutId());
        initListeners();
        initData();
        subscribeToViewModel();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context().registerReceiver(mNetworkReceiver, filter);
    }

    protected void setupToolbar(Toolbar toolbar, int navigationIcon) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar.setNavigationIcon(navigationIcon);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public void startActivity(Intent intent, int animationType) {
        super.startActivity(intent);
        ViewAnimationUtils.animationStartActivity(this, animationType);
    }
    public void startActivity(Intent intent) {
        startActivity(intent, Constants.AnimationType.RIGHT_TO_LEFT);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode, AnimationType.RIGHT_TO_LEFT);
    }

    public void startActivityForResult(Intent intent, int requestCode, int animationType) {
        super.startActivityForResult(intent, requestCode);
        ViewAnimationUtils.animationStartActivity(this, animationType);
    }

    @Override
    public void finish() {
        super.finish();
        ViewAnimationUtils.animationLeftToRight(this);
    }
}
