// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OIConstants;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DriveForwardCmd;
import frc.robot.commands.IntakeSetCmd;
import frc.robot.commands.ShooterJoystickCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  private final Joystick joy1 = new Joystick(OIConstants.kJoystickPort);

  public RobotContainer() {
    
    driveSubsystem.setDefaultCommand(
      new ArcadeDriveCmd(driveSubsystem, () -> -joy1.getRawAxis(1), () -> joy1.getRawAxis(3)
    ));
    shooterSubsystem.setDefaultCommand(new ShooterJoystickCmd(shooterSubsystem, 0));
    intakeSubsystem.setDefaultCommand(new IntakeSetCmd(intakeSubsystem, true));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(joy1, OIConstants.kShootOutakeButton).whileTrue(new ShooterJoystickCmd(shooterSubsystem, 0.5));
    new JoystickButton(joy1, OIConstants.kShootIntakeButton).whileTrue(new ShooterJoystickCmd(shooterSubsystem, -0.5));
    new JoystickButton(joy1, OIConstants.kIntakeOpenButton).whileTrue(new IntakeSetCmd(intakeSubsystem, true));
    new JoystickButton(joy1, OIConstants.kIntakeCloseButton).whileTrue(new IntakeSetCmd(intakeSubsystem, false));
  }

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new DriveForwardCmd(driveSubsystem, 1.5),
      new IntakeSetCmd(intakeSubsystem, false)
    );
  }
}
