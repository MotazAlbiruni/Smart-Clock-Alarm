package com.motazalbiruni.smartclockalarm.deskclock.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import com.motazalbiruni.smartclockalarm.R;
import com.motazalbiruni.smartclockalarm.deskclock.Utils;
import com.motazalbiruni.smartclockalarm.deskclock.data.DataModel.AlarmVolumeButtonBehavior;
import com.motazalbiruni.smartclockalarm.deskclock.data.DataModel.CitySort;
import com.motazalbiruni.smartclockalarm.deskclock.data.DataModel.ClockStyle;

import java.util.TimeZone;

/**
 * All settings data is accessed via this model.
 */
final class SettingsModel {

    private final Context mContext;

    private final SharedPreferences mPrefs;

    /** The model from which time data are fetched. */
    private final TimeModel mTimeModel;

    /** The uri of the default ringtone to use for timers until the user explicitly chooses one. */
    private Uri mDefaultTimerRingtoneUri;

    SettingsModel(Context context, SharedPreferences prefs, TimeModel timeModel) {
        mContext = context;
        mPrefs = prefs;
        mTimeModel = timeModel;

        // Set the user's default display seconds preference if one has not yet been chosen.
        SettingsDAO.setDefaultDisplayClockSeconds(mContext, prefs);
    }

    int getGlobalIntentId() {
        return SettingsDAO.getGlobalIntentId(mPrefs);
    }

    void updateGlobalIntentId() {
        SettingsDAO.updateGlobalIntentId(mPrefs);
    }

    CitySort getCitySort() {
        return SettingsDAO.getCitySort(mPrefs);
    }

    void toggleCitySort() {
        SettingsDAO.toggleCitySort(mPrefs);
    }

    TimeZone getHomeTimeZone() {
        return SettingsDAO.getHomeTimeZone(mContext, mPrefs, TimeZone.getDefault());
    }

    ClockStyle getClockStyle() {
        return SettingsDAO.getClockStyle(mContext, mPrefs);
    }

    boolean getDisplayClockSeconds() {
        return SettingsDAO.getDisplayClockSeconds(mPrefs);
    }

    void setDisplayClockSeconds(boolean shouldDisplaySeconds) {
        SettingsDAO.setDisplayClockSeconds(mPrefs, shouldDisplaySeconds);
    }

    ClockStyle getScreensaverClockStyle() {
        return SettingsDAO.getScreensaverClockStyle(mContext, mPrefs);
    }

    boolean getScreensaverNightModeOn() {
        return SettingsDAO.getScreensaverNightModeOn(mPrefs);
    }

    boolean getShowHomeClock() {
        if (!SettingsDAO.getAutoShowHomeClock(mPrefs)) {
            return false;
        }

        // Show the home clock if the current time and home time differ.
        // (By using UTC offset for this comparison the various DST rules are considered)
        final TimeZone defaultTZ = TimeZone.getDefault();
        final TimeZone homeTimeZone = SettingsDAO.getHomeTimeZone(mContext, mPrefs, defaultTZ);
        final long now = System.currentTimeMillis();
        return homeTimeZone.getOffset(now) != defaultTZ.getOffset(now);
    }

    Uri getDefaultTimerRingtoneUri() {
        if (mDefaultTimerRingtoneUri == null) {
            mDefaultTimerRingtoneUri = Utils.getResourceUri(mContext, R.raw.timer_expire);
        }

        return mDefaultTimerRingtoneUri;
    }

    void setTimerRingtoneUri(Uri uri) {
        SettingsDAO.setTimerRingtoneUri(mPrefs, uri);
    }

    Uri getTimerRingtoneUri() {
        return SettingsDAO.getTimerRingtoneUri(mPrefs, getDefaultTimerRingtoneUri());
    }

    AlarmVolumeButtonBehavior getAlarmVolumeButtonBehavior() {
        return SettingsDAO.getAlarmVolumeButtonBehavior(mPrefs);
    }

    int getAlarmTimeout() {
        return SettingsDAO.getAlarmTimeout(mPrefs);
    }

    int getSnoozeLength() {
        return SettingsDAO.getSnoozeLength(mPrefs);
    }
    
    int getFlipAction() {
        return SettingsDAO.getFlipAction(mPrefs);
    }

    int getShakeAction() {
        return SettingsDAO.getShakeAction(mPrefs);
    }

    Uri getDefaultAlarmRingtoneUri() {
        return SettingsDAO.getDefaultAlarmRingtoneUri(mPrefs);
    }

    void setDefaultAlarmRingtoneUri(Uri uri) {
        SettingsDAO.setDefaultAlarmRingtoneUri(mPrefs, uri);
    }

    long getAlarmCrescendoDuration() {
        return SettingsDAO.getAlarmCrescendoDuration(mPrefs);
    }

    long getTimerCrescendoDuration() {
        return SettingsDAO.getTimerCrescendoDuration(mPrefs);
    }

    Weekdays.Order getWeekdayOrder() {
        return SettingsDAO.getWeekdayOrder(mPrefs);
    }

    boolean isRestoreBackupFinished() {
        return SettingsDAO.isRestoreBackupFinished(mPrefs);
    }

    void setRestoreBackupFinished(boolean finished) {
        SettingsDAO.setRestoreBackupFinished(mPrefs, finished);
    }

    boolean getTimerVibrate() {
        return SettingsDAO.getTimerVibrate(mPrefs);
    }

    void setTimerVibrate(boolean enabled) {
        SettingsDAO.setTimerVibrate(mPrefs, enabled);
    }

    TimeZones getTimeZones() {
        return SettingsDAO.getTimeZones(mContext, mTimeModel.currentTimeMillis());
    }
}
