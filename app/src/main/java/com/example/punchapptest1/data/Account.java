package com.example.punchapptest1.data;


import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Account {

    private int ID;
    private ArrayList<Punch> punches = new ArrayList<Punch>();
    String pattern = "##.###";
    DecimalFormat format = new DecimalFormat(pattern);

    public Account(int id) {
        this.ID = id;
    }

    /**
     * Adds a new punch
     *
     * @param force Force of the punch.
     */
    public void newRecord(double force) {
        Punch newPunch = new Punch(force);
        this.punches.add(newPunch);
    }

    //clear
    public void clear() {
        if (this.punches.size() == 0) {
            return;
        }

        while (this.punches.size() > 0) {
            this.punches.remove(0);
        }
    }

    //display

    @Override
    public String toString() {
        String list = "";

        if (this.punches.size() == 0) {
            return "";
        }

        for (Punch punch : punches) {
            list += "Date: " + punch.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                    "\nForce: " + format.format(punch.getPunchForce()) + "\n\n";
        }

        return list;
    }
}
