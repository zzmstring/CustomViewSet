package com.zzmstring.viewset.View.RefreshAndLoading.UltraPulltoRefresh;


import com.zzmstring.viewset.View.RefreshAndLoading.UltraPulltoRefresh.indicator.PtrIndicator;

/**
 *
 */
public interface PtrUIHandler {

    /**
     * When the content view has reached top and refresh has been completed, view will be reset.
     *
     * @param frame
     */
    public void onUIReset(PtrFrameLayout frame);

    /**
     * prepare for loading
     *
     * @param frame
     */
    public void onUIRefreshPrepare(PtrFrameLayout frame);

    /**
     * perform refreshing UI
     */
    public void onUIRefreshBegin(PtrFrameLayout frame);

    /**
     * perform UI after refresh
     */
    public void onUIRefreshComplete(PtrFrameLayout frame);

    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator);
}
