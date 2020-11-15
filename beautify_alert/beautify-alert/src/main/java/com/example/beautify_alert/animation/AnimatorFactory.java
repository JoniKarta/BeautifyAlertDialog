package com.example.beautify_alert.animation;

public final class AnimatorFactory {

   private Animator animator;

   public static Animator activate(String animation){

       if(animation.equals(Animator.FADE_IN)){
           return new FadeIn();
       }else if(animation.equals(Animator.ROTATE)){
           return new Rotate();
       }
       return null;
   }

}
