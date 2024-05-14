package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends SubsystemBase {
    private final Spark intakeLeftMotor = new Spark(IntakeConstants.kLeftMotorPort);
    private final Spark intakeRightMotor = new Spark(IntakeConstants.kRightMotorPort);
    private final Encoder encoder = new Encoder(IntakeConstants.kEncoderlA, IntakeConstants.kEncoderlA);
    private final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.1 * Math.PI;

    public double getEncoderMeters() {
        return encoder.get() * kEncoderTick2Meter;
    }
    
    public IntakeSubsystem() {

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake encode value", getEncoderMeters());
    }

    public void setMotor(double speed) {
        intakeLeftMotor.set(speed);
        intakeRightMotor.set(-speed);
    }

    public void setPosition(boolean open) {
        if (open) {
            intakeLeftMotor.set(-1);
            intakeRightMotor.set(-1);
        } else {
            intakeLeftMotor.set(1);
            intakeRightMotor.set(1);
        }
    }
}
