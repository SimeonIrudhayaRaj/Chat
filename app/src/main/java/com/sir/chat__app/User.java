package com.sir.chat__app;

import android.graphics.Bitmap;

public class User {
    int id;
    String name;
    Bitmap icon;
    User (int a, String b, Bitmap c)
    {
        this.id=a;
        this.name=b;
        this.icon=c;
    }
    String getName()
    {
        return name;
    }
}
