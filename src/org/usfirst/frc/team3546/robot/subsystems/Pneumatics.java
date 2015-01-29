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
    public static boolean TOTELIFTCYLINDEREXTENDED = true;
    public static boolean TOTELIFTCYLINDERRETRACTED = false;
    Solenoid ToteLiftCylinder;

    public void initDefaultCommand() {
        ToteLiftCylinder = new Solenoid(RobotMap.ToteLiftCylinderPCMPort);
        setToteLiftCylinderPos(TOTELIFTCYLINDERRETRACTED);
    }
    
    /**
     * Get the position of the ToteLift cylinder
     * @return the position of the ToteLift cylinder
     */
    public boolean getToteLiftCylinderPos(){
    	return ToteLiftCylinder.get();
    }
    
    /**
     * Sets the position of the ToteLift cylinder
     * @param position The new position of the cylinder
     */
    public void setToteLiftCylinderPos(boolean position){
    	ToteLiftCylinder.set(position);
    }
    
    /**
     * Toggles the position of the ToteLiift cylinder
     */
    public void toggleToteLiftCylinder(){
    	if (getToteLiftCylinderPos() == TOTELIFTCYLINDEREXTENDED){
    		setToteLiftCylinderPos(TOTELIFTCYLINDERRETRACTED);
    	} else if (getToteLiftCylinderPos() == TOTELIFTCYLINDERRETRACTED){
    		setToteLiftCylinderPos(TOTELIFTCYLINDEREXTENDED);
    	}
    }
}

