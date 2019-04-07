package com.droidrank.cantaloupework.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.droidrank.cantaloupework.R;

import java.util.List;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

public class AppUtils {

    public static void intentUtil(Context context, String url) {

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);

        int requestCode = 100;

        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        builder.setActionButton(bitmap, "Share Link", pendingIntent, true);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
