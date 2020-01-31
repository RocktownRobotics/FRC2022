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

public class SwitchGear extends CommandBase {
  /**
   * Creates a new SwitchGear.
   */
  public SwitchGear() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_gearBox);
  }
  private boolean gearState = false;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.gearState=false;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Robot.m_oi.isButtonPressed(Constants.XBOX_BX)){
      Robot.m_gearBox.changeGear(!gearState);
      gearState=!gearState;
    }
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
