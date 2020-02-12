/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ProximitySensor {
  // A MB1013 distance sensor - http://www.maxbotix.com/documents/HRLV-MaxSonar-EZ_Datasheet.pdf
  // (pins 3, 6 and 7 from sensor to analog input 0)
  private static final AnalogInput mb1013 = new AnalogInput(0);
  
  // TODO - You will need to determine how to convert voltage to distance
  // (use information from the data sheet, or your own measurements)
  private static final double VOLTS_TO_DIST = 1.0;

  public static double getVoltage() {
    return mb1013.getVoltage();
  }
  
  public static double getDistance() {
      System.out.println(getVoltage() * VOLTS_TO_DIST);
    return getVoltage() * VOLTS_TO_DIST;
  }
  
  public static void updateDashboard() {
    SmartDashboard.putNumber("Distance (volts)", getVoltage());
    SmartDashboard.putNumber("Distance (real)", getDistance());
  }
}
