package com.example.beautify_alert.controllers;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.beautify_alert.callbacks.ProgressBarEventListener;
import com.example.beautify_alert.R;
import com.example.beautify_alert.animation.Animator;
import com.example.beautify_alert.animation.AnimatorFactory;
import com.example.beautify_alert.exceptions.IllegalNameException;

import java.util.Arrays;

public class BeautifyProgressBarManagerController {
    private final View view;

    private final Context context;

    private Button loadingButton;

    private ProgressBar progressBar;

    private TextView headerNameEditText;

    private TextView messageContentEditText;


    public BeautifyProgressBarManagerController(Context context, View view) {
        this.context = context;
        this.view = view;
        setupView();
    }

    private void setupView(){
            loadingButton = view.findViewById(R.id.beautify_progress_bar_dialog_button);
            progressBar = view.findViewById(R.id.beautify_progress_bar_dialog_progress_bar);
            headerNameEditText = view.findViewById(R.id.beautify_progress_bar_dialog_header_name);
            messageContentEditText = view.findViewById(R.id.beautify_alert_dialog_message);
    }
    /**
     * This method handle the logic of the header name
     *
     * @param headerName set new name to the header
     */
    public void setHeader(String headerName) {
        if (headerName == null || headerName.equals(""))
            throw new IllegalNameException("Button name cannot be empty or null");
        else
            headerNameEditText.setText(headerName);
    }

    /**
     * This method changes the name of the content of the message
     * based on a given string
     *
     * @param messageContent set new content
     */
    public void setMessageContent(String messageContent) {
        if (messageContent == null || messageContent.equals(""))
            throw new IllegalNameException("Message cannot be empty or null");
        else
            messageContentEditText.setText(messageContent);
    }


    public void setBarColor(String hexColor) {
        // TODO check hex color logic

    }

    public void setOnClickListener(ProgressBarEventListener eventListener) {
        if(eventListener != null){
            loadingButton.setOnClickListener(v -> eventListener.onCancel());
        }
    }

    public void setBarBackgroundColor(String[] hexValues) {
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {0xFF616261,0xFF131313});
        gd.setCornerRadius(0f);

//        Rect bounds = progressBar.getProgressDrawable().getBounds();
//        progressBar.setProgressDrawable(gd);
//        progressBar.getProgressDrawable().setBounds(bounds);
//        progressBar.getIndeterminateDrawable()
//                .setColorFilter(ContextCompat.getColor(this, R.color.colorPrimary), PorterDuff.Mode.SRC_IN );
        //progressBar.setBackground(gd);


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            progressBar.getIndeterminateDrawable().setColorFilter(0xFFFF0000, android.graphics.PorterDuff.Mode.MULTIPLY);
//            pr.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
//        } else {
//            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
//        }
  //      progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context,gd),android.graphics.PorterDuff.Mode.MULTIPLY);
//
//        Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
//        progressDrawable.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
//        progressBar.setProgressDrawable(progressDrawable);
//      //  progressBar.setProgressDrawable(gd);
    }
//    public static void setColorFilter(@NonNull Drawable drawable, @ColorInt int color) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            drawable.setColorFilter(new BlendModeColorFilter(color, BlendMode.SRC_ATOP));
//        } else {
//            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
//        }
//    }
}
