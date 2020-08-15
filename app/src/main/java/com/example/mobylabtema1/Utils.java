package com.example.mobylabtema1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Utils {
    public static void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void displayToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void startMaps(Context context, double x, double y) {
        Uri locationUri = Uri.parse("geo:" + x + "," + y);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

        if (mapIntent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(mapIntent);
        }
    }
}
