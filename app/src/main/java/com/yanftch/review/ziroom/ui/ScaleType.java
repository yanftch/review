package com.yanftch.review.ziroom.ui;

import com.facebook.drawee.drawable.ScalingUtils;

public interface ScaleType extends ScalingUtils.ScaleType
{
    /**
     * Scales width and height independently, so that the child matches the parent exactly. This may
     * change the aspect ratio of the child.
     */
    public static int FIT_XY = 0;

    /**
     * Scales the child so that it fits entirely inside the parent. At least one dimension (width or
     * height) will fit exactly. Aspect ratio is preserved. Child is aligned to the top-left corner
     * of the parent.
     */
    public static int FIT_START = 1;

    /**
     * Scales the child so that it fits entirely inside the parent. At least one dimension (width or
     * height) will fit exactly. Aspect ratio is preserved. Child is centered within the parent's
     * bounds.
     */
    public static int FIT_CENTER = 2;

    /**
     * Scales the child so that it fits entirely inside the parent. At least one dimension (width or
     * height) will fit exactly. Aspect ratio is preserved. Child is aligned to the bottom-right
     * corner of the parent.
     */
    public static int FIT_END = 3;

    /** Performs no scaling. Child is centered within parent's bounds. */
    public static int CENTER = 4;

    /**
     * Scales the child so that it fits entirely inside the parent. Unlike FIT_CENTER, if the child
     * is smaller, no up-scaling will be performed. Aspect ratio is preserved. Child is centered
     * within parent's bounds.
     */
    public static int CENTER_INSIDE = 5;

    /**
     * Scales the child so that both dimensions will be greater than or equal to the corresponding
     * dimension of the parent. At least one dimension (width or height) will fit exactly. Child is
     * centered within parent's bounds.
     */
    public static int CENTER_CROP = 6;

    /**
     * Scales the child so that both dimensions will be greater than or equal to the corresponding
     * dimension of the parent. At least one dimension (width or height) will fit exactly. The
     * child's focus point will be centered within the parent's bounds as much as possible without
     * leaving empty space. It is guaranteed that the focus point will be visible and centered as
     * much as possible. If the focus point is set to (0.5f, 0.5f), result will be equivalent to
     * CENTER_CROP.
     */
    public static int FOCUS_CROP = 7;

    /**
     * Scales the child so that it fits entirely inside the parent. At least one dimension (width or
     * height) will fit exactly. Aspect ratio is preserved. Child is aligned to the bottom-left
     * corner of the parent.
     */
    public static int FIT_BOTTOM_START = 8;
}
