package org.firstinspires.ftc.teamcode.localizer;


import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class IMULocalizer extends RobotLocalizer {
    private final IMU imu;
    public IMULocalizer(IMU imu) {
        super();
        this.imu = imu;
        reset();
    }
    @Override
    public void reset() {
        super.reset();
        if (this.imu != null)
            imu.resetYaw();
    }
    @Override
    public void update() {
        Orientation orientation = imu.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);
        this.heading = orientation.firstAngle;
        // TODO: maybe, just maybe add position tracking here...
    }
}
