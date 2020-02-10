/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class RevShooter extends CommandBase {
  int counter = 0;
  boolean inFullPower=true;

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
    if(Robot.m_oi.isButtonPressed(Constants.XBOX_BX, false)){
      SmartDashboard.putNumber("Shooter RPM", Shooter.getRPM());
      double exponentNumerator=-(Shooter.getRPM()+Constants.OPTIMUMRPM);
      double exponent=exponentNumerator/Constants.RPMBUFFER;
      double denominator=1+Math.pow(Math.E, exponent);
      double sigmoidResult=(-1/denominator)+1;
      SmartDashboard.putNumber("Sigmoid Result", sigmoidResult);
      //double ShooterSpeed=sigmoidResult;

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
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.ShooterSpeed(0);
    SmartDashboard.putNumber("ShooterPower", 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
     return false;
  }

//PID stuff





}

