package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;
import org.usfirst.frc.team3546.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains all of the hardware required to drive the robot
 */

public class DriveBase extends Subsystem {
	private Talon frontLeft, frontRight, backLeft, backRight;
	private RobotDrive mainDrive;
	private Gyro robotOrientationGyro;
	private boolean drivingCentricity;
	private boolean drivingOreintation; // Stores the current orientation of the drive train. Normal/Reversed
	
	public static boolean NORMALDRIVE = true; // Used to denote a reversed orientation
	public static boolean REVERSEDDRIVE = false; // Used to denote a standard orientation
	
	public static boolean FIELDCENTRIC = true; //Used to denote field centered driving
	public static boolean ROBOTCENTRIC = false; //Used to denote robot centered driving

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
        drivingOreintation = NORMALDRIVE;
        drivingCentricity = ROBOTCENTRIC;
        
        frontLeft = new Talon(RobotMap.frontLeftMotorPWM);
		frontRight = new Talon(RobotMap.frontRightMotorPWM);
		backLeft = new Talon(RobotMap.backLeftMotorPWM);
		backRight = new Talon(RobotMap.backRightMotorPWM);
		
		
		
		mainDrive = new RobotDrive(frontLeft, backLeft, backRight, frontRight);
		
		robotOrientationGyro = new Gyro(RobotMap.orientationGyroAnlgIn);
		robotOrientationGyro.initGyro();
    }
    
    public void setDrivingOreintation(boolean newOreintation){
    	drivingOreintation = newOreintation;
    }
    
    public boolean getDrivingOreintation(){
    	return drivingOreintation;
    }
    
    public void setCentricity(boolean newCentricity){
    	drivingCentricity = newCentricity;
    }
    
    public boolean getCentricity(){
    	return drivingCentricity;
    }
    
    public void takeJoystickInputs(Joystick left, Joystick right){
    	double horizontalDriveInput = left.getAxis(AxisType.kX);
    	double verticalDriveInput = left.getAxis(AxisType.kY);
    	double rotationalDriveInput = left.getAxis(AxisType.kThrottle);
    	
    	rotationalDriveInput = rotationalDriveInput * -1;
    	horizontalDriveInput= horizontalDriveInput * -1;
    	
    	if (drivingOreintation == REVERSEDDRIVE) {
    		horizontalDriveInput = -1 * horizontalDriveInput;
    		verticalDriveInput = -1 * verticalDriveInput;
    	}
    	
    	mainDrive.mecanumDrive_Cartesian(
    			horizontalDriveInput, 
    			rotationalDriveInput,
    			verticalDriveInput,  
    			getRobotAngle()
    			);
    }
    
    public double getRobotAngle() {
    	if (getCentricity() == FIELDCENTRIC) {
    		return robotOrientationGyro.getAngle();
    	} else {
    		return 0; //Processed as if there's no gyro
    	}
    	
    }
    
    public void stop() {
        mainDrive.drive(0,0);
    }
}

