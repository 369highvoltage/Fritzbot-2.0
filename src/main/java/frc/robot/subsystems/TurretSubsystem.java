/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.OI;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import com.revrobotics.*;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


public class TurretSubsystem extends SubsystemBase {
  WPI_TalonSRX m_turret;
  SpeedController m_shooterL;
  SpeedController m_shooterR;
  // public AnalogInput e_turret;
   // public Encoder e_turret;
  // public Talon m_feeder;
  double turretVal;
  double angle;
  private NetworkTable table;
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {    
    // e_turret = new AnalogInput(0);
    table = NetworkTableInstance.getDefault().getTable("turret");
    //e_turret = new AnalogEncoder(new AnalogInput(0));
    // e_turret.setDistancePerRotation(360/5);
    
    // m_feeder = new Talon(5);
    m_shooterL = new WPI_TalonFX(1);
    m_shooterR = new WPI_TalonFX(2);
    m_turret = new WPI_TalonSRX(0);
    m_turret.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  }

  public void resetEncoder() {
    // e_turret.setAccumulatorInitialValue(e_turret.getValue());
  }

 // -1 ... 1
  public void setTurretSpeed(double speed){
    if (speed > 1) {
      speed = 1;
    }
    else if (speed < -1) {
      speed = -1;
    }
    m_turret.set(speed);
  }

    public double getEncoderVal(){
    // turretVal = e_turret.getValue();
    // turretVal = turretVal - 425;
    
    return 0;
  }

  public void debug() {
    table.getEntry("turret_angle").setNumber(getEncoderVal());
    // table.getEntry("raw_turret_angle").setNumber(e_turret.getValue());
  }

  public void shooter(double speed){
    m_shooterL.set(-speed);
    m_shooterR.set(speed);

  }

  public void encoderVal(){
    double position = m_turret.getSelectedSensorPosition(0);
    System.out.println("encoder position " + position);
  }

  




  // public void feeder(double speed){
  //   m_feeder.set(speed);
  // }


}
