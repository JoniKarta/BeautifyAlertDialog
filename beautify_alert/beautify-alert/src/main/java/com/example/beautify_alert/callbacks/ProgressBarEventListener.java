package com.example.beautify_alert.callbacks;

import com.example.beautify_alert.BeautifyCompleteDialog;

public interface ProgressBarEventListener {

    void onCancel();

    void onComplete(BeautifyCompleteDialog beautifyCompleteDialog);
}
