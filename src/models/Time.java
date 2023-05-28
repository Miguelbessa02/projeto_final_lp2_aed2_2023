package models;

import edu.princeton.cs.algs4.Date;

/**
 * Represents a time.
 */
public class Time implements Comparable<Time> {
    private int hour;
    private int minute;
    private Date date;

    /**
     * Constructs a Time object with the specified hour, minute, and date.
     *
     * @param hour   The hour.
     * @param minute The minute.
     * @param date   The date.
     */
    public Time(int hour, int minute, Date date) {
        this.hour = hour;
        this.minute = minute;
        this.date = date;
    }

    /**
     * Gets the hour.
     *
     * @return The hour.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Sets the hour.
     *
     * @param hour The hour.
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * Gets the minute.
     *
     * @return The minute.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Sets the minute.
     *
     * @param minute The minute.
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }

    /**
     * Gets the date.
     *
     * @return The date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param date The date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns a string representation of the time.
     *
     * @return A string representation of the time.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    /**
     * Compares this time to the specified time.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this time is less than, equal to, or greater than the specified time.
     */
    @Override
    public int compareTo(Time o) {
        if (getDate().compareTo(o.getDate()) == 0) {
            if (getHour() == o.getHour()) {
                return getMinute() - o.getMinute();
            }
            return getHour() - o.getHour();
        }

        return getDate().compareTo(o.getDate());
    }
}
