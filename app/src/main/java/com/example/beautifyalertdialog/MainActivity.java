package com.example.beautifyalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.beautify_alert.BeautifyAlertDialog;
import com.example.beautify_alert.BeautifyCompleteDialog;
import com.example.beautify_alert.BeautifyProgressBarDialog;
import com.example.beautify_alert.animation.Animator;
import com.example.beautify_alert.callbacks.ProgressBarEventListener;

public class MainActivity extends AppCompatActivity {
    private Button alertDialogButton;
    private Button successDialogButton;
    private Button customDialogButton;
    private Button progressBarDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();

        // Alert Dialog
        alertDialogButton.setOnClickListener(v -> new BeautifyAlertDialog
                .Builder(this)
                .setHeader("Are you root?")
                .setMessageContent("This action required root privileged are you sure you want to proceed")
                .setLeftButtonText("Yes")
                .setRightButtonText("No")
                .setImageAnimation(Animator.FLIP_FLOP)
                .setIcon("https://cdn.pixabay.com/photo/2014/10/26/14/36/light-bulb-503881_960_720.jpg")
                .setOnConfirmListener(BeautifyCompleteDialog.Builder::dismiss)
                .setOnCancelListener(BeautifyCompleteDialog.Builder::dismiss)
                .show());


        // Success Dialog
        successDialogButton.setOnClickListener(v -> {
            BeautifyCompleteDialog.Builder dialog = new BeautifyCompleteDialog.Builder(this);
            dialog.setHeader("Saved successfully")
                    .setMessageContent("All you data saved successfully")
                    .setImageAnimation(Animator.ROTATE)
                    .setIcon(R.drawable.success)
                    .setOnSuccessClickListener(builder -> dialog.dismiss())
                    .show();

        });


        // Custom Dialog with inners dialogs
        customDialogButton.setOnClickListener(v -> new BeautifyAlertDialog
                .Builder(this)
                .setHeader("Ticket Purchase")
                .setMessageContent("Would you like to buy the ticket?")
                .setLeftButtonText("Yes")
                .setRightButtonText("No")
                .setImageAnimation(Animator.FADE_IN)
                .setIcon(R.drawable.tickets)
                .setOnConfirmListener(beautifyCompleteDialog ->
                        beautifyCompleteDialog
                                .setIcon(R.drawable.success)
                                .setMessageContent("Thanks see you there!")
                                .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
                                .show())
                .setOnCancelListener(beautifyCompleteDialog -> beautifyCompleteDialog
                        .setIcon(R.drawable.sad)
                        .setHeader("Tickets are out")
                        .setMessageContent("Hope to see you next time!")
                        .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
                        .show())
                .show());


        // Progress Bar dialog
        progressBarDialogButton.setOnClickListener(v -> {
            BeautifyProgressBarDialog.Builder beautifyProgressBarDialog = new BeautifyProgressBarDialog.Builder(this);
            beautifyProgressBarDialog
                    .setHeader("Loading...")
                    .setMessageContent("All your imaginary data is downloading please wait until we finish")
                    .setOnClickListener(new ProgressBarEventListener() {
                        @Override
                        public void onCancel() {
                            beautifyProgressBarDialog.dismiss();
                        }

                        @Override
                        public void onComplete(BeautifyCompleteDialog.Builder beautifyCompleteDialog) {
                            new Thread(() -> {
                                try {
                                    Thread.sleep(2000); // Long running task
                                    beautifyProgressBarDialog.dismiss();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }).start();
                        }
                    }).show();
        });
    }

    private void setupView() {
        alertDialogButton = findViewById(R.id.main_activity_alert_dialog_button);
        successDialogButton = findViewById(R.id.main_activity_success_dialog_button);
        customDialogButton = findViewById(R.id.main_activity_custom_dialog_button);
        progressBarDialogButton = findViewById(R.id.main_activity_progress_bar_dialog_button);
    }
}

