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

public class SpinSpinner extends CommandBase {
  /**
   * Creates a new AutonomousIndexer.
   */
  int indexCounter = 0;
  boolean isActivated = false;
  int revTime=Constants.INDEX_COMMAND_REV_TIME;
  int spinTime = Constants.INDEX_COMMAND_SPIN_TIME;
  int cycleTime = revTime+spinTime;
  int shot=0;
  public SpinSpinner() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_spinner);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    indexCounter=0;
    shot=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.m_oi.isButtonPressed(PortMap.XBOX_BY, false)){
      isActivated=!isActivated;
      indexCounter=0;
      shot=0;

    }
    if(isActivated){
      if(indexCounter>cycleTime*shot){
        Robot.m_spinner.engageSpinner();
      }
      if(indexCounter>cycleTime*shot+spinTime){
        Robot.m_spinner.disengageSpinner();
        shot++;
      }
      if(shot==5){
        isActivated=false;
        shot=0;
        indexCounter=0;
      }
      indexCounter++;
    }
    SmartDashboard.putBoolean("Spinner_Engaged", isActivated);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
