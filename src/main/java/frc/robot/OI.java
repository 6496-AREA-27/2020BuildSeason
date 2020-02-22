/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeOuttake;
import frc.robot.commands.OutTake;
import frc.robot.commands.FlapMovement;
import frc.robot.commands.FlapMovementBack;
import frc.robot.commands.BigWinchMovement;
//import frc.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick Operator = new Joystick(RobotMap.OI_OPERATOR);
 // public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
 // public Joystick driverController2 = new Joystick(RobotMap.OI_DRIVER_CONTROLLER2);
  public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  public Joystick driverController2 = new Joystick(RobotMap.OI_DRIVER_CONTROLLER2);
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  Button D1 = new JoystickButton(Operator, 1);
  Button D2 = new JoystickButton(Operator, 2);
  Button D3 = new JoystickButton(Operator, 3);
  Button D4 = new JoystickButton(Operator, 4);
  Button D5 = new JoystickButton(Operator, 5);
  Button D6 = new JoystickButton(Operator, 6); 
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
public OI(){
  D3.whileHeld(new BigWinchMovement());
  D1.whileHeld(new IntakeOuttake());
  D2.whileHeld(new OutTake());
  D5.whileHeld(new FlapMovement());
  D6.whileHeld(new FlapMovementBack());
  
}
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
