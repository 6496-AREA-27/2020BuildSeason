/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.command.Command;

public class FlapMovementBack extends Command {
  private double power;

  public FlapMovementBack() {
    this(-1.0, 0.0);
  }
  
  public FlapMovementBack(double power, double timeoutInSecs) {
    this.power = power;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_flap);
    if (timeoutInSecs > 0) {
      setTimeout(timeoutInSecs);
    }
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_flap.Turn(power);
    
    // if ((Robot.m_flap.isFlapBottomSwitchSet()) && (power < 0)) {
    
    //   Robot.m_flap.Turn(0.0);
    // } else if ((Robot.m_flap.isFlapTopSwitchSet()) && (power > 0)) {
    //   Robot.m_flap.Turn(0.0);
    // } else {
    //   Robot.m_flap.Turn(power);
    // }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_flap.isFlapBottomSwitchSet();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_flap.Turn(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
