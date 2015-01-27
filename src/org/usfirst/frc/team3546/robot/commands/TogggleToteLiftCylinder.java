package org.usfirst.frc.team3546.robot.commands;

import org.usfirst.frc.team3546.robot.Robot;
import org.usfirst.frc.team3546.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles the position of the janky cylinder
 */
public class ToggleJankyCylinder extends Command {

    public ToggleJankyCylinder() {

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.airSystem.toggleJankyCylinder();
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    //These are here only to please the compiler...
    //If they have content in them, they should be moved to above
	protected void end() {}
	protected void execute() {}
	protected void interrupted() {	}
}