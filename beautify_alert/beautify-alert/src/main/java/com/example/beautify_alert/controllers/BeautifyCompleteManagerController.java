package com.example.beautify_alert.controllers;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.beautify_alert.BeautifyCompleteDialog;
import com.example.beautify_alert.callbacks.BeautifyOnSuccessClickListener;
import com.example.beautify_alert.R;
import com.example.beautify_alert.animation.Animator;
import com.example.beautify_alert.animation.AnimatorFactory;
import com.example.beautify_alert.exceptions.IllegalNameException;

public class BeautifyCompleteManagerController {
    private final View view;

    private final Context context;

    private Button successButton;

    private ImageView iconImage;

    private TextView headerNameEditText;

    private TextView messageContentEditText;


    public BeautifyCompleteManagerController(Context context, View view) {
        this.context = context;
        this.view = view;
        setupView();
    }

    /**
     * This method setup all the views in the popup
     */
    private void setupView() {
        iconImage = view.findViewById(R.id.beautify_complete_dialog_icon);
        headerNameEditText = view.findViewById(R.id.beautify_complete_dialog_header_name);
        messageContentEditText = view.findViewById(R.id.beautify_complete_dialog_message);
        successButton = view.findViewById(R.id.beautify_complete_dialog_button);
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

    /**
     * This method gets drawable and uses Glide library to fetch
     * the from specified url the image and insert it into the image holder
     *
     * @param drawable drawable resource
     */
    public void setIcon(int drawable) {
        Glide.with(view).load(drawable).circleCrop().into(iconImage);
    }

    /**
     * This method gets url and uses glide library to fetch
     * the image from specified url and then the image inserted into the image holder
     *
     * @param url path to the given image
     */
    public void setIcon(String url) {
        Glide.with(view).load(url).circleCrop().into(iconImage);
    }


    /**
     * This method let the user to register to a new click event on the left button
     * and fires when the user press the button
     *
     * @param beautifyOnSuccessClickListener listener to on click event
     */
    public void setOnSuccessClickListener(BeautifyOnSuccessClickListener beautifyOnSuccessClickListener) {
        if (beautifyOnSuccessClickListener != null)
            this.successButton.setOnClickListener(v -> beautifyOnSuccessClickListener.onSuccess(new BeautifyCompleteDialog.Builder(context)));
    }


    /**
     * This method changes the name of the button based on a given string
     *
     * @param text set new name to the button
     */
    public void setSuccessButtonText(String text) {
        if (text == null || text.equals(""))
            throw new IllegalNameException("Right button cannot be empty or null");
        else
            this.successButton.setText(text);
    }

    /**
     * This method gets animation type and use factory design pattern
     * To find the specified implementation
     *
     * @param animatorType set the relevant name of the animation
     */
    public void setAnimationType(String animatorType) {
        Animator animator = AnimatorFactory.activate(animatorType);
        if (animator != null)
            animator.animate(iconImage);
    }

}

