/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.ControlPneumatics;


public class Pneumatic extends SubsystemBase {
  /**
   * Creates a new Pneumatic.
   */
  DoubleSolenoid dSolenoid = new DoubleSolenoid(Constants.SOLENOID_DEPLOY,Constants.SOLENOID_RETRACT);

  public Pneumatic() {

  }

  public void extendSolenoid(){
    dSolenoid.set(Value.kForward);
  }
  
  public void retractSolenoid(){
    dSolenoid.set(Value.kReverse);
  }
  public void stopSolenoid(){
    dSolenoid.set(Value.kOff);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      setDefaultCommand(new ControlPneumatics());   
  }
}
