package com.example.punchapptest1.data;


import java.util.ArrayList;

public class Account {

    private int ID;
    private ArrayList<Punch> punches = new ArrayList<Punch>();

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
        for (Punch punch : punches
        ) {
            punches.remove(punch);
        }
    }

    //display

    @Override
    public String toString() {
        String list = "";

        for (Punch punch : punches) {
            list += punch.getDate() + " " + punch.getPunchForce().toString() + "\n\n";
        }

        return list;
    }
}
