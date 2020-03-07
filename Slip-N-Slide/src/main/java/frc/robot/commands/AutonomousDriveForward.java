/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonomousDriveForward extends CommandBase {
  private int time = 0;
  /**
   * Creates a new AutonomousDriveForward.
   */
  public AutonomousDriveForward() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Robot.m_limeLight.lightOff();
    Robot.m_spinner.disengageSpinner();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    time++;
    Robot.m_driveTrain.setBothMotors(-.60);
    if(time>450){
      end(true);
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

    return time>50;
  }
}
