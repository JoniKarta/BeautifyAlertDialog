package com.example.beautifyalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.beautify_alert.BeautifyAlertDialog;
import com.example.beautify_alert.BeautifyCompleteDialog;
import com.example.beautify_alert.animation.Animator;

public class MainActivity extends AppCompatActivity {
    private Button alertButton;
    private Button successButton;
    private Button customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();

        alertButton.setOnClickListener(v ->
                new BeautifyAlertDialog
                        .Builder(this)
                        .setHeader("Are you root?")
                        .setMessageContent("This action required root privileged are you sure you want to proceed")
                        .setLeftButtonText("Leave")
                        .setRightButtonText("Cancel")
                        .setIcon(R.drawable.alert)
                        .setImageAnimation(Animator.FADE_IN)
                        .setOnConfirmListener(BeautifyCompleteDialog.Builder::dismiss)
                        .setOnCancelListener(BeautifyCompleteDialog.Builder::dismiss)
                        .show());


        successButton.setOnClickListener(v -> {
            BeautifyCompleteDialog.Builder dialog = new BeautifyCompleteDialog.Builder(this);
            dialog.setHeader("Saved successfully")
                    .setMessageContent("All you data saved successfully")
                    .setIcon(R.drawable.success)
                    .setOnSuccessClickListener(builder -> dialog.dismiss())
                    .setImageAnimation(Animator.ROTATE)
                    .show();
        });


        customDialog.setOnClickListener(v ->
                new BeautifyAlertDialog
                        .Builder(this)
                        .setHeader("Ticket Purchase")
                        .setMessageContent("Would you like to buy the ticket?")
                        .setLeftButtonText("Yes")
                        .setRightButtonText("No")
                        .setIcon(R.drawable.tickets)
                        .setImageAnimation(Animator.FADE_IN)
                        .setOnConfirmListener(beautifyCompleteDialog ->
                                beautifyCompleteDialog
                                        .setIcon(R.drawable.success)
                                        .setMessageContent("Thanks see you there!")
                                        .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
                                        .show())
                        .setOnCancelListener(beautifyCompleteDialog -> beautifyCompleteDialog
                                .setIcon(R.drawable.sad)
                                .setMessageContent("Hope to see you next time!")
                                .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
                                .show())
                        .show());
    }


    private void setupView() {
        alertButton = findViewById(R.id.main_activity_alert_dialog_button);
        successButton = findViewById(R.id.main_activity_success_dialog_button);
        customDialog = findViewById(R.id.main_activity_custom_dialog_button);
    }
}