package com.motazalbiruni.smartclockalarm.deskclock.widget.selector;

import com.motazalbiruni.smartclockalarm.deskclock.provider.Alarm;

public class AlarmSelection {
    private final String mLabel;
    private final Alarm mAlarm;

    /**
     * Created a new selectable item with a visual label and an id.
     * id corresponds to the Alarm id
     */
    public AlarmSelection(String label, Alarm alarm) {
        mLabel = label;
        mAlarm = alarm;
    }

    public String getLabel() {
        return mLabel;
    }

    public Alarm getAlarm() {
        return mAlarm;
    }
}
