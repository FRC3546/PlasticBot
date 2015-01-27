package org.usfirst.frc.team3546.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
	
	//Pwm out
    public static int frontLeftMotorPWM = 0;
    public static int frontRightMotorPWM = 1;
    public static int backLeftMotorPWM = 2;
    public static int backRightMotorPWM = 3;
    
    
    //Analog in
    public static int orientationGyroAnlgIn = 0;
    
    //Camera
    public static String cameraName = "cam0";
    
    //PCM
    public static int ToteLiftCylinderPCMPort = 0;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
