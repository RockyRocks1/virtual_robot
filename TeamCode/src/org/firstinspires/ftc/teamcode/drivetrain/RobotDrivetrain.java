package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

public class RobotDrivetrain {
    private final DcMotor backLeft, frontLeft, frontRight, backRight;
    private final IMU imu;

    public RobotDrivetrain(DcMotor backLeft, DcMotor frontLeft, DcMotor frontRight, DcMotor backRight, IMU imu) {
        this.backLeft = backLeft;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backRight = backRight;
        this.imu = imu;
    }

    public void setPowers(double backLeftPower, double frontLeftPower, double frontRightPower, double backRightPower) {
        this.backLeft.setPower(backLeftPower);
        this.frontLeft.setPower(frontLeftPower);
        this.frontRight.setPower(frontRightPower);
        this.backRight.setPower(backRightPower);
    }
}
