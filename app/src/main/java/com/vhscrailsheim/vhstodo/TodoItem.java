package com.vhscrailsheim.vhstodo;

import android.graphics.Bitmap;
import android.os.Parcelable;


import java.io.Serializable;

 public  class TodoItem implements Serializable {
    private Bitmap mImageResource;
    private String mText1;
    private String mText2;
    private boolean misDone;

    public TodoItem(Bitmap imageResource, String text1, String text2, Boolean isDone)
    {
        this.mImageResource = imageResource;
        this.mText1 = text1;
        this.mText2 = text2;
        this.misDone = isDone;
    }

    public Bitmap getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public Boolean getIsDone() {
        return  misDone;
    }
}
