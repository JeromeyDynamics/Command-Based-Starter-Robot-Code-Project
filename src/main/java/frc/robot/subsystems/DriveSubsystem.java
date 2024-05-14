package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;

public class DriveSubsystem extends SubsystemBase {
    
    private Spark frontRightMotor = new Spark(DriveConstants.kRightFrontMotorID);
    private Spark frontLeftMotor = new Spark(DriveConstants.kLeftFrontMotorID);
    private Spark rearRightMotor = new Spark(DriveConstants.kRightRearMotorID);
    private Spark rearLeftMotor = new Spark(DriveConstants.kLeftRearMotorID);

    private Joystick joy1 = new Joystick(OIConstants.kJoystickPort);
    private Encoder leftencoder = new Encoder(DriveConstants.kleftEncoderlA, DriveConstants.kleftEncoderlB);
    private Encoder rightencoder = new Encoder(DriveConstants.krightEncoderlA, DriveConstants.krightEncoderlB);

    private final double kDriveTick2Feet = 1.0 / 128 * 6 * Math.PI / 12;

    public double getEncoderMeters() {
        return (leftencoder.get() * -rightencoder.get()) / 2 * kDriveTick2Feet;
    }
    
    public DriveSubsystem() {
        
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Drive encoder value", getEncoderMeters());
    }

    public void setMotors(double left, double right) {
        frontLeftMotor.set(left);
        rearLeftMotor.set(left);
        frontRightMotor.set(-right);
        rearRightMotor.set(-right);
    }
}
