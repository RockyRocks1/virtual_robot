package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.drivetrain.RobotDrivetrain;

@TeleOp(name = "TeleOpTest", group = "Demos")
public class TeleOpTest extends LinearOpMode {

    public void runOpMode() {
        RobotHardware hardware = new RobotHardware(hardwareMap);
        RobotDrivetrain drivetrain = new RobotDrivetrain(hardware.backLeft, hardware.frontLeft, hardware.frontLeft, hardware.frontRight, hardware.imu);

        waitForStart();
        while (opModeIsActive()) {
            drivetrain.setPowers(0.5, 1, 0.5, 1);
        }
        drivetrain.setPowers(0,0,0,0);
    }
}
