/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.PortMap;
import frc.robot.commands.SwitchGear;

public class GearBox extends SubsystemBase {
  /**
   * Creates a new GearBox.
   */

   //this solenoid is actually the gearbox
  private Solenoid gearbox = new Solenoid(PortMap.GEARBOX_PORT);

   

  public void changeGear(boolean gearState){
    gearbox.set(!gearState);

    }
    
  public GearBox() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    setDefaultCommand(new SwitchGear());
  }
}
