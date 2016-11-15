package com.andframe.impl.multistatus;

import android.view.View;

import com.andframe.adapter.listitem.AfListItem;
import com.andframe.api.multistatus.MoreFooter;
import com.andframe.api.multistatus.OnMoreListener;
import com.andframe.listener.SafeOnClickListener;


/**
 * 默认更多加载
 * Created by SCWANG on 2016/10/21.
 */

public abstract class BaseMoreFooter extends AfListItem<Object> implements MoreFooter {

    protected OnMoreListener listener;
    protected boolean mAllLoadFinish = true;
    protected boolean mIsLoading = false;

    @SuppressWarnings("unused")
    public BaseMoreFooter() {
    }

    public BaseMoreFooter(int layoutId) {
        super(layoutId);
    }

    @Override
    public void setOnMoreListener(OnMoreListener listener) {
        this.listener = listener;
    }

    @Override
    public void finishLoadMore() {
        onUpdateStatus(mIsLoading = false, mAllLoadFinish);
    }

    @Override
    public void setAllLoadFinish(boolean finish) {
        onUpdateStatus(mIsLoading = false, mAllLoadFinish = finish);
    }

    protected void setLoading() {
        onUpdateStatus(mIsLoading = true, mAllLoadFinish = false);
    }

    @Override
    protected void onViewCreated(View view) {
        super.onViewCreated(view);
//        finishLoadMore();
        view.setOnClickListener(new SafeOnClickListener(v -> {
            if (!mAllLoadFinish && listener != null && listener.onMore()) {
                setLoading();
            }
        }));
    }

    //<editor-fold desc="终止接口">
    @Override
    public final void onUpdateStatus(View view, int index) {
        onUpdateStatus(mIsLoading, mAllLoadFinish);
    }

    @Override
    public final void onBinding(Object model, int index) {

    }

    @Override
    public final void onBinding(View view, Object model, int index) {
        super.onBinding(view, model, index);
    }
    //</editor-fold>

    /**
     * 更新控件状态
     * @param isLoading     是否正在加载
     * @param allLoadFinish 是否所有数据都加载完
     */
    protected abstract void onUpdateStatus(boolean isLoading, boolean allLoadFinish);


}