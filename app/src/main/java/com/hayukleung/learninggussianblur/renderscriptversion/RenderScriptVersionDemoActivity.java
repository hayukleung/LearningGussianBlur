package com.hayukleung.learninggussianblur.renderscriptversion;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.hayukleung.learninggussianblur.R;
import com.hayukleung.learninggussianblur.databinding.ActivityRenderScriptVersionDemoBinding;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-30 17:08
 */

public class RenderScriptVersionDemoActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityRenderScriptVersionDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_render_script_version_demo);

        final Bitmap from = BitmapFactory.decodeResource(getResources(), R.drawable.demo);
        final Bitmap to;

        binding.from.setImageBitmap(from);

        to = GussianBlur.blur(this, from);

        binding.to.setImageBitmap(to);
    }
}
