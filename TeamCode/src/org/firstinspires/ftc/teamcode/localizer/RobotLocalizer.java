package org.firstinspires.ftc.teamcode.localizer;

public abstract class RobotLocalizer {
    protected double x, y, heading;
    public RobotLocalizer() {
        reset();
    };
    public void reset() {
        x = 0.0;
        y = 0.0;
        heading = 0.0;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getHeading() {
        return heading;
    }
    public abstract void update();
 }
