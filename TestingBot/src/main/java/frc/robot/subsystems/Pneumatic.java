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
import frc.robot.commands.ControlPneumatics;


public class Pneumatic extends SubsystemBase {
  /**
   * Creates a new Pneumatic.
   */
  DoubleSolenoid dSolenoid = new DoubleSolenoid(0,1);

  public Pneumatic() {

  }

  public void extendSolenoid(){
    dSolenoid.set(Value.kForward);
  }
  
  public void retractSolenoid(){
    dSolenoid.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ControlPneumatics());
  }
}
