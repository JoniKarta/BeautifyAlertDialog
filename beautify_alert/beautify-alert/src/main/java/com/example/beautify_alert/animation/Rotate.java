package com.example.beautify_alert.animation;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Rotate implements IAnimation {

    @Override
    public void animate(ImageView imageView) {
        RotateAnimation rotate = new RotateAnimation(0,
                360,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate.setDuration(1000);
        imageView.startAnimation(rotate);
    }
}
