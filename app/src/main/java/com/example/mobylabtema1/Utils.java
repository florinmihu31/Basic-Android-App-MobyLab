package com.example.mobylabtema1;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void displayToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }
}
