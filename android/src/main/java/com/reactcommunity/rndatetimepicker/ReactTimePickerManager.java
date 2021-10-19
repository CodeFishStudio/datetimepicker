package com.reactcommunity.rndatetimepicker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class ReactTimePickerManager extends SimpleViewManager<ReactTimePickerView> {
    public static final String REACT_CLASS = "RTCTimePickerView";
    ReactApplicationContext mCallerContext;

    public ReactTimePickerManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public ReactTimePickerView createViewInstance(ThemedReactContext reactContext) {
        return new com.reactcommunity.rndatetimepicker.ReactTimePickerView(reactContext);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("dateChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onChange"))).build();
    }

    @ReactProp(name="hour")
    public void setHour(ReactTimePickerView view, int hour) {
        view.setHour(hour);
    }

    @ReactProp(name="minute")
    public void setMinute(ReactTimePickerView view, int minute) {
        view.setMinute(minute);
    }

}
