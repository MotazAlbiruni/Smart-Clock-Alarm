package com.motazalbiruni.smartclockalarm.deskclock.data;

/**
 * Data that must be coordinated across all notifications is accessed via this model.
 */
final class NotificationModel {

    private boolean mApplicationInForeground;

    /**
     * @param inForeground {@code true} to indicate the application is open in the foreground
     */
    void setApplicationInForeground(boolean inForeground) {
        mApplicationInForeground = inForeground;
    }

    /**
     * @return {@code true} while the application is open in the foreground
     */
    boolean isApplicationInForeground() {
        return mApplicationInForeground;
    }

    //
    // Notification IDs
    //
    // Used elsewhere:
    // Integer.MAX_VALUE - 4
    // Integer.MAX_VALUE - 5
    // Integer.MAX_VALUE - 7
    //

    /**
     * @return a value that identifies the stopwatch notification
     */
    int getStopwatchNotificationId() {
        return Integer.MAX_VALUE - 1;
    }

    /**
     * @return a value that identifies the notification for running/paused timers
     */
    int getUnexpiredTimerNotificationId() {
        return Integer.MAX_VALUE - 2;
    }

    /**
     * @return a value that identifies the notification for expired timers
     */
    int getExpiredTimerNotificationId() {
        return Integer.MAX_VALUE - 3;
    }

    /**
     * @return a value that identifies the notification for missed timers
     */
    int getMissedTimerNotificationId() {
        return Integer.MAX_VALUE - 6;
    }

    //
    // Notification Group keys
    //
    // Used elsewhere:
    // "1"
    // "4"

    /**
     * @return the group key for the stopwatch notification
     */
    String getStopwatchNotificationGroupKey() {
        return "3";
    }

    /**
     * @return the group key for the timer notification
     */
    String getTimerNotificationGroupKey() {
        return "2";
    }

    //
    // Notification Sort keys
    //

    /**
     * @return the sort key for the timer notification
     */
    String getTimerNotificationSortKey() {
        return "0";
    }

    /**
     * @return the sort key for the missed timer notification
     */
    String getTimerNotificationMissedSortKey() {
        return "1";
    }
}