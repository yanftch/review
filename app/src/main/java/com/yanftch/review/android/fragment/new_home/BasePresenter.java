package com.yanftch.review.android.fragment.new_home;


public interface BasePresenter<T> {

    // 开始加载，一般为初始化逻辑
    void start();

    T getView();

    void detachView();

}
