package com.yanftch.review.android.pages.tablayout_viewpager_fragment;

import androidx.fragment.app.Fragment;

public class AbsFragment extends Fragment {


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
//        onVisibilityChangedToUser(getUserVisibleHint());
//		if(umengClock){
//			umengStartTime = System.currentTimeMillis();
//		}

//		try {
//			BiData.onPageEvent(getClass().getName(),getBiDataQuery(),getBiDataCityCode());
//		} catch (Exception e) {
//
//		}
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        onVisibilityChangedToUser(getUserVisibleHint());
    }

    public void onVisibilityChangedToUser(boolean isVisibleToUser) {
//        if (isVisibleToUser) {
//			try {
//				StatUtil.onAccessEvent(getStatAccessPageName(), getStatBusiStr());
//			}catch (Exception e){
//
//			}
//		}
    }

}
