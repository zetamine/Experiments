package com.example.punchapptest1.data;

import java.time.LocalDateTime;

public class Punch {
    private Double punchForce;
    private LocalDateTime date;

    public Punch(double force) {
        this.punchForce = force;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getPunchForce() {
        return punchForce;
    }
}
