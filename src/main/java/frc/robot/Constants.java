package frc.robot;

public class Constants {
    public static final class DriveConstants {
        public static int kRightFrontMotorID = 0;
        public static int kLeftFrontMotorID = 1;
        public static int kRightRearMotorID = 2;
        public static int kLeftRearMotorID = 3;

        public static int kleftEncoderlA = 0;
        public static int kleftEncoderlB = 1;
        public static int krightEncoderlA = 2;
        public static int krightEncoderlB = 3;
        public static double kEncoderTick2Meters = 1.0 / 4096 * 0.128 * Math.PI;

        public static double kAutoDriveForwardSpeed = 0.5;
        public static double kAutoDriveForwardTurn = 1.5;
    }
    
    public static final class ShooterConstants {
        public static int kShooter1 = 1;
        public static int kShooter2 = 2;
        public static int kShooterEncoderlA = 4;
        public static int kShooterEncoderlB = 5;
        public static double kEncoderTick2Meters = 1.0 / 4096 * 0.128 * Math.PI;
        public static double kP = 3;
        public static double kI = 0;
        public static double kD = 0.8;
    }

    public static final class IntakeConstants {
        public static int kLeftMotorPort = 3;
        public static int kRightMotorPort = 4;

        public static int kEncoderlA = 6;
        public static int kEncoderlB = 7;

        public static double kOpenSpeed = -1;
        public static double kCloseSpeed = 1;
    }

    public static final class OIConstants {
        public static final int kJoystickPort = 0;

        public static final int kArcadeDriveSpeedAxis = 1;
        public static final int kArcadeDriveTurnAxis = 3;

        public static final int kShootOutakeButton = 1;
        public static final int kShootIntakeButton = 2;
        public static final int kIntakeOpenButton = 3;
        public static final int kIntakeCloseButton = 4;
    }
}
