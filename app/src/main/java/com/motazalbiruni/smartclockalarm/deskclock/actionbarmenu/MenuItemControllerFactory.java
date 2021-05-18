package com.motazalbiruni.smartclockalarm.deskclock.actionbarmenu;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory that builds optional {@link MenuItemController} instances.
 */
public final class MenuItemControllerFactory {

    private static final MenuItemControllerFactory INSTANCE = new MenuItemControllerFactory();

    public static MenuItemControllerFactory getInstance() {
        return INSTANCE;
    }

    private final List<MenuItemProvider> mMenuItemProviders;

    private MenuItemControllerFactory() {
        mMenuItemProviders = new ArrayList<>();
    }

    public MenuItemControllerFactory addMenuItemProvider(MenuItemProvider provider) {
        mMenuItemProviders.add(provider);
        return this;
    }

    public MenuItemController[] buildMenuItemControllers(Activity activity) {
        final int providerSize = mMenuItemProviders.size();
        final MenuItemController[] controllers = new MenuItemController[providerSize];
        for (int i = 0; i < providerSize; i++) {
            controllers[i] = mMenuItemProviders.get(i).provide(activity);
        }
        return controllers;
    }
}
