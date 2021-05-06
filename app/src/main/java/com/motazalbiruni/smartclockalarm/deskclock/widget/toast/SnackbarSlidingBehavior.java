package com.motazalbiruni.smartclockalarm.deskclock.widget.toast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;
/**
 * Custom {@link CoordinatorLayout.Behavior} that slides with the {@link Snackbar}.
 */
@Keep
public class SnackbarSlidingBehavior extends CoordinatorLayout.Behavior<View> {

    public SnackbarSlidingBehavior(Context context, AttributeSet attrs) {
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        updateTranslationY(parent, child);
        return false;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, View child, View dependency) {
        updateTranslationY(parent, child);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        updateTranslationY(parent, child);
        return false;
    }
    private void updateTranslationY(CoordinatorLayout parent, View child) {
        float translationY = 0f;
        for (View dependency : parent.getDependencies(child)) {
            translationY = Math.min(translationY, dependency.getY() - child.getBottom());
        }
        child.setTranslationY(translationY);
    }
}//end class
