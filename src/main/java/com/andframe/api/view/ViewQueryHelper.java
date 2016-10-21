package com.andframe.api.view;

import android.view.View;

/**
 * ViewQuery 继承帮助类 接口
 * Created by SCWANG on 2016/9/8.
 */
public interface ViewQueryHelper {

    /**
     * 开始 ViewQuery 查询
     * @param id 控件Id
     */
    ViewQuery $(int id, int... ids);
    /**
     * 开始 ViewQuery 查询
     * @param views 可选的多个 View
     */
    ViewQuery $(View... views);
}