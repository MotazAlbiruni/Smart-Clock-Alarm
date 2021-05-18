package com.motazalbiruni.smartclockalarm.deskclock.actionbarmenu;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.motazalbiruni.smartclockalarm.R;
import com.motazalbiruni.smartclockalarm.deskclock.settings.SettingsActivity;

import static android.view.Menu.NONE;

/**
 * {@link MenuItemController} for settings menu.
 */
public final class SettingsMenuItemController implements MenuItemController {

    public static final int REQUEST_CHANGE_SETTINGS = 1;

    private static final int SETTING_MENU_RES_ID = R.id.menu_item_settings;

    private final Activity mActivity;

    public SettingsMenuItemController(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getId() {
        return SETTING_MENU_RES_ID;
    }

    @Override
    public void onCreateOptionsItem(Menu menu) {
        menu.add(NONE, SETTING_MENU_RES_ID, NONE, R.string.menu_item_settings)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
    }

    @Override
    public void onPrepareOptionsItem(MenuItem item) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final Intent settingIntent = new Intent(mActivity, SettingsActivity.class);
        mActivity.startActivityForResult(settingIntent, REQUEST_CHANGE_SETTINGS);
        return true;
    }
}
