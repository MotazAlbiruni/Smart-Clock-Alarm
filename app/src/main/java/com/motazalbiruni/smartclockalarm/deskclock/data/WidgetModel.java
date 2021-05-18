package com.motazalbiruni.smartclockalarm.deskclock.data;

import android.content.SharedPreferences;
import androidx.annotation.StringRes;

import com.motazalbiruni.smartclockalarm.R;
import com.motazalbiruni.smartclockalarm.deskclock.events.Events;

/**
 * All widget data is accessed via this model.
 */
final class WidgetModel {

    private final SharedPreferences mPrefs;

    WidgetModel(SharedPreferences prefs) {
        mPrefs = prefs;
    }

    /**
     * @param widgetClass indicates the type of widget being counted
     * @param count the number of widgets of the given type
     * @param eventCategoryId identifies the category of event to send
     */
    void updateWidgetCount(Class widgetClass, int count, @StringRes int eventCategoryId) {
        int delta = WidgetDAO.updateWidgetCount(mPrefs, widgetClass, count);
        for (; delta > 0; delta--) {
            Events.sendEvent(eventCategoryId, R.string.action_create, 0);
        }
        for (; delta < 0; delta++) {
            Events.sendEvent(eventCategoryId, R.string.action_delete, 0);
        }
    }
}