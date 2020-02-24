/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.PortMap;
import frc.robot.commands.ColorWheelCommand;

public class ColorWheel extends SubsystemBase {
  private TalonSRX colorSpinner = new TalonSRX(PortMap.COLORWHEEL_PORT);

  /**
   * Creates a new ColorWheel.
   */
  public void spinColorWheel(double speed){
    colorSpinner.set(ControlMode.PercentOutput, speed);
  }

  public ColorWheel() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new ColorWheelCommand());
  }
}
