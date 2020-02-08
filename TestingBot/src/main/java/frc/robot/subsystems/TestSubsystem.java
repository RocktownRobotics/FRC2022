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


public class TestSubsystem extends SubsystemBase {
  /**
   * Creates a new TestSubsystem.
   */
  public TestSubsystem() {

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");


    double numerator=39-53;
    double horizontalOffset = tx.getDouble(0.0);
    double verticalOffset = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double verticalOffsetInRadians=Math.toRadians(verticalOffset);
    double denominator=Math.tan(verticalOffsetInRadians);

    double xdistance=numerator/denominator;



    SmartDashboard.putNumber("LimelightX", horizontalOffset);
    SmartDashboard.putNumber("LimelightY", verticalOffset);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Distance", xdistance);

  }
}
