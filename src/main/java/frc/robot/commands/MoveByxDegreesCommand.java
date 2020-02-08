/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class MoveByxDegreesCommand extends CommandBase {
  private final TurretSubsystem turret_subsystem;
  double encoderValInit; //intial enoder value
  double desiredAngle;  //stores the desired engle
  double currentAngle; //stores current encoder value


  public MoveByxDegreesCommand(TurretSubsystem subsystem, double angle) {
    turret_subsystem = subsystem;
    addRequirements(turret_subsystem);
    desiredAngle = angle;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    encoderValInit = turret_subsystem.encoderVal();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    currentAngle = turret_subsystem.encoderVal();

    if(currentAngle == desiredAngle){
      turret_subsystem.setTurretSpeed(0);
    }
    else if(currentAngle >= desiredAngle){
      turret_subsystem.setTurretSpeed(-1);
    }
    else if(currentAngle <= desiredAngle){
      turret_subsystem.setTurretSpeed(1);
    }
    
  }

  
  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    turret_subsystem.setTurretSpeed(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return (currentAngle == desiredAngle);
  }


  
}
