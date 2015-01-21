package org.usfirst.frc.team3546.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Contains the single cylinder present on plasticbot
 */
public class Pneumatics extends Subsystem {
    
    Solenoid jankyCylinder;

    public void initDefaultCommand() {
        jankyCylinder = new Solenoid();
    }
}

