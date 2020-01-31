/*----------------------------------------------------------------------------*/
/* Copyright (c) 2null18-2null19 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	public static final int MOTOR_LF_ID = 3;
	public static final int MOTOR_LM_ID = 2;
	public static final int MOTOR_LR_ID = 1;
	public static final int MOTOR_RF_ID = 6;
	public static final int MOTOR_RM_ID = 5;
	public static final int MOTOR_RR_ID = 4;

	public static final int XBOX_PORT = 0;

	public static final int XBOX_LS_X = 0;
	public static final int XBOX_LS_Y = 1;
	public static final int XBOX_RS_X = 4;
	public static final int XBOX_RS_Y = 5;

	/*
	X - Shoots
	A - extend pnematic
	B - retract pneumatic
	
	*/

	public static final int XBOX_BX = 3;
	public static final int XBOX_BA = 1;
	public static final int XBOX_BB = 2;

	public static final int SHOOTER_ID = 7;

	public static final int GEARBOX_PORT = 2;

	//public static final int SOLENOID_DEPLOY = null;
	//public static final int SOLENOID_RETRACT = null;

	public static final int DRIVETRAIN_ENCODER_A = 0;
	public static final int DRIVETRAIN_ENCODER_B = 1;
}
