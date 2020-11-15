package com.example.beautifyalertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.beautify_alert.BeautifyAlertDialog;
import com.example.beautify_alert.BeautifyCompleteDialog;
import com.example.beautify_alert.BeautifyProgressBarDialog;
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
//            BeautifyCompleteDialog.Builder dialog = new BeautifyCompleteDialog.Builder(this);
//            dialog.setHeader("Saved successfully")
//                    .setMessageContent("All you data saved successfully")
//                    .setIcon(R.drawable.success)
//                    .setOnSuccessClickListener(builder -> dialog.dismiss())
//                    .setImageAnimation(Animator.ROTATE)
//                    .show();

            new BeautifyProgressBarDialog.Builder(this)
                    .setBarBackgroundColor()
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

/**
 * # Beautify-Alert-Dialog
 * ![JitPack](https://img.shields.io/jitpack/v/github/JoniKarta/BeautifyAlertDialog)
 *
 * A library for custom alert dialog.
 * The user have control of the multiple part of the layout such as icon, buttons, messages and color could
 * customize them using multiple pre-built features.
 * The library also include animation for icons.
 *
 *
 * ## Setup
 * Step 1. Add it in your root build.gradle at the end of repositories:
 * ```
 * allprojects {
 * 		repositories {
 * 			maven { url 'https://jitpack.io' }
 *                }
 * }
 * ```
 *
 * Step 2. Add the dependency:
 * ```
 * dependencies {
 * 	        implementation 'com.github.JoniKarta:BeautifyAlertDialog:1.0.1'
 * }
 * ```
 * ## Usage
 *
 * ###### Basic Alert Dialog:
 * ```java
 *
 *  new BeautifyAlertDialog
 *       .Builder(this)
 *       .setHeader("Are you root?")
 *       .setMessageContent("This action required root privileged are you sure you want to proceed")
 *       .setLeftButtonText("Leave")
 *       .setRightButtonText("Cancel")
 *       .setIcon(R.drawable.alert)
 *       .setImageAnimation(Animator.FADE_IN)
 *       .setOnConfirmListener(BeautifyCompleteDialog.Builder::dismiss)
 *       .setOnCancelListener(BeautifyCompleteDialog.Builder::dismiss)
 *       .show());
 * ```
 *
 * ###### Basic Success Dialog:
 * ```java
 *
 * BeautifyCompleteDialog.Builder dialog = new BeautifyCompleteDialog.Builder(this);
 *   dialog.setHeader("Saved successfully")
 *       .setMessageContent("All you data saved successfully")
 *       .setIcon(R.drawable.success)
 *       .setOnSuccessClickListener(builder -> dialog.dismiss())
 *       .setImageAnimation(Animator.ROTATE)
 *       .show();
 *
 * ```
 *
 * ###### Basic Custom Dialog With Inner Dialog
 * ```java
 *
 * new BeautifyAlertDialog
 *       .Builder(this)
 *       .setHeader("Ticket Purchase")
 *       .setMessageContent("Would you like to buy the ticket?")
 *       .setLeftButtonText("Yes")
 *       .setRightButtonText("No")
 *       .setIcon(R.drawable.tickets)
 *       .setImageAnimation(Animator.FADE_IN)
 *       .setOnConfirmListener(beautifyCompleteDialog ->
 *                             beautifyCompleteDialog
 *                               .setIcon(R.drawable.success)
 *                               .setMessageContent("Thanks see you there!")
 *                               .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
 *                               .show())
 *       .setOnCancelListener(beautifyCompleteDialog ->
 *                             beautifyCompleteDialog
 *                                .setIcon(R.drawable.sad)
 *                                .setMessageContent("Hope to see you next time!")
 *                                .setOnSuccessClickListener(builder -> beautifyCompleteDialog.dismiss())
 *                                .show())
 *        .show());
 * ```
 *
 *
 * ## License
 *
 *     Copyright 2020 Jonathan Karta
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 * ## Credits
*/