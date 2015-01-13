package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */

public class DriveBase extends Subsystem {
	public Talon frontLeft, frontRight, backLeft, backRight;
	public static RobotDrive mainDrive;

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
        
        frontLeft = new Talon(0);
		frontRight = new Talon(1);
		backLeft = new Talon(2);
		backRight = new Talon(3);
		mainDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    }
    
    public void takeJoystickInputs(Joystick left, Joystick right){
    	mainDrive.mecanumDrive_Polar(
    			left.getAxis(AxisType.kX), 
    			left.getAxis(AxisType.kY), 
    			right.getAxis(AxisType.kY));
    }
    
    public void stop() {
        mainDrive.drive(0,0);
    }
}

