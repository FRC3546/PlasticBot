package org.usfirst.frc.team3546.robot;

import org.usfirst.frc.team3546.robot.commands.ToggleDrive;
import org.usfirst.frc.team3546.robot.commands.ToggleDrivingCentricity;
import org.usfirst.frc.team3546.robot.commands.TogggleToteLiftCylinder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Garrett's commit
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	public Joystick leftJoystick;
	public Joystick rightJoystick;
	public Button toggleDriveOreintationButton;
	public Button toggleToteliftButton;
	public Button toggleDrivingCentricityButton;
	
	public OI(){
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		
		toggleDriveOreintationButton = new JoystickButton(leftJoystick, 2);//2 is button #
		toggleDriveOreintationButton.whenPressed(new ToggleDrive());
		
		toggleToteliftButton = new JoystickButton(rightJoystick, 2);
		toggleToteliftButton.whenPressed(new TogggleToteLiftCylinder());
		
		toggleDrivingCentricityButton = new JoystickButton(leftJoystick, 4);
		toggleDrivingCentricityButton.whenPressed(new ToggleDrivingCentricity());
	}
	
	public double[] getJoysickAxisData(){
		double[] data = {
				leftJoystick.getAxis(AxisType.kX),
				leftJoystick.getAxis(AxisType.kY),
				leftJoystick.getAxis(AxisType.kZ),
				leftJoystick.getAxis(AxisType.kThrottle),
				rightJoystick.getAxis(AxisType.kX),
				rightJoystick.getAxis(AxisType.kY),
				rightJoystick.getAxis(AxisType.kZ),
				rightJoystick.getAxis(AxisType.kThrottle),
		};
		return data;
	}
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

