package com.example.beautify_alert;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.beautify_alert.callbacks.BeautifyOnAlertClickListener;
import com.example.beautify_alert.controllers.BeautifyAlertManagerController;


public class BeautifyAlertDialog extends Dialog {

    private BeautifyAlertDialog(@NonNull Context context, Builder builder) {
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
        private final BeautifyAlertManagerController alertController;

        /**
         * Custom alert dialog
         */
        private final BeautifyAlertDialog beautifyAlertDialog;

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
            view = LayoutInflater.from(context).inflate(R.layout.beautify_alert_dialog, null);
            alertController = new BeautifyAlertManagerController(context, view);
            beautifyAlertDialog = new BeautifyAlertDialog(context, this);
        }

        /**
         * This method allow to set new header to the dialog
         *
         * @param message the new message to display as header
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setHeader(String message) {
            this.alertController.setHeader(message);
            return this;
        }

        /**
         * This method allow to set new content for a given event
         *
         * @param message the new message to display as content
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setMessageContent(String message) {
            alertController.setMessageContent(message);
            return this;
        }

        /**
         * This method allow to set new icons which will be displayed as popup context
         *
         * @param drawable a drawable resource
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setIcon(int drawable) {
            alertController.setIcon(drawable);
            return this;
        }

        /**
         * This method allows to set new icons which will be displayed as popup context
         * from a given url that will be downloaded and gets cropped as circle image
         *
         * @param url path to the given image
         * @return the Builder object to allow chaining of calls to set new builder
         */
        public Builder setIcon(String url) {
            alertController.setIcon(url);
            return this;
        }

        /**
         * Register to on click event on the confirm button
         *
         * @param beautifyOnAlertClickListener callback for activate user logic
         * @return this Builder object to allow for chaining of calls to set methods
         */
        public Builder setOnConfirmListener(BeautifyOnAlertClickListener beautifyOnAlertClickListener) {
            alertController.setOnConfirmClickListener(beautifyOnAlertClickListener, beautifyAlertDialog);
            return this;
        }

        /**
         * Register to click event on the cancel button
         *
         * @param onCancelListener callback for activate user logic
         * @return this Builder object to allow for chaining of calls to set methods
         */
        public Builder setOnCancelListener(BeautifyOnAlertClickListener onCancelListener) {
            alertController.setOnCancelClickListener(onCancelListener, beautifyAlertDialog);
            return this;
        }

        /**
         * This method changes the name of the left button based on a given string
         *
         * @param text to set new text on the left button
         */
        public Builder setLeftButtonText(String text) {
            this.alertController.setLeftButtonText(text);
            return this;
        }

        /**
         * This method changes the name of the right button based on a given string
         *
         * @param text to set new text on the left button
         */
        public Builder setRightButtonText(String text) {
            this.alertController.setRightButtonText(text);
            return this;
        }

        /**
         * This method gets animation type from AnimationFactory and inject the
         * relevant animation
         *
         * @param animationType set the relevant name of the animation
         */
        public Builder setImageAnimation(String animationType) {
            alertController.setAnimationType(animationType);
            return this;
        }

        /**
         * This method display the dialog
         */
        public void show() {
            beautifyAlertDialog.show();
        }

        /**
         * This method remove the dialog from the view
         */
        public void dismiss() {
            beautifyAlertDialog.dismiss();
        }

        /**
         * @return the correspond view which got build
         */
        public View getView() {
            return view;
        }
    }

}
