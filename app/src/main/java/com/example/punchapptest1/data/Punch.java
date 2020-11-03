package com.example.punchapptest1.data;

import java.time.LocalDateTime;

/**
 * Data class for punch.
 */
public class Punch {
    private Double punchForce;
    private LocalDateTime date;

    public Punch(double force) {
        this.punchForce = force;
        this.date = LocalDateTime.now(); // gets the local time
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getPunchForce() {
        return punchForce;
    }
}
