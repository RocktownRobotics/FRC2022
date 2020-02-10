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

public class ControlPneumatics extends CommandBase {
  /**
   * Creates a new ExtendPneumatic.
   */
  public ControlPneumatics() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_pneumatic);
  }

private boolean isDeployed;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.isDeployed = false;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

/*
        IMPORTANT: ADD A BINDING
        */
  //if(Robot.m_oi.isButtonPressed(,false));
    if(!isDeployed){
      SmartDashboard.putBoolean("Pneumatic deployed:", isDeployed);
      Robot.m_pneumatic.extendSolenoid();
      this.isDeployed=true;
    }else{
      SmartDashboard.putBoolean("Pneumatic deployed:", isDeployed);
      Robot.m_pneumatic.retractSolenoid();
      this.isDeployed=false;       
    }
  }
//}

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
