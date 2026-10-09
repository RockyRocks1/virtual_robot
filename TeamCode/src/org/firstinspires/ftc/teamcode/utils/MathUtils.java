package org.firstinspires.ftc.teamcode.utils;

public class MathUtils {
    public static double[] rotateByAngle(double x, double y, double angle) {
        double sinA = Math.sin(angle);
        double cosA = Math.cos(angle);

        return new double[]{x * cosA - y * sinA, x * sinA + y * cosA};
    }
    public static double getAngleDelta(double currentAngle, double targetAngle) {
        double delta = targetAngle - currentAngle;
        return Math.atan2(Math.sin(delta), Math.cos(delta));
    }
}
