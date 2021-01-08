package com.yanftch.review.android.fragment.new_home;

import android.content.Context;

public interface BaseView<T> {

    // 注入presenter
    void setPresenter(T presenter);

    // 判断当前view是否存活，异步的时候一定要判断
    boolean isActive();

    Context getViewContext();
}
