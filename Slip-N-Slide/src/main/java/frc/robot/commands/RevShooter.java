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
import frc.robot.PortMap;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class RevShooter extends CommandBase {

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
  public void initialize(){

  }
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("ShooterActivated", shooterActivated);
    Robot.m_shooter.setRPM();
    if(Robot.m_oi.isButtonPressed(PortMap.XBOX_BX, false)){
      shooterActivated=!shooterActivated;
      Robot.m_shooter.changeRunning();
    }
     if(shooterActivated){
       //Robot.m_shooter.pidControl();
       Robot.m_shooter.shooterSpeed(.3);
    
    }else{
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_shooter.shooterSpeed(0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
     return false;
  }






}

