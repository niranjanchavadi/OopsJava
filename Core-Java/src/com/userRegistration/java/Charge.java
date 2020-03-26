package com.userRegistration.java;

public class Charge {
    private static final double k = 8.99e09;

    private final double rx;
    private final double ry;
    private final double q;

    public Charge(double x0, double y0, double q0) {
        this.rx = x0;
        this.ry = y0;
        this.q = q0;
    }

    private double potentialAt(double x, double y) {

        double dx = x - rx;
        double dy = y - rx;
        return k * q / Math.sqrt(dx*dx + dy*dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + "," + ry + ")" ;
    }
    public static void main(String[] args) {
        Charge chrg = new Charge(4, 5, 6);
        System.out.println(chrg.potentialAt(5, 6));
        System.out.println(chrg);
    }
}