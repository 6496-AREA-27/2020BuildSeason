/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotMap;
import frc.robot.commands.BigWinchMovement;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;

/**
 * Add your docs here.
 */
public class BigWinch extends Subsystem {
  //DigitalInput BiglimitSwitch =  new DigitalInput(RobotMap.LIMIT_SWITCH_BIG_WINCH_TOP);
  WPI_VictorSPX BigWinchMotor = null;
  

public BigWinch() {
  BigWinchMotor = new WPI_VictorSPX(RobotMap.Big_Winch_CanVictorSPX);
}

//public boolean isBigLimitSwitchSet(){
  //boolean valueOfBigSwitch = BiglimitSwitch.get();
  //System.out.println("value of the Top limit switch "+valueOfBigSwitch);
  //return valueOfBigSwitch;
//}
public void TurnBigWinch(double SpinBigWinch){
  BigWinchMotor.set(SpinBigWinch);
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
   // setDefaultCommand(new BigWinchMovement());
  }
}
