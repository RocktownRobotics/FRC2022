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
		public static final double SHOOTER_SPEED=.88; //.88 for distance
	
	//Optimum Shooting RPM
		public static final int OPTIMUMRPM=8600;
		public static final int RPMBUFFER = 100;

	//PID
		public static final double PID_P = .11;//.0045 min 
		public static final double PID_D = .08;
		public static final double RPM_I_ENGAGE = 250;

	//X alignment
		public static final double SHOOTER_X_OFFSET = 0.5;
		public static final double X_ALIGN_MOTOR_SPEED = 0.05;

	//Distance Alignment
		public static final double SHOOTING_DISTANCE = 30;
		public static final double SHOOTING_BUFFER = .5;
		public static final double DISTANCE_ALIGNMENT_SPEED = .25;
//

//--------------------------------------------------------------------------------------------------------//

//Spinner config

	public static final double SPINNER_SPEED = 1;

	
//--------------------------------------------------------------------------------------------------------//

//Drive configs

	public static final double JOYSTICK_BUFFER = .1;

}
