package com.example.news;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class MyBlurBuilder {
    public static Bitmap applyBlur(Context pContext, Bitmap pSrcBitmap, float pBlurRadius)
    {
        if (pSrcBitmap != null)
        {
            Bitmap copyBitmap = pSrcBitmap.copy(Bitmap.Config.ARGB_8888, true);
            Bitmap outputBitmap = Bitmap.createBitmap(copyBitmap);

            RenderScript renderScript = RenderScript.create(pContext);
            ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));

            Allocation allocationIn = Allocation.createFromBitmap(renderScript, pSrcBitmap);
            Allocation allocationOut = Allocation.createFromBitmap(renderScript, outputBitmap);

            scriptIntrinsicBlur.setRadius(pBlurRadius);
            scriptIntrinsicBlur.setInput(allocationIn);
            scriptIntrinsicBlur.forEach(allocationOut);

            allocationOut.copyTo(outputBitmap);

            return outputBitmap;
        }
        else
        {
            return null;
        }
    }
}
