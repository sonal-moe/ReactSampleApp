package com.reactsampleapp;

import android.app.Application;
import android.content.Context;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.moengage.react.MoEReactPackage;
import com.moengage.core.MoEngage;
import com.moengage.core.Logger;
import com.moe.pushlibrary.MoEHelper;
import com.moengage.core.MoEngage;
import com.moengage.react.MoEInitializer;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    // this is the instance of the application class and "XXXXXXXXXXX" is the APP ID from the dashboard.
 //moengage SDK initialisation
  MoEngage moEngage =
       new MoEngage.Builder(this, "XXXXXXXXXXX")
       .setNotificationSmallIcon(R.drawable.ic_launcher)
       .setNotificationLargeIcon(R.drawable.ic_launcher_round)
       .setLogLevel(Logger.VERBOSE)
       .build();
   MoEInitializer.initialize(moEngage);

  }
}
