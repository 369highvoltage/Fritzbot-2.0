/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
//this command enaables the feeder and then the shooter in order to shoot them lemons, aim first
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Talon; //Talon SP
import com.ctre.phoenix.motorcontrol.can.*; //Talon FX
import com.ctre.phoenix.motorcontrol.NeutralMode; //Neutral mode for the Falcons
import edu.wpi.first.wpilibj.Timer;



public class ShootingCommand extends CommandBase {
  Talon m_feeder;
  WPI_TalonFX m_shooterL;
  WPI_TalonFX m_shooterR;
  Timer timer;

  public ShootingCommand() {
   m_feeder = new Talon(5);
   m_shooterL = new WPI_TalonFX(1);
   m_shooterR = new WPI_TalonFX(2);
   m_shooterL.setNeutralMode(NeutralMode.Brake);
   m_shooterR.setNeutralMode(NeutralMode.Brake);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    timer.start();
    m_shooterL.set(-0.75);
    m_shooterR.set(0.75);
    //set shooter motor to desired max

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
   if(timer.get() >= 2){
    m_shooterL.set(-0.75);
    m_shooterR.set(0.75);
    m_feeder.set(-0.75);}
    


    //continue setting shooter motors to max
    //set feeder motors to max
  }


  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    //set all 3 motors to zero
    m_shooterL.set(0.0);
    m_shooterR.set(0.0);
    m_feeder.set(0.0);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return timer.get() == 5;
  }

}
