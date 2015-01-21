package org.usfirst.frc.team3546.robot.subsystems;

import org.usfirst.frc.team3546.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Contains the single cylinder present on plasticbot
 */
public class Pneumatics extends Subsystem {
    public static Value JANKYCYLINDEREXTENDED = Value.kForward;
    public static Value JANKYCYLINDERRETRACTED = Value.kReverse;
    DoubleSolenoid jankyCylinder;

    public void initDefaultCommand() {
        jankyCylinder = new DoubleSolenoid(
        		RobotMap.jankyCylinder[0],
        		RobotMap.jankyCylinder[1]
        		);
        setJankyCylinderPos(JANKYCYLINDERRETRACTED);
    }
    
    /**
     * Get the position of the janky cylinder
     * @return the position of the janky cylinder
     */
    public Value getJankyCylinderPos(){
    	return jankyCylinder.get();
    }
    
    /**
     * Sets the position of the janky cylinder
     * @param position The new position of the cylinder
     */
    public void setJankyCylinderPos(Value position){
    	jankyCylinder.set(position);
    }
    
    /**
     * Toggles the position of the janky cylinder
     */
    public void toggleJankyCylinder(){
    	if (getJankyCylinderPos() == JANKYCYLINDEREXTENDED){
    		setJankyCylinderPos(JANKYCYLINDERRETRACTED);
    	} else if (getJankyCylinderPos() == JANKYCYLINDERRETRACTED){
    		setJankyCylinderPos(JANKYCYLINDEREXTENDED);
    	}
    }
}

