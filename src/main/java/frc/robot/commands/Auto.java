/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
public class Auto extends Command {
  protected double power;
  protected double time;
  protected long endTime;

  public Auto(double power, double timeInMillis) {
      this.power = power;
      this.time = timeInMillis;
      requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
      long startTime = System.currentTimeMillis();
      endTime = (long) (startTime + this.time);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
      Robot.m_drivetrain.arcadeDrive(power, 0);
      //Robot.m_intake.Speed(1);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
      return System.currentTimeMillis() >= endTime;
  }

  // Called once after isFinished returns true
  protected void end() {
      Robot.m_drivetrain.arcadeDrive(0, 0);

  }

  protected void interrupted() {
      end();
  }
}