package com.hayukleung.learninggussianblur.blurryversion;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hayukleung.learninggussianblur.R;
import com.hayukleung.learninggussianblur.databinding.ActivityBlurryVersionDemoBinding;

import jp.wasabeef.blurry.Blurry;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-30 16:46
 */

public class BlurryVersionDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityBlurryVersionDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_blurry_version_demo);

        final Bitmap from = BitmapFactory.decodeResource(getResources(), R.drawable.demo);

        binding.from.setImageBitmap(from);

        Blurry.with(this)
                .radius(10)
                .sampling(2)
                .async(new Blurry.ImageComposer.ImageComposerListener() {
                    @Override
                    public void onImageReady(BitmapDrawable drawable) {
                        binding.to.setImageDrawable(drawable);
                        Toast.makeText(BlurryVersionDemoActivity.this, "done", Toast.LENGTH_SHORT).show();
                    }
                })
                .from(from)
                .into(binding.to);
    }
}
