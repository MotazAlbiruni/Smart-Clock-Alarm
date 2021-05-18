package com.motazalbiruni.smartclockalarm.deskclock.actionbarmenu;

import android.app.Activity;

/**
 * Provider for a {@link MenuItemController} instances.
 */
public interface MenuItemProvider {

    /**
     * provides a {@link MenuItemController} that handles menu item.
     */
    MenuItemController provide(Activity activity);
}
