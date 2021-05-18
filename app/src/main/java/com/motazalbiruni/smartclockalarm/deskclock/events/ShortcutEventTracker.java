package com.motazalbiruni.smartclockalarm.deskclock.events;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import androidx.annotation.StringRes;
import android.util.ArraySet;

import com.motazalbiruni.smartclockalarm.R;
import com.motazalbiruni.smartclockalarm.deskclock.uidata.UiDataModel;

import java.util.Set;

@TargetApi(Build.VERSION_CODES.N_MR1)
public final class ShortcutEventTracker implements EventTracker {

    private final ShortcutManager mShortcutManager;
    private final Set<String> shortcuts = new ArraySet<>(5);

    public ShortcutEventTracker(Context context) {
        mShortcutManager = context.getSystemService(ShortcutManager.class);
        final UiDataModel uidm = UiDataModel.getUiDataModel();
        shortcuts.add(uidm.getShortcutId(R.string.category_alarm, R.string.action_create));
        shortcuts.add(uidm.getShortcutId(R.string.category_timer, R.string.action_create));
        shortcuts.add(uidm.getShortcutId(R.string.category_stopwatch, R.string.action_pause));
        shortcuts.add(uidm.getShortcutId(R.string.category_stopwatch, R.string.action_start));
        shortcuts.add(uidm.getShortcutId(R.string.category_screensaver, R.string.action_show));
    }

    @Override
    public void sendEvent(@StringRes int category, @StringRes int action, @StringRes int label) {
        final String shortcutId = UiDataModel.getUiDataModel().getShortcutId(category, action);
        if (shortcuts.contains(shortcutId)) {
            mShortcutManager.reportShortcutUsed(shortcutId);
        }
    }
}