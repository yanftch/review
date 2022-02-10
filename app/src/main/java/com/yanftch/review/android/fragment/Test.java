//package com.yanftch.review.android.fragment;
//
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.fragment.app.Fragment;
//
//import org.jetbrains.annotations.Nullable;
//
//import java.util.HashMap;
//
//import kotlin.Metadata;
//import kotlin.jvm.internal.DefaultConstructorMarker;
//
//public class Test {
//    package com.yanftch.review.android.fragment;
//
//import android.os.Bundle;
//import android.view.View;
//import androidx.fragment.app.Fragment;
//import java.util.HashMap;
//import kotlin.Metadata;
//import kotlin.jvm.internal.DefaultConstructorMarker;
//import org.jetbrains.annotations.Nullable;
//
//    @Metadata(
//            mv = {1, 1, 18},
//            bv = {1, 0, 3},
//            k = 1,
//            d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0010"},
//            d2 = {"Lcom/yanftch/review/android/fragment/TestFragment;", "Landroidx/fragment/app/Fragment;", "arg1", "", "arg2", "(Ljava/lang/String;Ljava/lang/String;)V", "getArg1", "()Ljava/lang/String;", "setArg1", "(Ljava/lang/String;)V", "getArg2", "setArg2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "review.app"}
//    )
//    public final class TestFragment extends Fragment {
//        @Nullable
//        private String arg1;
//        @Nullable
//        private String arg2;
//        private HashMap _$_findViewCache;
//
//        public void onCreate(@Nullable Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//        }
//
//        @Nullable
//        public final String getArg1() {
//            return this.arg1;
//        }
//
//        public final void setArg1(@Nullable String var1) {
//            this.arg1 = var1;
//        }
//
//        @Nullable
//        public final String getArg2() {
//            return this.arg2;
//        }
//
//        public final void setArg2(@Nullable String var1) {
//            this.arg2 = var1;
//        }
//
//        public TestFragment(@Nullable String arg1, @Nullable String arg2) {
//            this.arg1 = arg1;
//            this.arg2 = arg2;
//        }
//
//        public TestFragment() {
//            this((String)null, (String)null, 3, (DefaultConstructorMarker)null);
//        }
//
//        public View _$_findCachedViewById(int var1) {
//            if (this._$_findViewCache == null) {
//                this._$_findViewCache = new HashMap();
//            }
//
//            View var2 = (View)this._$_findViewCache.get(var1);
//            if (var2 == null) {
//                View var10000 = this.getView();
//                if (var10000 == null) {
//                    return null;
//                }
//
//                var2 = var10000.findViewById(var1);
//                this._$_findViewCache.put(var1, var2);
//            }
//
//            return var2;
//        }
//
//        public void _$_clearFindViewByIdCache() {
//            if (this._$_findViewCache != null) {
//                this._$_findViewCache.clear();
//            }
//
//        }
//
//        // $FF: synthetic method
//        public void onDestroyView() {
//            super.onDestroyView();
//            this._$_clearFindViewByIdCache();
//        }
//    }
//
//}
