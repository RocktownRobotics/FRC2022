# frc-code
Robot code for FRC 2020 challenge


## STUFF I FOUND ABOUT THE GYROSCOPE

also we all need to read the docs from last year. this Ian guy is our god now and we should follow what he's doing. that's where i found this gyroscope stuff.

https://www.kauailabs.com/public_files/navx-mxp/apidocs/java/com/kauailabs/navx/frc/AHRS.html
https://github.com/RocktownRobotics/FRC2019/blob/master/src/main/java/frc/robot/subsystems/Drivetrain.java
https://pdocs.kauailabs.com/navx-mxp/software/roborio-libraries/java/

```java

// we'll need all these lines once we install the gyroscope library.
import com.kauailabs.navx.frc.AHRS;


//this goes in declaration v
public class Drivetrain extends Subsystem {
	
	//for gyroscope things
	private AHRS navX;

}


//this in public drivetrain thing v
public Drivetrain() {
	
	//configure navX
	navX = new AHRS(RobotMap.NAVX_PORT);
	
}


//getting values
navX.getYaw();
navX.getPitch();

//resetting i guess?
navX.zeroYaw();
```
