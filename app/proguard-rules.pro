# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/ray/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original imageUrl file name.
#-renamesourcefileattribute SourceFile




-dontskipnonpubliclibraryclassmembers
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable



-keep public class * extends android.app.Application
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.Fragment
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class * extends android.app.Dialog
-keep public class android.app.Notification
-keep public class com.android.vending.licensing.ILicensingService
-keep public class * extends android.support.annotation.**
-keep class javax.annotation.**{*;}
-dontwarn javax.annotation.**
-keep class android.support.v4.** { *; }
-dontwarn android.support.v4.**
-keep class android.support.v7.** { *; }
-dontwarn android.support.v7.**


-keep class com.imaginato.inflighto.data.model.** { *; }
-dontwarn com.imaginato.inflighto.data.model.**


   -keepnames class * implements java.io.Serializable


    -keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
    }


    -keepclasseswithmembernames class * {
    native <methods>;
    }


    -keep class **.R*{*;}


    -keep class * implements android.os.Parcelable {
    public static finalandroid.os.ParcelableCreator *;
    }





-dontwarn org.hamcrest.**
-dontwarn android.test.**
-dontwarn android.support.test.**
-keep class org.hamcrest.** {
   *;
}
-keep class org.junit.** { *; }
-dontwarn org.junit.**
-keep class junit.** { *; }
-dontwarn junit.**
-keep class sun.misc.** { *; }
-dontwarn sun.misc.**


-keep class **.Webview2JsInterface {*; }
-keep public class android.webkit.**
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}


-dontwarn android.arch.lifecycle.LifecycleProcessor
-dontwarn com.google.auto.common.BasicAnnotationProcessor
-dontwarn android.content.pm.PackageManager

#OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn com.squareup.okhttp.**
-dontwarn com.squareup.okhttp3.**
-dontwarn com.squareup.javapoet.**
-keep class com.squareup.okhttp3.* { *;}
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
# Okio
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

#Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
      **[] $VALUES;
      public *;
    }
-dontwarn com.bumptech.glide.**
-keep class com.bumptech.glide.** { *; }

#butterknife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }

# RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
      long producerIndex;
      long consumerIndex;
  }
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
        rx.internal.util.atomic.LinkedQueueNode producerNode;
    }
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
        rx.internal.util.atomic.LinkedQueueNode consumerNode;
    }

## exoplayer2
-dontwarn com.google.android.exoplayer2.ui.**

#jwplayer
-keepclassmembers class com.longtailvideo.jwplayer.** {
    @android.webkit.JavascriptInterface *;
}

# Block warnings about missing module classes
-dontwarn com.longtailvideo.jwplayer.**
-dontwarn com.google.ads.interactivemedia.**

# Classes get rejected without this when running the app if the app has been run through ProGuard
-keepattributes InnerClasses,EnclosingMethod

# Keep module indicator classes
-keep class com.longtailvideo.jwplayer.modules.** { *; }
