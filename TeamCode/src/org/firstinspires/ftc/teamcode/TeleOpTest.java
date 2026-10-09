package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.drivetrain.RobotDrivetrain;
import org.firstinspires.ftc.teamcode.localizer.IMULocalizer;
import org.firstinspires.ftc.teamcode.localizer.RobotLocalizer;

@TeleOp(name = "TeleOpTest", group = "Demos")
public class TeleOpTest extends LinearOpMode {

    public void runOpMode() {
        RobotHardware hardware = new RobotHardware(hardwareMap);
        RobotLocalizer localizer = new IMULocalizer(hardware.imu);
        RobotDrivetrain drivetrain = new RobotDrivetrain(hardware.backLeft, hardware.frontLeft, hardware.frontRight, hardware.backRight, localizer);

        waitForStart();
        while (opModeIsActive()) {
            localizer.update();

            drivetrain.drive(gamepad1);
        }
        drivetrain.setPowers(0,0,0,0);
    }
}
