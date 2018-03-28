package com.example.vlatkopopovic.facebookphotochecker;

import android.graphics.Bitmap;


import com.squareup.picasso.Transformation;

/**
 * Created by Vlatko Popovic on 2/6/2018.
 */

public class ScaleToFitWidthHeightTransform implements Transformation {
      static public int visina;
   static  public int sirina;



    Bitmap scaleBitmap;
    private int mSize;
    private boolean isHeightScale;

    public ScaleToFitWidthHeightTransform(int size, boolean isHeightScale){
       mSize =size;
        this.isHeightScale = isHeightScale;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        float scale;

        int newSize;


        if(isHeightScale){


            scale = (float) mSize / source.getHeight();

            newSize = Math.round(source.getWidth() * scale);



            scaleBitmap= Bitmap.createScaledBitmap(source, newSize, mSize, true);
            sirina = scaleBitmap.getWidth();
            visina = scaleBitmap.getHeight();
        }else{
            scale = (float) mSize / source.getWidth();

            newSize = Math.round(source.getHeight() * scale);

            scaleBitmap = Bitmap.createScaledBitmap(source,  mSize,newSize, true);
            sirina = scaleBitmap.getWidth();
            visina = scaleBitmap.getHeight();
        }

        if (scaleBitmap != source) {
            source.recycle();
        }

        return scaleBitmap;

    }


    @Override
    public String key() {
        return "scaleRespectRatio" + mSize + isHeightScale;
    }
}