package com.motazalbiruni.smartclockalarm.deskclock.data;

/**
 * The interface through which interested parties are notified of changes to the stopwatch or laps.
 */
public interface StopwatchListener {

    /**
     * @param before the stopwatch state before the update
     * @param after the stopwatch state after the update
     */
    void stopwatchUpdated(Stopwatch before, Stopwatch after);

    /**
     * @param lap the lap that was added
     */
    void lapAdded(Lap lap);
}