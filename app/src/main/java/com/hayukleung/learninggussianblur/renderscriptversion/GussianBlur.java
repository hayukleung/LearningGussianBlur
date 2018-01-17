package com.hayukleung.learninggussianblur.renderscriptversion;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.RequiresApi;

/**
 * LearningGussianBlur
 * <p>
 * hayukleung@gmail.com
 * 2017-12-30 17:12
 */

public class GussianBlur {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static Bitmap blur(Context context, Bitmap from) {
        Bitmap to = Bitmap.createBitmap(from.getWidth(), from.getHeight(), Bitmap.Config.ARGB_8888);
        // 创建 render script 对象
        RenderScript renderScript = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        Allocation in = Allocation.createFromBitmap(renderScript, from);
        Allocation out = Allocation.createFromBitmap(renderScript, to);
        scriptIntrinsicBlur.setRadius(25f);
        scriptIntrinsicBlur.setInput(in);
        scriptIntrinsicBlur.forEach(out);
        out.copyTo(to);
        renderScript.destroy();
        return to;
    }
}
