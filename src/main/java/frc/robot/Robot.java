// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.trajectory.ExponentialProfile.Constraints;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.Constants.OIConstants;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    // SmartDashboard.putNumber("encoder value", rightencoder.get() * kDriveTick2Feet);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    // rightencoder.reset();
    // errorSum = 0;
    // lastError = 0;
    // lastTimestamp = Timer.getFPGATimestamp();
  }

  // final double kP = 0.5;
  // final double kI = 0.5;
  // final double kD = 0.1;
  // final double iLimit = 1;

  // double setpoint = 0;
  // double errorSum = 0;
  // double lastTimestamp = 0;
  // double lastError = 0;

  @Override
  public void autonomousPeriodic() {
    // if (joy1.getRawButton(1)) {
    //   setpoint = 10;
    // } else if (joy1.getRawButton(2)) {
    //   setpoint = 0;
    // }
    
    // double sensorPosition = rightencoder.get() * kDriveTick2Feet;
    
    // double error = setpoint = sensorPosition;
    // double dt = Timer.getFPGATimestamp() - lastTimestamp;

    // if (Math.abs(error) < iLimit) {
    //   errorSum += error * dt;
    // } 
    
    // double errorRate = (error - lastError) / dt;
    
    // double outputSpeed = kP * error + kI * errorSum + kD * errorRate;

    // frontLeftMotor.set(outputSpeed);
    // rearLeftMotor.set(outputSpeed);
    // frontRightMotor.set(-outputSpeed);
    // rearRightMotor.set(-outputSpeed);

    // //update variables
    // lastTimestamp = Timer.getFPGATimestamp();
    // lastError = error;
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    // double speed = -joy1.getRawAxis(1) * 0.6;
    // double turn = joy1.getRawAxis(4) * 0.3;

    // double left = speed + turn;
    // double right = speed - turn;
    
    // boolean open = true;
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
