/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PortMap;
import frc.robot.Robot;

public class RevShooter extends CommandBase {
  int counter = 0;
  boolean inFullPower=true;
  boolean shooterActivated=false;
  /**
   * Creates a new RevShooter.
   */
  public RevShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {


  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.m_oi.isButtonPressed(PortMap.XBOX_BX, false)){
      shooterActivated=true;
    }
    if(Robot.m_oi.isButtonReleased(PortMap.XBOX_BX, false)){
      shooterActivated=false;
    }
    if(shooterActivated){
      Robot.m_shooter.pidControl();
    }else{
      end(false);
    }

/*
    if(Robot.m_oi.isButtonPressed(Constants.XBOX_BX, false)){
      SmartDashboard.putNumber("Shooter RPM", Shooter.getRPM());

      if(Shooter.getRPM()<Constants.OPTIMUMRPM){
        inFullPower=true;
        Robot.m_shooter.ShooterSpeed(Constants.SHOOTER_SPEED);
        SmartDashboard.putNumber("ShooterPower", 1);
        SmartDashboard.putBoolean("InFullPower", inFullPower);
      }
      if(Shooter.getRPM()>=Constants.OPTIMUMRPM){
        inFullPower=false;
        Robot.m_shooter.ShooterSpeed(Constants.SHOOTER_SPEED);
        SmartDashboard.putNumber("Shooterpower", Constants.SHOOTER_SPEED);
        SmartDashboard.putBoolean("InFullPower", inFullPower);
      }
    }
    if(Robot.m_oi.isButtonReleased(Constants.XBOX_BX, false)){
      end(true);
    }
    */

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.shooterSpeed(0);
    SmartDashboard.putNumber("Shooter%", 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
     return false;
  }

//PID stuff





}

