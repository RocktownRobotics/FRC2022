/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.RevShooter;
public class Shooter extends SubsystemBase {
  private static TalonSRX shooter1 = new TalonSRX(Constants.SHOOTER1_PORT);
  private TalonSRX shooter2 = new TalonSRX(Constants.SHOOTER2_PORT);
  private int kTimeoutMs = Constants.KTIMEOUTMS;
  private int edgesPerCycle = Constants.SHOOTER_STRIPES;
  private double maxRPM =0;

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
    shooter1.configFactoryDefault();

    shooter1.configSelectedFeedbackSensor(FeedbackDevice.Tachometer, 0, kTimeoutMs);
    shooter1.configPulseWidthPeriod_EdgesPerRot(edgesPerCycle, kTimeoutMs);
    shooter2.configFactoryDefault();

    shooter2.configSelectedFeedbackSensor(FeedbackDevice.Tachometer, 0, kTimeoutMs);
    shooter2.configPulseWidthPeriod_EdgesPerRot(edgesPerCycle, kTimeoutMs);

  }

  public static double getRPM() {
    double tachVel_UnitsPer100ms = shooter1.getSelectedSensorVelocity(0);

    double tachRPM = tachVel_UnitsPer100ms * 600 / 1024;

    return tachRPM;
  }

  public void ShooterSpeed(double speed){
    shooter1.set(ControlMode.PercentOutput, speed);
    shooter2.set(ControlMode.PercentOutput, -speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if(Shooter.getRPM()>maxRPM){
      maxRPM=Shooter.getRPM();
    }
    SmartDashboard.putNumber("MaxRPM", maxRPM);
    setDefaultCommand(new RevShooter());
  }
}
