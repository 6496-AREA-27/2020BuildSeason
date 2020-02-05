/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;




/**
 * Add your docs here.
 */
public class Flap extends Subsystem {
  WPI_VictorSPX flapMotor = null;
  DigitalInput limitSwitchTop =  new DigitalInput(RobotMap.LIMIT_SWITCH_TOP);
  DigitalInput limitSwitchBottom =  new DigitalInput(RobotMap.LIMIT_SWITCH_BOTTOM);

  //Constructor for the flap object
public Flap(){
  flapMotor = new WPI_VictorSPX(RobotMap.Flap_Motor_CanVictorSPX);
}
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
public void Turn(double flapTurn){
  flapMotor.set(flapTurn);

  }
  
  //limit switchs
  public boolean isTopSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchTop.get();
    System.out.println("value of the Top limit switch "+valueOfSwitch);
    return valueOfSwitch;

  }
  //isbottomswichset
  public boolean isBottomSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchBottom.get();
    System.out.println("value of the Bottom limit switch "+valueOfSwitch);
    return valueOfSwitch;

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}


