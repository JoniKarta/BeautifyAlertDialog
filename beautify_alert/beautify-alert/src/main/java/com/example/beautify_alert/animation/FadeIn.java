package com.example.beautify_alert.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class FadeIn implements Animator {


    @Override
    public void animate(ImageView imageView) {
        imageView.animate()
                .alpha(0)
                .setInterpolator(new DecelerateInterpolator())
                .withEndAction(() -> imageView.animate()
                        .alpha(1)
                        .setDuration(600)
                        .setInterpolator(new AccelerateInterpolator())
                        .start())
                .start();
    }


}
