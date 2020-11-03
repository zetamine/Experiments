package com.example.punchapptest1.data;


import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

/**
 * Account class to hold punch data for a single user
 */
public class Account {

    private int ID; // account id | not really useful right now
    private ArrayList<Punch> punches = new ArrayList<Punch>(); // arrayList of punches
    String pattern = "##.###"; // pattern to format punch force
    DecimalFormat format = new DecimalFormat(pattern);

    public Account(int id) {
        this.ID = id;
    } // constructor to set ID

    /**
     * Adds a new punch
     *
     * @param force Force of the punch.
     */
    public void newRecord(double force) {
        Punch newPunch = new Punch(force);
        this.punches.add(newPunch);
    }

    /**
     * Clears all punch data
     */
    public void clear() {
        if (this.punches.size() == 0) {
            return; // if list is empty then return
        }

        while (this.punches.size() > 0) {
            this.punches.remove(0);
        }
    }

    @Override
    public String toString() {
        String list = "";

        if (this.punches.size() == 0) {
            return "";
        }

        for (Punch punch : punches) { // formats the date and force to make it look readable
            list += "Date: " + punch.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                    "\nForce: " + format.format(punch.getPunchForce()) + "\n\n";
        }

        return list;
    }
}
