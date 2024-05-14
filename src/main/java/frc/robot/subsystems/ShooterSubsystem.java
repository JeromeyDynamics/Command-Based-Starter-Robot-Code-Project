package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    private final Spark shooter1Spark = new Spark(ShooterConstants.kShooter1);
    private final Spark shooter2Spark = new Spark(ShooterConstants.kShooter2);
    private final Encoder encoder = new Encoder(ShooterConstants.kShooterEncoderlA, ShooterConstants.kShooterEncoderlB);
    private final double kEncoderTick2Meter = 1.0 / 4096 * 0.1 * Math.PI;

    public double getEncoderMeters() {
        return encoder.get() * kEncoderTick2Meter;
    }

    public ShooterSubsystem() {

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter encoder value", getEncoderMeters());
    }

    public void setMotor(double speed) {
        shooter1Spark.set(speed);
        shooter2Spark.set(speed);
    }
}