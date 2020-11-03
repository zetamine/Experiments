package com.example.punchapptest1.data;

import java.time.LocalDateTime;

public class Punch {
    private double punchForce;
    private LocalDateTime date;

    public Punch(double force, LocalDateTime date) {
        this.punchForce = force;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getPunchForce() {
        return punchForce;
    }
}
