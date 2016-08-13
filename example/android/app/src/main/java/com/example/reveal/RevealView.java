package com.example.reveal;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

import com.facebook.react.views.view.ReactViewGroup;


/**
 * Created by gaguirre on 8/10/16.
 */
public class RevealView extends ReactViewGroup {
    private Integer centerX = 0;
    private Integer centerY = 0;
    private Float startRadius = 0f;
    private Float endRadius = 0f;
    private Integer duration = 800;

    public RevealView(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void reveal() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            this.setVisibility(View.VISIBLE);
            return;
        }

        Animator animation = ViewAnimationUtils
                .createCircularReveal(this, centerX, centerY, startRadius, endRadius);
        animation.setDuration(duration);
        this.setVisibility(View.VISIBLE);
        animation.start();
    }

    public void setCenterX(Integer centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(Integer centerY) {
        this.centerY = centerY;
    }

    public void setStartRadius(Float startRadius) {
        this.startRadius = startRadius;
    }

    public void setEndRadius(Float endRadius) {
        this.endRadius = endRadius;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setVisible(Boolean visible) {
        if (visible) {
            reveal();
        } else {
            setVisibility(View.INVISIBLE);
        }
    }
}
