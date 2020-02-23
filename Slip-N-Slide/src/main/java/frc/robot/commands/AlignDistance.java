/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AlignDistance extends CommandBase {
  private double distance;
  private double minDistance = Constants.SHOOTING_DISTANCE-Constants.SHOOTING_BUFFER;
  private double maxDistance = Constants.SHOOTING_DISTANCE+Constants.SHOOTING_BUFFER;
  /**
   * Creates a new AlignDistance.
   */
  public AlignDistance() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_limeLight);
    addRequirements(Robot.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    distance = Robot.m_limeLight.getDistance();
    if(distance<minDistance){
      Robot.m_driveTrain.setBothMotors(-Constants.DISTANCE_ALIGNMENT_SPEED);
    }
    if(distance>minDistance){
      Robot.m_driveTrain.setBothMotors(Constants.DISTANCE_ALIGNMENT_SPEED);
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
    boolean state = (distance>minDistance&&distance<maxDistance);
    return state;
  }
}
