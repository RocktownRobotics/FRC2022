/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.nonhardware;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.DistanceFinder;

import java.lang.Math;

public class LimeLight extends SubsystemBase {
  /**
   * Creates a new LimeLight.
   */
  double AvgDistance = 0;
  int counter = 0;
  double max = 0;
  double min = 10000;
  double cycles = 0;
  boolean light = false;
  int testcounter=0;
  boolean strobeMode=false;

  public LimeLight() {

  }

  public void longRange() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    lightOn();
    NetworkTableEntry tv = table.getEntry("tv");
    double isTarget = tv.getDouble(0.0);
    if (isTarget == 1) {
      NetworkTableEntry ty = table.getEntry("ty");
      // trig
      double numerator = 92 - 51.5;
      double verticalOffset = ty.getDouble(0.0);
      double verticalOffsetInRadians = Math.toRadians(verticalOffset);
      double denominator = Math.tan(verticalOffsetInRadians);
      double xdistance = numerator / denominator;
      // averaging jumping value and finding maxes/mins
      AvgDistance += xdistance;
      if (counter == 59) {
        AvgDistance = (AvgDistance / 60);
      if (cycles > 1) {
        if (AvgDistance < 1000) {
          if (AvgDistance > max) {
            max = AvgDistance;
          }
          if (AvgDistance < min) {
            min = AvgDistance;
          }
        }
      }
      double ratio = (1.05 - 1.75 * Math.pow(10, -4) * AvgDistance  + 1.81 * Math.pow(10, -6) * AvgDistance * AvgDistance);
      double correctedxdistance = AvgDistance * ratio;
      // Converting raw inches to feet/inches
      double feet = correctedxdistance / 12;
      feet = (int) feet;
      double inches = correctedxdistance - (feet * 12);
      inches *= 100;
      inches = (int) inches;
      inches = ((double) inches) / 100;
      // Writing values to SmartDashboard
      // SmartDashboard.putNumber("MaxD", max);
      // SmartDashboard.putNumber("MinD", min);
      // SmartDashboard.putNumber("AverageD", AvgDistance);
      // SmartDashboard.putNumber("Ratio", ratio);
      // SmartDashboard.putNumber("FinalDistance", correctedxdistance);
      SmartDashboard.putNumber("Feet", feet);
      SmartDashboard.putNumber("Inches", inches);
      // resetting variables
      AvgDistance = 0;
      counter = 0;
      cycles++;
      }
      counter++;
    }
  }

  public void shortRange(){
    lightOff();
    double currentDistance = Robot.m_ultrasonic.getValue();
    double distanceInches = -1.03 + .0523 * currentDistance;
    SmartDashboard.putNumber("Ultrasonic2", distanceInches);
  }

  public void defaultLight(){
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(0);
  }

  public void lightOn() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);

  }

  public void lightOff() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);

  }

  @Override
  public void periodic() {
    setDefaultCommand(new DistanceFinder());
    }
  }
