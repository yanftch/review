package com.yanftch.review.android.modules;

/**
 * User : yanftch
 * Date : 2019-11-08
 * Time : 16:49
 * Desc :
 */
public class StaticParentBean {

    public final static String name = "ab";

    private void reset() {
//        name = "a";
    }

    static class InncCl {
        protected int getIntDd() {
            return 1;
        }

    }
}
