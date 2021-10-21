package com.bathymatrix.apprate;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

// import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;



@NativePlugin
public class AppRateClass extends AppCompatActivity {

    @PluginMethod
    public void rate(PluginCall call) {
        // AppCompatActivity activity = this.getActivity();
        ReviewManager manager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> request = manager.requestReviewFlow();

        request.addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                ReviewInfo reviewInfo = task.getResult();
                Task<Void> flow = manager.launchReviewFlow(this, reviewInfo);
                flow.addOnCompleteListener(launchTask -> {
                    // if (task.isSuccessful()) {
                    //     callbackContext.success();
                    // } else {
                    //     Exception error = task.getException();
                    //     callbackContext.error("Failed to launch review - " + error.getMessage());
                    // }
                });
            } else {
                Exception error = task.getException();
                callbackContext.error("Failed to launch review flow - " + error.getMessage());
            }

        });

	call.success();
    }
}
