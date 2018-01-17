package com.hayukleung.learninggussianblur.javaversion;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.learninggussianblur.R;
import com.hayukleung.learninggussianblur.databinding.ActivityJavaVersionDemoBinding;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-30 16:46
 */

public class JavaVersionDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityJavaVersionDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_java_version_demo);

        final Bitmap from = BitmapFactory.decodeResource(getResources(), R.drawable.demo);
        final Bitmap to;

        binding.from.setImageBitmap(from);

        GussianBlur gussianBlur = GussianBlur.getInstance();
        // 非常耗时
        to = gussianBlur.blur(from);

        binding.to.setImageBitmap(to);
    }
}
