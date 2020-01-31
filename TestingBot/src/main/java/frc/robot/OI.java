/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;


/**
 * Add your docs here.
 */
public class OI {

    private XboxController driverController = new XboxController(Constants.XBOX_PORT);



    public double GetDriverRawAxis(int axis){
        return -driverController.getRawAxis(axis);
    }

    public boolean isButtonPressed(int button){
        return driverController.getRawButtonPressed(button);
    }

    public boolean isButtonReleased(int button){
        return driverController.getRawButtonReleased(button);
    }

   

}
