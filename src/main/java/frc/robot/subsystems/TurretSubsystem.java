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
// import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.Talon;


public class TurretSubsystem extends SubsystemBase {
  WPI_TalonSRX m_turret;
  // WPI_TalonFX m_shooterL;
  // WPI_TalonFX m_shooterR;
  boolean _brake = true;
  // Talon m_feeder;
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
    
    // m_shooterL = new WPI_TalonFX(1);
    // m_shooterR = new WPI_TalonFX(2);
    m_turret = new WPI_TalonSRX(0);
    // m_feeder = new Talon(5);
    m_turret.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    // m_shooterL.setNeutralMode(NeutralMode.Brake);
    // m_shooterR.setNeutralMode(NeutralMode.Brake);
    
  }

  public void resetEncoder() {
    // e_turret.setAccumulatorInitialValue(e_turret.getValue());
  }

 // -1 ... 1
  public void setTurretSpeed(double speed){ //sets and regulates turret speed
    if (speed > 1) {
      speed = 1;
    }
    else if (speed < -1) {
      speed = -1;
    }
    m_turret.set(speed*0.25); //might be a little too fast
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

  // public void shooter(double speed){
  //   if (speed == 0.0){
  //     m_shooterL.set(0.0);
  //     m_shooterR.set(0.0);
  //   }
  //   else{
  //     m_shooterL.set(-speed*0.75);
  //     m_shooterR.set(speed*0.75);
  //   }

  // }

  public double encoderVal(){ //gets the value of the turret magnetic encoder
    double position = m_turret.getSelectedSensorPosition(0);
    System.out.println("encoder position " + position);
    return position;
  }



  // public void feeder(boolean speed){
  //   if(speed){
  //     m_feeder.set(-0.75);}
  //     else {
  //       m_feeder.set(0.0);
  //     }

  // }

  




  // public void feeder(double speed){
  //   m_feeder.set(speed);
  // }


}
