package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterJoystickCmd extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public ShooterJoystickCmd(ShooterSubsystem shooterSubsystem, double speed) {
        this.shooterSubsystem = shooterSubsystem;
        this.speed = speed;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("ShooterJoystickCmd initialized!");
    }

    @Override
    public void execute() {
        shooterSubsystem.setMotor(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setMotor(0);
        System.out.println("ShooterJoystickCmd ended!");
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
