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

public class CheesyDrive extends CommandBase {
  /**
   * Creates a new CheesyDrive.
   */
  public CheesyDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.m_driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStickX = Robot.m_oi.GetDriverRawAxis(Constants.XBOX_LS_X);
    double rightStickY = -Robot.m_oi.GetDriverRawAxis(Constants.XBOX_RS_Y);

    double power = rightStickY;
    double turningFactor = leftStickX;

    double leftMotorPower=1;
    double rightMotorPower=1;
  
    //If the controller wants to go a direction, it slows down that motor's side.

    if(turningFactor<0){
      leftMotorPower+=turningFactor;
    }else if(turningFactor>0){
      rightMotorPower-=turningFactor;
    }

    //Multiplies the motor power by the original power to scale the speed.
    leftMotorPower*=power;
    rightMotorPower*=power;

    if(leftMotorPower>1||leftMotorPower<-1||rightMotorPower>1||rightMotorPower<-1){
      leftMotorPower=0;
      rightMotorPower=0;
    }
        // Carlo's idea
    // leftMotorPower = leftstickX - rightstickY / 2
    // rightMotorPower = leftstickX + rightstickY / 2
    // leftMotorPower = leftMotorPower / Math.max(leftMotorPower, rightMotorPower)
    // rightMotorPower = rightMotorPower / Math.max(leftMotorPower, rightMotorPower)








    //Sets the motors to the speed
    Robot.m_driveTrain.setLeftMotors(leftMotorPower);
    Robot.m_driveTrain.setRightMotors(rightMotorPower);

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.m_driveTrain.setLeftMotors(0);
    Robot.m_driveTrain.setRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
