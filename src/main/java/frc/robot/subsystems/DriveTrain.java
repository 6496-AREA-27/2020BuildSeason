/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;




/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //PWMVictorSPX leftController = null;
 // PWMVictorSPX rightController = null;
  WPI_VictorSPX FrontLeftController = null;
  WPI_VictorSPX FrontRightController = null;
  WPI_VictorSPX BackLeftController = null;
  WPI_VictorSPX BackRightController = null;


  DifferentialDrive differentialDrive = null;

 public DriveTrain() {
    // use following 2 lines for new robot:
    FrontLeftController = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_CanVICTORSPX); // port numbers defined in RobotMap
    FrontRightController = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_CanVICTORSPX);
    BackLeftController = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_CanVICTORSPX);
    BackRightController = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_CanVICTORSPX);

    FrontLeftController.follow(BackLeftController);
    FrontRightController.follow(BackRightController);

    differentialDrive = new DifferentialDrive(BackLeftController, BackRightController);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
