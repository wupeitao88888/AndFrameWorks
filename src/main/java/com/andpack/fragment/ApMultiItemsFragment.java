package com.andpack.fragment;

import android.content.Context;

import com.andframe.api.multistatus.RefreshLayouter;
import com.andframe.feature.AfBundle;
import com.andframe.feature.AfView;
import com.andframe.fragment.AfMultiItemsFragment;
import com.andpack.api.ApPager;
import com.andpack.impl.ApListHelper;

/**
 *
 * Created by SCWANG on 2016/9/7.
 */
public abstract class ApMultiItemsFragment<T> extends AfMultiItemsFragment<T> implements ApPager {

    protected ApListHelper mApHelper = new ApListHelper(this);

    @Override
    protected void onCreate(AfBundle bundle, AfView view) throws Exception {
        mApHelper.onCreate();
        super.onCreate(bundle, view);
    }

    @Override
    public void onViewCreated() throws Exception {
        mApHelper.onViewCreated(null);
        super.onViewCreated();
    }

    @Override
    public RefreshLayouter createRefreshLayouter(Context context) {
        RefreshLayouter layouter = mApHelper.createRefreshLayouter(context);
        if (layouter != null) {
            return layouter;
        }
        return super.createRefreshLayouter(context);
    }

}
