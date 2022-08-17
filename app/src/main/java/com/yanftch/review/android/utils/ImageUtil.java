//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.yanftch.review.android.utils;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.yanftch.review.ziroom.ui.ImageInfo;

import org.jetbrains.annotations.Nullable;

import java.io.File;

public class ImageUtil {
    private static final String TAG = "debug_PImageUtil";
    public ImageUtil() {
    }

    public static AbstractDraweeController frescoController(String url) {
        return frescoController((String)url, (ControllerListener)null, (Postprocessor)null);
    }

    public static AbstractDraweeController frescoController(String url, ControllerListener listener) {
        return frescoController((String)url, listener, (Postprocessor)null);
    }

    public static AbstractDraweeController frescoController(String url, Postprocessor postprocessor) {
        return frescoController((String)url, (ControllerListener)null, postprocessor);
    }

    public static AbstractDraweeController frescoResizeController(String url, int width, int height) {
        return frescoResizeController((String)url, (Postprocessor)null, (ControllerListener)null, width, height);
    }

    public static AbstractDraweeController frescoResizeController(String url, ControllerListener listener, int width, int height) {
        return frescoResizeController((String)url, (Postprocessor)null, listener, width, height);
    }

    public static AbstractDraweeController frescoResizeController(String url, Postprocessor postprocessor, int width, int height) {
        return frescoResizeController((String)url, postprocessor, (ControllerListener)null, width, height);
    }

    public static AbstractDraweeController frescoResizeController(String url, Postprocessor postprocessor, ControllerListener listener, int width, int height) {
        ImageRequest request;
        if (width > 0 && height > 0) {
            request = generateImageRequest(url, postprocessor).setResizeOptions(new ResizeOptions(width, height)).build();
        } else {
            request = generateImageRequest(url, postprocessor).build();
        }

        AbstractDraweeController controller = generateController(listener, request);
        controller.addControllerListener(new ControllerListener<com.facebook.imagepipeline.image.ImageInfo>() {
            @Override
            public void onSubmit(String id, Object callerContext) {
                Log.e(TAG, "onSubmit: ");
            }

            @Override
            public void onFinalImageSet(String id, @Nullable com.facebook.imagepipeline.image.ImageInfo imageInfo, @Nullable Animatable animatable) {
                Log.e(TAG, "onFinalImageSet: 底层。。。w  " + imageInfo.getWidth() + ", h = "+ imageInfo.getHeight());
            }

            @Override
            public void onIntermediateImageSet(String id, @Nullable com.facebook.imagepipeline.image.ImageInfo imageInfo) {
                Log.e(TAG, "onIntermediateImageSet: 底层");
            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {
                Log.e(TAG, "onIntermediateImageFailed: ");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                Log.e(TAG, "onFailure: ");
            }

            @Override
            public void onRelease(String id) {
                Log.e(TAG, "onRelease: ");
            }
        });
        return controller;
    }

    public static AbstractDraweeController frescoController(String url, ControllerListener listener, Postprocessor postprocessor) {
        ImageRequest request = generateImageRequest(url, postprocessor).build();
        AbstractDraweeController controller = generateController(listener, request);
        return controller;
    }

    public static AbstractDraweeController generateController(ControllerListener listener, ImageRequest request) {
        AbstractDraweeController controller;
        Log.e(TAG, "generateController: listener = " + listener);
        if (listener != null) {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setControllerListener(listener)).setAutoPlayAnimations(true)).build();
        } else {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setAutoPlayAnimations(true)).build();
        }

        return controller;
    }

    public static ImageRequestBuilder generateImageRequest(String url, Postprocessor postprocessor) {
        ImageRequestBuilder requestBuilder;
        if (postprocessor != null) {
            requestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(TextUtils.isEmpty(url) ? "" : url)).setProgressiveRenderingEnabled(true).setPostprocessor(postprocessor).setAutoRotateEnabled(true);
        } else {
            requestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(TextUtils.isEmpty(url) ? "" : url)).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true);
        }

        return requestBuilder;
    }

    public static void frescoHierarchyController(SimpleDraweeView mSimpleDraweeView, int defaultDrawable) {
        frescoHierarchyController(mSimpleDraweeView, ScaleType.FIT_XY, defaultDrawable);
    }

    public static void frescoHierarchyController(SimpleDraweeView mSimpleDraweeView, ScaleType type, int defaultDrawable) {
        ((GenericDraweeHierarchy)mSimpleDraweeView.getHierarchy()).setActualImageScaleType(type);
        ((GenericDraweeHierarchy)mSimpleDraweeView.getHierarchy()).setPlaceholderImage(defaultDrawable, type);
        ((GenericDraweeHierarchy)mSimpleDraweeView.getHierarchy()).setFailureImage(defaultDrawable, type);
    }

    public static AbstractDraweeController frescoFromResourceController(int resourceId) {
        return frescoFromResourceController(resourceId, (ControllerListener)null);
    }

    public static AbstractDraweeController frescoFromResourceController(int resourceId, ControllerListener listener) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(resourceId).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true).build();
        AbstractDraweeController controller;
        if (listener != null) {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setControllerListener(listener)).setAutoPlayAnimations(true)).build();
        } else {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setAutoPlayAnimations(true)).build();
        }

        return controller;
    }

    public static AbstractDraweeController frescoFromFileController(File file) {
        return frescoFromFileController(file, (ControllerListener)null);
    }

    public static AbstractDraweeController frescoFromFileController(File file, ControllerListener listener) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.fromFile(file)).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true).build();
        AbstractDraweeController controller;
        if (listener != null) {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setImageRequest(request)).setControllerListener(listener)).build();
        } else {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setImageRequest(request)).build();
        }

        return controller;
    }

    public static void loadHolderImage(SimpleDraweeView img, String url) {
        loadHolderImage(img, url, (ControllerListener)null, (Postprocessor)null);
    }

    public static void loadHolderImage(SimpleDraweeView img, String url, Postprocessor postprocessor) {
        loadHolderImage(img, url, (ControllerListener)null, postprocessor);
    }

    public static void loadHolderImage(SimpleDraweeView img, String url, ControllerListener controllerListener) {
        loadHolderImage(img, url, controllerListener, (Postprocessor)null);
    }

    public static void loadHolderImage(SimpleDraweeView img, String url, ControllerListener controllerListener, Postprocessor postprocessor) {
        if (img != null) {
            img.setController(frescoControllerBuilder(url, controllerListener, postprocessor).setOldController(img.getController()).build());
        }

    }

    public static void loadHolderImageResize(SimpleDraweeView img, String url, int width, int height) {
        if (img != null) {
            img.setController(frescoResizeControllerBuilder(url, width, height).setOldController(img.getController()).build());
        }

    }

    private static AbstractDraweeControllerBuilder frescoResizeControllerBuilder(String url, int width, int height) {
        return frescoResizeControllerBuilder(url, (Postprocessor)null, (ControllerListener)null, width, height);
    }

    private static AbstractDraweeControllerBuilder frescoResizeControllerBuilder(String url, Postprocessor postprocessor, ControllerListener listener, int width, int height) {
        ImageRequest request;
        if (width > 0 && height > 0) {
            request = generateImageRequest(url, postprocessor).setResizeOptions(new ResizeOptions(width, height)).build();
        } else {
            request = generateImageRequest(url, postprocessor).build();
        }

        AbstractDraweeControllerBuilder controller = generateControllerBuilder(listener, request);
        return controller;
    }

    private static AbstractDraweeControllerBuilder frescoControllerBuilder(String url, ControllerListener listener, Postprocessor postprocessor) {
        ImageRequest request = generateImageRequest(url, postprocessor).build();
        AbstractDraweeControllerBuilder controller = generateControllerBuilder(listener, request);
        return controller;
    }

    private static AbstractDraweeControllerBuilder generateControllerBuilder(ControllerListener listener, ImageRequest request) {
        AbstractDraweeControllerBuilder controller;
        if (listener != null) {
            controller = ((PipelineDraweeControllerBuilder)((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setControllerListener(listener)).setAutoPlayAnimations(true);
        } else {
            controller = ((PipelineDraweeControllerBuilder)Fresco.newDraweeControllerBuilder().setImageRequest(request)).setAutoPlayAnimations(true);
        }

        return controller;
    }

    public static AbstractDraweeController frescoController(Uri uri) {
        return frescoController((Uri)uri, (ControllerListener)null, (Postprocessor)null);
    }

    public static AbstractDraweeController frescoController(Uri uri, ControllerListener listener) {
        return frescoController((Uri)uri, listener, (Postprocessor)null);
    }

    public static AbstractDraweeController frescoController(Uri uri, Postprocessor postprocessor) {
        return frescoController((Uri)uri, (ControllerListener)null, postprocessor);
    }

    public static AbstractDraweeController frescoResizeController(Uri uri, int width, int height) {
        return frescoResizeController((Uri)uri, (Postprocessor)null, (ControllerListener)null, width, height);
    }

    public static AbstractDraweeController frescoResizeController(Uri uri, ControllerListener listener, int width, int height) {
        return frescoResizeController((Uri)uri, (Postprocessor)null, listener, width, height);
    }

    public static AbstractDraweeController frescoResizeController(Uri uri, Postprocessor postprocessor, int width, int height) {
        return frescoResizeController((Uri)uri, postprocessor, (ControllerListener)null, width, height);
    }

    public static AbstractDraweeController frescoResizeController(Uri uri, Postprocessor postprocessor, ControllerListener listener, int width, int height) {
        ImageRequest request;
        if (width > 0 && height > 0) {
            request = generateImageRequest(uri, postprocessor).setResizeOptions(new ResizeOptions(width, height)).build();
        } else {
            request = generateImageRequest(uri, postprocessor).build();
        }

        AbstractDraweeController controller = generateController(listener, request);
        return controller;
    }

    public static AbstractDraweeController frescoController(Uri uri, ControllerListener listener, Postprocessor postprocessor) {
        ImageRequest request = generateImageRequest(uri, postprocessor).build();
        AbstractDraweeController controller = generateController(listener, request);
        return controller;
    }

    public static ImageRequestBuilder generateImageRequest(Uri uri, Postprocessor postprocessor) {
        ImageRequestBuilder requestBuilder;
        if (postprocessor != null) {
            requestBuilder = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).setPostprocessor(postprocessor).setAutoRotateEnabled(true);
        } else {
            requestBuilder = ImageRequestBuilder.newBuilderWithSource(uri).setProgressiveRenderingEnabled(true).setAutoRotateEnabled(true);
        }

        return requestBuilder;
    }
}
