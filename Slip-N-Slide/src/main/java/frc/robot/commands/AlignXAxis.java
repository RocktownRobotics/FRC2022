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

public class AlignXAxis extends CommandBase {
  private double offset;
  private boolean isTarget=false;
  /**
   * Creates a new AlignXAxis.
   */
  public AlignXAxis() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_driveTrain);
    addRequirements(Robot.m_limeLight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // while(notDone);
    Robot.m_limeLight.lightOn();
    
    isTarget=Robot.m_limeLight.targetInSight();
    SmartDashboard.putNumber("Offset", offset);
    if(isTarget){
      offset = Robot.m_limeLight.getXOffset();
      if(offset<-Constants.SHOOTER_X_OFFSET){
        Robot.m_driveTrain.setLeftMotors(-Constants.X_ALIGN_MOTOR_SPEED);
      }
      if(offset>Constants.SHOOTER_X_OFFSET){
        Robot.m_driveTrain.setRightMotors(-Constants.X_ALIGN_MOTOR_SPEED);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_driveTrain.setBothMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    boolean state = (offset>-Constants.SHOOTER_X_OFFSET)&&(offset<Constants.SHOOTER_X_OFFSET);
    return state;
  }
}
