package com.hayukleung.learninggussianblur.blurkitversion;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.learninggussianblur.R;
import com.hayukleung.learninggussianblur.databinding.ActivityBlurKitVersionDemoBinding;
import com.wonderkiln.blurkit.BlurKit;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-30 16:46
 */

public class BlurKitVersionDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBlurKitVersionDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_blur_kit_version_demo);

        final Bitmap from = BitmapFactory.decodeResource(getResources(), R.drawable.demo);
        final Bitmap to = BitmapFactory.decodeResource(getResources(), R.drawable.demo);

        binding.from.setImageBitmap(from);

        BlurKit.getInstance().blur(to, 25);

        binding.to.setImageBitmap(to);
    }
}
