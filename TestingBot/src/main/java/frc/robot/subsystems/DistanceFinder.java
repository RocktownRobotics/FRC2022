/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.lang.Math;
import java.util.concurrent.CyclicBarrier;


public class DistanceFinder extends SubsystemBase {
  /**
   * Creates a new TestSubsystem.
   */
  double AvgDistance=0;
  int counter=0;
  double max=0;
  double min=10000;
  double cycles=0;
  public DistanceFinder() {

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    NetworkTableEntry ty = table.getEntry("ty");

    //trig
    double numerator=69-14.5;
    double verticalOffset = ty.getDouble(0.0);
    double verticalOffsetInRadians=Math.toRadians(verticalOffset);
    double denominator=Math.tan(verticalOffsetInRadians);
    double xdistance=numerator/denominator;

    //averaging jumping value
    AvgDistance+=xdistance;

    SmartDashboard.putNumber("Distance", xdistance);

    if(counter==59){
      AvgDistance=(AvgDistance/60);
      if(cycles>1){
        if(AvgDistance<1000){
          if(AvgDistance>max){
            max=AvgDistance;
            System.out.println(max);
          }
          if(AvgDistance<min){
            min=AvgDistance;
          }
        }
      }
      double ratio=(1.05-1.75*Math.pow(10, -4)*AvgDistance+1.81*Math.pow(10, -6)*AvgDistance*AvgDistance);
      
      //polynomial
      double correctedxdistance=AvgDistance*ratio;

      //linear 
      //double correctedxdistance=9.24*Math.pow(10, -4)*AvgDistance+.884;
      double feet=correctedxdistance/12;
      feet=(int)feet;
      double inches=correctedxdistance-(feet*12);
      inches*=100;
      inches=(int)inches;
      inches=((double)inches)/100;

      //SmartDashboard.putNumber("MaxD", max);
      //SmartDashboard.putNumber("MinD", min);
      //SmartDashboard.putNumber("AverageD", AvgDistance);
      SmartDashboard.putNumber("Ratio", ratio);
      SmartDashboard.putNumber("FinalDistance", correctedxdistance);
      SmartDashboard.putNumber("Feet", feet);
      SmartDashboard.putNumber("Inches", inches);

      AvgDistance=0;
      counter=0;
      cycles++;
    }
    counter++;
  }
}
