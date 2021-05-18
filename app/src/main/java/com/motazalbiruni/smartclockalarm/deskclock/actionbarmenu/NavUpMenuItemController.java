package com.motazalbiruni.smartclockalarm.deskclock.actionbarmenu;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * {@link MenuItemController} for handling navigation up button in actionbar. It is a special
 * menu item because it's not inflated through menu.xml, and has its own predefined id.
 */
public final class NavUpMenuItemController implements MenuItemController {

    private final Activity mActivity;

    public NavUpMenuItemController(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getId() {
        return android.R.id.home;
    }

    @Override
    public void onCreateOptionsItem(Menu menu) {
        // "Home" option is automatically created by the Toolbar.
    }

    @Override
    public void onPrepareOptionsItem(MenuItem item) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mActivity.finish();
        return true;
    }
}
