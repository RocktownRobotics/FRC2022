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

    private XboxController driverController = new XboxController(PortMap.XBOX_DRIVER_PORT);
    private XboxController shooterController = new XboxController(PortMap.XBOX_SUPPORT_PORT);



    public double GetDriverRawAxis(int axis, boolean driver){
        if(driver){
            return -driverController.getRawAxis(axis);
        }else{
            return -shooterController.getRawAxis(axis);
        }
    }

    public boolean isButtonPressed(int button, boolean driver){
        if(driver){
            return driverController.getRawButtonPressed(button);
        }else{
            return shooterController.getRawButtonPressed(button);
        }
    }

    public boolean isButtonReleased(int button, boolean driver){
        if(driver){
        return driverController.getRawButtonReleased(button);
        }
        return shooterController.getRawButtonReleased(button);
    }
}

   
