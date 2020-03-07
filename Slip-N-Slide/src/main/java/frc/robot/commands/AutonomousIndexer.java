/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonomousIndexer extends CommandBase {
  /**
   * Creates a new AutonomousIndexer.
   */
  int indexCounter = 0;
  int shots;
  public AutonomousIndexer(int shots) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_spinner);
    this.shots=shots;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int startcounter = 400;
    int spinTime = 8;
    int revTime = 118;
    int cycleTime = spinTime+revTime;
    for(int i=0;i<shots;i++){
      if(indexCounter>startcounter
      +(i*cycleTime)){
        Robot.m_spinner.engageSpinner();
      }
      if(indexCounter>startcounter+(i*cycleTime)+spinTime){
        Robot.m_spinner.disengageSpinner();
      }
    }
    indexCounter++;

    // if(indexCounter>1200){
    //   Robot.m_spinner.disengageSpinner();
    // }
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
