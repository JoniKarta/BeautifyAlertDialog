package com.example.beautify_alert.animation;

import android.widget.ImageView;

public class FlipFlop implements IAnimation{

    @Override
    public void animate(ImageView imageView) {

        imageView.animate()
                .setDuration(1000)
                .alpha(.5f)
                .scaleXBy(.5f)
                .scaleYBy(.5f)
                .rotationYBy(360f)
                .translationYBy(200f)
                .withEndAction(()->
                        imageView.animate()
                        .setDuration(1000)
                        .alpha(1f)
                        .scaleXBy(-.5f)
                        .scaleYBy(-.5f)
                        .rotationXBy(360f)
                        .translationYBy(-200f)).start();

    }
}
