/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.PortMap;
import frc.robot.Robot;
import frc.robot.subsystems.Pneumatic;

public class ColorWheelCommand extends CommandBase {
  boolean isNegative = false;
  /**
   * Creates a new ColorWheelCommand.
   */
  public ColorWheelCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_colorWheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Pneumatic.isDeployed()){
      double wheelSpeed = Robot.m_oi.GetDriverRawAxis(PortMap.XBOX_LS_X, false);
      if(wheelSpeed<0){
        isNegative = true;
      }else{
        isNegative = false;
      }
      wheelSpeed = wheelSpeed*wheelSpeed;
      if(isNegative){
        wheelSpeed=-wheelSpeed;
      }
      
      Robot.m_colorWheel.spinColorWheel(wheelSpeed);
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
