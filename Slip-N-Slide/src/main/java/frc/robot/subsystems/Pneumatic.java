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
import frc.robot.PortMap;
import frc.robot.commands.ControlPneumatics;


public class Pneumatic extends SubsystemBase {
  private static boolean isDeployed = false;
  /**
   * Creates a new Pneumatic.
   */
  DoubleSolenoid dSolenoid = new DoubleSolenoid(PortMap.SOLENOID_DEPLOY, PortMap.SOLENOID_RETRACT);

  public Pneumatic() {

  }
  public static boolean isDeployed(){
    return isDeployed;
  }

  public void extendSolenoid(){
    dSolenoid.set(Value.kForward);
    isDeployed = true;
  }
  
  public void retractSolenoid(){
    dSolenoid.set(Value.kReverse);
    isDeployed = false;
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
