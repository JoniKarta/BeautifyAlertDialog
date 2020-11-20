package com.example.beautify_alert.animation;

public final class AnimatorFactory {

   public static IAnimation activate(String animation){

       switch (animation) {
           case Animator.FADE_IN:
               return new FadeIn();
           case Animator.ROTATE:
               return new Rotate();
           case Animator.FLIP_FLOP:
               return new FlipFlop();
       }
       return null;
   }

}
