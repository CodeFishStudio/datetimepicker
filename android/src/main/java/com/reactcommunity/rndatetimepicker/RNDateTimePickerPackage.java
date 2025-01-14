package com.reactcommunity.rndatetimepicker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

public class RNDateTimePickerPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      return Arrays.<NativeModule>asList(
        new com.reactcommunity.rndatetimepicker.RNDatePickerDialogModule(reactContext),
        new com.reactcommunity.rndatetimepicker.RNTimePickerDialogModule(reactContext)
      );
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Arrays.<ViewManager>asList(
              new com.reactcommunity.rndatetimepicker.ReactTimePickerManager(reactContext)
      );
    }
}
