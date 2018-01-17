package com.hayukleung.learninggussianblur.blurkitversion;

import android.app.Application;

import com.wonderkiln.blurkit.BlurKit;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-31 17:31
 */

public class BlurKitVersionApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlurKit.init(this);
    }
}
