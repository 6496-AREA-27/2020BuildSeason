/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX; 

/**
 * Add your docs here.
 */
public class Flap extends Subsystem {
  DigitalInput limitSwitchFlapTop =  new DigitalInput(RobotMap.LIMIT_SWITCH_FLAP_TOP);
  DigitalInput limitSwitchFlapBottom =  new DigitalInput(RobotMap.LIMIT_SWITCH_FLAP_BOTTOM);

  WPI_VictorSPX flapMotor = null;

  public Flap() {
    flapMotor = new WPI_VictorSPX(RobotMap.Flap_Motor_CanVictorSPX);
    //SmartDashboard.putData("Flap", this);
  }
  public boolean isFlapTopSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchFlapTop.get();
    //System.out.println("value of the Top limit switch for Flap "+valueOfSwitch);
    return valueOfSwitch;
}
public boolean isFlapBottomSwitchSet() {
    //int valueOfSwitch = counter.get();
    boolean valueOfSwitch = limitSwitchFlapBottom.get();
    //System.out.println("value of the Bottom limit switch for Flap "+valueOfSwitch);
    return valueOfSwitch;
}

  // Put methods for controlling this subsystem
    // here. Call these from Commands.
  public void Turn(double flapTurn){
    double power = flapTurn;
    if (isFlapBottomSwitchSet() && (power < 0)) {
      power = 0;
    } else if ((isFlapTopSwitchSet()) && (power > 0)) {
      power = 0;
    }
    flapMotor.set(power);
    }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("BottomSwitch", this.isFlapBottomSwitchSet());
    SmartDashboard.putNumber("FlapPower", flapMotor.get());
    SmartDashboard.putBoolean("TopSwitch", this.isFlapTopSwitchSet());
  }
}






/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/






  
  


