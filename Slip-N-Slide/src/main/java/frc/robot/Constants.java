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

//--------------------------------------------------------------------------------------------------------//

//Sensors

	//Tachometer
		public static final int SHOOTER_STRIPES = 1;
		public static final double PD_P = .8;
		public static final double PD_D = .05;
		public static final int KTIMEOUTMS = 0;

	//Ultrasonic
		public static final int ANALOGPORT = 3;

//

//--------------------------------------------------------------------------------------------------------//

//Shooter config

	//Default Shooter Speed
		public static final double SHOOTER_SPEED=.8825; //.88 for distance
	
	//Optimum Shooting RPM
		public static final int OPTIMUMRPM=7000;

	//PID
		public static final double PID_P = 0;
		public static final double PID_I = 0;
		public static final double PID_D = 0;
		public static final double RPM_I_ENGAGE = 250;
//

}