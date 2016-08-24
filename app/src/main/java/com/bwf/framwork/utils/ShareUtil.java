package com.bwf.framwork.utils;

import android.app.Activity;
import android.content.Context;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by admin on 2016/8/10.
 */
public class ShareUtil {
   public static void shareToQQ(Activity activity, SHARE_MEDIA platform, String title, String content, String targetUrl, String imgUrl, UMShareListener shareListener){
       new ShareAction(activity)
               .setPlatform(platform)
               .withTitle(title)
               .withText(content)
               .withTargetUrl(targetUrl)
               .withMedia(new UMImage(activity, imgUrl))
               .setCallback(shareListener)
               .share();
   }

}
