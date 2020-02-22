/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
    //DriveTrain
  public static final int DRIVETRAIN_LEFT_FRONT_CanVICTORSPX = 0;
  public static final int DRIVETRAIN_LEFT_BACK_CanVICTORSPX = 1;
  public static final int DRIVETRAIN_RIGHT_FRONT_CanVICTORSPX = 2;
  public static final int DRIVETRAIN_RIGHT_BACK_CanVICTORSPX = 3;

    //Intake
  public static final int Intake_Motor_CanVictorSPX = 4;

    //Flap
  public static final int Flap_Motor_CanVictorSPX = 6;

// Winch
public static final int Lil_Winch_CanVictorSPX = 7;
public static final int Big_Winch_CanVictorSPX = 5;

    // Limit switchs for lil winch
  public static final int LIMIT_SWITCH_TOP = 1;
  public static final int LIMIT_SWITCH_BOTTOM = 0 ;

  // limit switchs for big winch 
   public static final int LIMIT_SWITCH_BIG_WINCH_TOP = 2;

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

// set the joystick value to the port number the joystick uses on the 
  // laptop (this can be found in the Driverstation software):
  public static final int OI_OPERATOR = 2;
  public static final int OI_DRIVER_CONTROLLER = 0;
  public static final int OI_DRIVER_CONTROLLER2 = 1;
 

  
  public static final int DRIVER_CONTROLLER_MOVE_AXIS = 1;
  public static final int DRIVER_CONTROLLER_ROTATE_AXIS = 4;
  public static final int DRIVER_CONTROLLER_CLOCKWISE = 2;
  public static final int DRIVER_CONTROLLER_COUNTERCLOCKWISE = 3;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //prelim maps for joystick
  //public static final int JOYSTICK_MOVE_AXIS = 1;
  //public static final int JOYSTICK_ROTATE_AXIS = 2;
  
}
