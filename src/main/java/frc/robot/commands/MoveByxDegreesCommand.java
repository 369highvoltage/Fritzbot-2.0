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
  double encoderValInit;
  double desiredAngle;


  public MoveByxDegreesCommand(TurretSubsystem subsystem, double angle) {
    turret_subsystem = subsystem;
    addRequirements(turret_subsystem);
    desiredAngle = angle;
 
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    encoderValInit = turret_subsystem.getEncoderVal();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if(desiredAngle>0){
      turret_subsystem.setTurretSpeed(1);
    }
    else if(desiredAngle<0){
      turret_subsystem.setTurretSpeed(-1);
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
    return (turret_subsystem.getEncoderVal() - desiredAngle >= encoderValInit);
  }


  
}
