package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.localizer.RobotLocalizer;
import org.firstinspires.ftc.teamcode.utils.MathUtils;

public class RobotDrivetrain {
    private final DcMotor backLeft, frontLeft, frontRight, backRight;
    private final RobotLocalizer localizer;


    public RobotDrivetrain(DcMotor backLeft, DcMotor frontLeft, DcMotor frontRight, DcMotor backRight, RobotLocalizer localizer) {
        this.backLeft = backLeft;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backRight = backRight;
        this.localizer = localizer;
    }
    private double getFlickStickTurn(double currentHeading, double rightStickX, double rightStickY) {
        double rightStickMagnitude = Math.hypot(rightStickX, rightStickY);
        if (rightStickMagnitude < 0.7)
            return 0;
        double desiredHeading = Math.atan2(rightStickY, rightStickX) - (Math.PI / 2.0);

        return MathUtils.getAngleDelta(currentHeading, desiredHeading);
    }
    public void drive(Gamepad gamepad) {
        double heading = localizer.getHeading();
        double flickStick = getFlickStickTurn(heading, gamepad.right_stick_x, -gamepad.right_stick_y);
        double[] rotated = MathUtils.rotateByAngle(gamepad.left_stick_x, -gamepad.left_stick_y, -heading);
        double px = rotated[0];
        double py = rotated[1];
        double pa = flickStick;

        double p1 = -px + py - pa;
        double p2 = px + py - pa;
        double p3 = -px + py + pa;
        double p4 = px + py + pa;


        double max = Math.max(1.0, Math.abs(p1));
        max = Math.max(max, Math.abs(p2));
        max = Math.max(max, Math.abs(p3));
        max = Math.max(max, Math.abs(p4));

        p1 /= max;
        p2 /= max;
        p3 /= max;
        p4 /= max;

        setPowers(p1, p2, p3, p4);
    }

    public void setPowers(double backLeftPower, double frontLeftPower, double frontRightPower, double backRightPower) {
        this.backLeft.setPower(backLeftPower);
        this.frontLeft.setPower(frontLeftPower);
        this.frontRight.setPower(frontRightPower);
        this.backRight.setPower(backRightPower);
    }
}
