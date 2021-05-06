package com.motazalbiruni.smartclockalarm.deskclock.data;

/**
 * The interface through which interested parties are notified of changes to device settings that
 * silence firing alarms.
 */
public interface OnSilentSettingsListener {
    void onSilentSettingsChange(DataModel.SilentSetting before, DataModel.SilentSetting after);
}