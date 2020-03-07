/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * Add your docs here.
 */
public class PortMap {
    
//--------------------------------------------------------------------------------------------------------//

//TalonSRX's
	//Wheels
	public static final int MOTOR_LF_ID = 3;
	public static final int MOTOR_LM_ID = 2;
	public static final int MOTOR_LR_ID = 1;
	public static final int MOTOR_RF_ID = 6;
	public static final int MOTOR_RM_ID = 5;
	public static final int MOTOR_RR_ID = 4;
    //Shooters
	public static final int SHOOTER1_PORT = 7; 
    public static final int SHOOTER2_PORT = 8;//(vector)
    //Spinner
    public static final int SPINNER_PORT = 9;
    //Color Wheel
    public static final int COLORWHEEL_PORT = 10;
//

//--------------------------------------------------------------------------------------------------------//

//Controllers
    //Driver
	public static final int XBOX_DRIVER_PORT = 0;
	public static final int XBOX_SUPPORT_PORT = 1;
//

//--------------------------------------------------------------------------------------------------------//

//Axis Ports
    //Left Stick
    public static final int XBOX_LS_X = 0; //Color wheel
    public static final int XBOX_LS_Y = 1;
    //Right Stick
	public static final int XBOX_RS_X = 4;
    public static final int XBOX_RS_Y = 5;
//

//--------------------------------------------------------------------------------------------------------//

//Button Ports and Functions
    //Driver - Gearbox
    //Support - Retract Pneumatic
	public static final int XBOX_BA = 1;

    //Driver - Distance
    //Support - Extend Pneumatic
    public static final int XBOX_BB = 2;

    //Driver - Open
    //Support - Shooter
	public static final int XBOX_BX = 3;

    //Driver - Align to target
    //Support - Spinner
	public static final int XBOX_BY = 4;
//

//--------------------------------------------------------------------------------------------------------//

//Gearbox
    public static final int GEARBOX_PORT = 0;
//

//--------------------------------------------------------------------------------------------------------//

//Solenoids/Double Solenoids
    
    //Double Solenoids
	public static final int SOLENOID_DEPLOY = 2;
    public static final int SOLENOID_RETRACT = 1;
    
//

//--------------------------------------------------------------------------------------------------------//

//Encoders
	public static final int DRIVETRAIN_ENCODER_A = 0;
    public static final int DRIVETRAIN_ENCODER_B = 1;
    

	// public static final DigitalSource COLORWHEEL_ENCODER_A = 7;
	// public static final DigitalSource COLORWHEEL_ENCODER_B = 5;

//
}
