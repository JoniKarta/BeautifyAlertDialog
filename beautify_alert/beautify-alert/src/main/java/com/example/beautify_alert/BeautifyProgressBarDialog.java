package com.example.beautify_alert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.beautify_alert.callbacks.ProgressBarEventListener;
import com.example.beautify_alert.controllers.BeautifyProgressBarManagerController;

public class BeautifyProgressBarDialog extends Dialog {

    public BeautifyProgressBarDialog(@NonNull Context context, Builder builder) {
        super(context);
        setContentView(builder.getView());
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }


    public static class Builder {

        /**
         * The context which attached to the view.
         */
        private final Context context;

        /**
         * The Controller which manage the logic
         */
        private final BeautifyProgressBarManagerController progressBarController;

        /**
         * Custom complete dialog
         */
        private final BeautifyProgressBarDialog beautifyProgressBarDialog;

        /**
         * The View which will be inflated after building the builder
         */
        private final View view;

        /**
         * Creates a builder for the custom alert dialog with the context attached.
         *
         * @param context the context which the view will be inflated
         */
        public Builder(Context context) {
            this.context = context;
            view = LayoutInflater.from(context).inflate(R.layout.beautify_progress_bar_dialog, null);
            progressBarController = new BeautifyProgressBarManagerController(context, view);
            beautifyProgressBarDialog = new BeautifyProgressBarDialog(context, this);
        }

        /**
         * This method allow to set new header to the dialog
         *
         * @param message the new message to display as header
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setHeader(String message) {
            this.progressBarController.setHeader(message);
            return this;
        }

        /**
         * This method allow to set new content for a given event
         *
         * @param message the new message to display as content
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setMessageContent(String message) {
            progressBarController.setMessageContent(message);
            return this;
        }

        public Builder setBarBackgroundColor(String... hexValues){
            progressBarController.setBarBackgroundColor(hexValues);
            return this;
        }

        public Builder setOnClickListener(ProgressBarEventListener eventListener) {
            progressBarController.setOnClickListener(eventListener);
            return this;
        }

        /**
         * This method display the dialog
         */
        public void show() {
            beautifyProgressBarDialog.show();
        }

        /**
         * This method remove the dialog from the view
         */
        public void dismiss() {
            beautifyProgressBarDialog.dismiss();
        }

        /**
         * @return the correspond view which got build
         */
        public View getView() {
            return view;
        }
    }
}