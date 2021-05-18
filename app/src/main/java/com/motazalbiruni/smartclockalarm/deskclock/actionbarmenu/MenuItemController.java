package com.motazalbiruni.smartclockalarm.deskclock.actionbarmenu;

import android.view.Menu;
import android.view.MenuItem;

/**
 * Interface for handling a single menu item in action bar.
 */
public interface MenuItemController {

    /**
     * Returns the menu item resource id that the controller manages.
     */
    int getId();

    /**
     * Create the menu item.
     */
    void onCreateOptionsItem(Menu menu);

    /**
     * Called immediately before the {@link MenuItem} is shown.
     *
     * @param item the {@link MenuItem} created by the controller
     */
    void onPrepareOptionsItem(MenuItem item);

    /**
     * Attempts to handle the click action.
     *
     * @param item the {@link MenuItem} that was selected
     * @return {@code true} if the action is handled by this controller
     */
    boolean onOptionsItemSelected(MenuItem item);
}
