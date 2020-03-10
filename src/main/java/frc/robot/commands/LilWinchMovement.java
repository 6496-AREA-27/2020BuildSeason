/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LilWinchMovement extends Command {
  public LilWinchMovement() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_lilwinch);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_lilwinch.initializeCounter();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rightTriggerSpeed = Robot.m_oi.Operator.getRawAxis(RobotMap.DRIVER_CONTROLLER_COUNTERCLOCKWISE);
    double leftTriggerSpeed = Robot.m_oi.Operator.getRawAxis(RobotMap.DRIVER_CONTROLLER_CLOCKWISE);
    rightTriggerSpeed = rightTriggerSpeed*0.5;
    leftTriggerSpeed = leftTriggerSpeed*0.5; //for kaiz :)

    if (-rightTriggerSpeed < 0) {
      System.out.println("" + rightTriggerSpeed + " " + leftTriggerSpeed);
    }
   // Robot.m_spinmotor.Spin(leftTriggerSpeed - rightTriggerSpeed);
/*if (leftTriggerSpeed >0 && -rightTriggerSpeed > 0) {
  Robot.m_spinmotor.Spin(0);
}*/
    
    if (!(Robot.m_lilwinch.isTopSwitchSet()) && !(Robot.m_lilwinch.isBottomSwitchSet())) {
      // Robot.m_spinmotor.Spin(0);
      Robot.m_lilwinch.Spin(leftTriggerSpeed - rightTriggerSpeed);
    }
    else if ((Robot.m_lilwinch.isTopSwitchSet() && !(Robot.m_lilwinch.isBottomSwitchSet()))) {
      // Robot.m_spinmotor.Spin(0);
      leftTriggerSpeed = 0;
      Robot.m_lilwinch.Spin(-rightTriggerSpeed);
    }
    else if ((!(Robot.m_lilwinch.isTopSwitchSet()) && Robot.m_lilwinch.isBottomSwitchSet())) {
      rightTriggerSpeed = 0;
      Robot.m_lilwinch.Spin(leftTriggerSpeed);
    }  
    else {
      Robot.m_lilwinch.Spin(0);
      return;
    }
    /*if (!(Robot.m_lilwinch.isTopSwitchSet())){
  
      Robot.m_lilwinch.Spin(0.1);
    }
    */Robot.m_lilwinch.Spin(leftTriggerSpeed - rightTriggerSpeed); 

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_lilwinch.Spin(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
