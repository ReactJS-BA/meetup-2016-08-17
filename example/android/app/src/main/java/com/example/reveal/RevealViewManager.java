package com.example.reveal;

import android.support.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by gaguirre on 8/10/16.
 */
public class RevealViewManager extends ViewGroupManager<RevealView> {
    public static final String REACT_CLASS = "RNRevealView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected RevealView createViewInstance(ThemedReactContext reactContext) {
        return new RevealView(reactContext);
    }

    @ReactProp(name = "visible")
    public void setVisible(RevealView view, @Nullable Boolean visible) {
        view.setVisible(visible);
    }

    @ReactProp(name = "centerX", defaultInt = 0)
    public void setCenterX(RevealView view, @Nullable Integer centerX) {
        view.setCenterX(centerX);
    }

    @ReactProp(name = "centerY", defaultInt = 0)
    public void setCenterY(RevealView view, @Nullable Integer centerY) {
        view.setCenterY(centerY);
    }

    @ReactProp(name = "startRadius", defaultFloat = 0f)
    public void setStartRadius(RevealView view, @Nullable float startRadius) {
        view.setStartRadius(startRadius);
    }

    @ReactProp(name = "endRadius", defaultFloat = 1500f)
     public void setEndRadius(RevealView view, @Nullable float endRadius) {
        view.setEndRadius(endRadius);
    }

    @ReactProp(name = "duration", defaultInt = 800)
    public void setDuration(RevealView view, @Nullable Integer duration) {
        view.setDuration(duration);
    }
}
