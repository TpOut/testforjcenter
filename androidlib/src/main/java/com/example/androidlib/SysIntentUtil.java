package com.example.androidlib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

public class SysIntentUtil {

    private static boolean hasReceiveTarget(Context context, Intent intent) {
//        intent.resolveActivity(context.getPackageManager()) != null
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        return activities.size() > 0;
    }

    private static Intent createChooseIntent(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        return Intent.createChooser(intent, "对话框的标题");
    }

    private static Intent createPhoneIntent(int phoneNumber) {
        Uri number = Uri.parse("tel:" + phoneNumber);
        return new Intent(Intent.ACTION_DIAL, number);
    }

    public static void startPhoneCall(Context context, int phoneNumber) {
        Intent phoneIntent = createPhoneIntent(phoneNumber);
        if (hasReceiveTarget(context, phoneIntent)) {
            context.startActivity(phoneIntent);
        }
    }

    public static void otherSysIntent(Context context) {
        /**
         * 地图、map
         */
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        /**
         * 网页、web
         */
        Uri webpage = Uri.parse("http://www.baidu.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);


        /**
         * 发送带附件的电子邮件：failed
         */
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
//        emailIntent.setType()
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
    }
}