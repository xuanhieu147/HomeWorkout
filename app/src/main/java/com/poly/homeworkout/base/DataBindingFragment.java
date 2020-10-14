package com.poly.homeworkout.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;

import com.poly.homeworkout.constants.Constants;
import com.poly.homeworkout.utils.ViewAnimationUtils;

public abstract class DataBindingFragment <B extends ViewDataBinding, V extends AndroidViewModel>
        extends Fragment implements Constants {
    public B mBinding;

    protected V mViewModel;

    protected abstract int getContentViewLayoutId();

    protected Context context() {
        return getContext();
    }

    protected abstract void initListeners();

    protected abstract void initData();

    protected abstract void loadData();

    protected abstract void subscribeToViewModel();
    protected BroadcastReceiver mNetworkReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            onConnectionChanged(NetworkUtils.isConnectingToInternet(context));
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateFragment();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context().registerReceiver(mNetworkReceiver, filter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getContentViewLayoutId(), container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListeners();
        initData();
        subscribeToViewModel();
    }
    @Override
    public void onDestroy() {
        if (mNetworkReceiver != null) {
            context().unregisterReceiver(mNetworkReceiver);
        }
        super.onDestroy();
    }

    public void onCreateFragment() {

    }
    public void startActivity(Intent intent, int animationType) {
        super.startActivity(intent);
        ViewAnimationUtils.animationStartActivity(getActivity(), animationType);
    }
    public void startActivity(Intent intent) {
        startActivity(intent, Constants.AnimationType.RIGHT_TO_LEFT);
    }
}
