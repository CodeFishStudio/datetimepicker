package com.reactcommunity.rndatetimepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TimePicker;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class ReactTimePickerView extends FrameLayout {
    @Nullable
    TimePicker mTimePicker;

    public ReactTimePickerView(final ThemedReactContext context) {
        super(context);

        final View myView = this;

        mTimePicker = new TimePicker(context);

        mTimePicker.setBackgroundColor(Color.argb(0, 0,0,0));

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                                                 @Override
                                                 public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                                                     RCTEventEmitter emitter = context.getJSModule(RCTEventEmitter.class);

                                                     WritableMap event = Arguments.createMap();

                                                     event.putInt("hour", hourOfDay);
                                                     event.putInt("minute", minute);

                                                     emitter.receiveEvent(myView.getId(), "dateChange", event);
                                                 }
                                             });

                removeAllViews();
        addView(mTimePicker);

    }

    public void setHour(int hour) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setHour(hour);
        }
    }

    public void setMinute(int minute) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mTimePicker.setMinute(minute);
        }
    }
}
