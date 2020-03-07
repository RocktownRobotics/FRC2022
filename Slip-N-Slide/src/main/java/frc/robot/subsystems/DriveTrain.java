/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.PortMap;
import frc.robot.commands.CheesyDrive;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  private TalonSRX motorLF = new TalonSRX(PortMap.MOTOR_LF_ID);
  private TalonSRX motorLM = new TalonSRX(PortMap.MOTOR_LM_ID);
  private TalonSRX motorLR = new TalonSRX(PortMap.MOTOR_LR_ID);
  private TalonSRX motorRF = new TalonSRX(PortMap.MOTOR_RF_ID);
  private TalonSRX motorRM = new TalonSRX(PortMap.MOTOR_RM_ID);
  private TalonSRX motorRR = new TalonSRX(PortMap.MOTOR_RR_ID);


  public void setLeftMotors(double speed){
    motorLF.set(ControlMode.PercentOutput, -speed);
    motorLM.set(ControlMode.PercentOutput, -speed);
    motorLR.set(ControlMode.PercentOutput, -speed);
    SmartDashboard.putNumber("LeftSpeed", speed);
  }

  public void setRightMotors(double speed){
    motorRF.set(ControlMode.PercentOutput, speed);
    motorRM.set(ControlMode.PercentOutput, speed);
    motorRR.set(ControlMode.PercentOutput, speed);
    SmartDashboard.putNumber("RightSpeed", speed);
  }
  public void setBothMotors(double speed){
    setRightMotors(speed);
    setLeftMotors(speed);
  }

/* 
  
*/
  public DriveTrain() {

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new CheesyDrive());
  }
}
