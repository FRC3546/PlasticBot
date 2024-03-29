
package org.usfirst.frc.team3546.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team3546.robot.commands.DashBoardCommunication;
import org.usfirst.frc.team3546.robot.subsystems.DriveBase;
import org.usfirst.frc.team3546.robot.subsystems.PowerDistribution;
import org.usfirst.frc.team3546.robot.subsystems.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory. 
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static DriveBase driveTrain;
	public static PowerDistribution PD;
	public static Pneumatics airSystem;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		driveTrain = new DriveBase();
		PD = new PowerDistribution();
		
		System.out.println("Robot intializing");
		
		//Start communication with the SmartDashboard
		DashBoardCommunication dash = new DashBoardCommunication();
		dash.setRunWhenDisabled(true);
		dash.start();

		airSystem = new Pneumatics();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	System.out.println("Teleop intializing");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
