/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LilWinchMovement;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class LilWinch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DigitalInput limitSwitchTop =  new DigitalInput(RobotMap.LIMIT_SWITCH_TOP);
  DigitalInput limitSwitchBottom =  new DigitalInput(RobotMap.LIMIT_SWITCH_BOTTOM);
  public WPI_VictorSPX LilWinchMotor = null;

  public LilWinch(){
    LilWinchMotor = new WPI_VictorSPX(RobotMap.Lil_Winch_CanVictorSPX);
  }
  public boolean isTopSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchTop.get();
    System.out.println("value of the Top limit switch "+valueOfSwitch);
    return valueOfSwitch;
}
public boolean isBottomSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchBottom.get();
    System.out.println("value of the Bottom limit switch for LilWinch "+valueOfSwitch);
    return valueOfSwitch;
}

public void initializeCounter() {
    //counter.reset();
}

public void Spin(double SpinValue){
    LilWinchMotor.set(ControlMode.PercentOutput, SpinValue);

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LilWinchMovement());
  }
}
