package com.team1241.frc2016.commands.defence;

import com.team1241.frc2016.NumberConstants;
import com.team1241.frc2016.commands.auto.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command Groups used to cross the drawbridge
 */
public class AutoDrawbridge extends CommandGroup {

	/**
	 * Instantiates a new auto drawbridge.
	 */
	public AutoDrawbridge() {
		// Robot has to start with bumpers bud up with drawbridge and arms up
		addParallel(new DriveCommand(52, 0.75, 0, 2.5));
		// Bring arm down
		addSequential(new RunArm(NumberConstants.upArmAngle - 50, 0.5, 5));

		// Bring down drawbridge
		addParallel(new DriveCommand(-50, .5, 0, 5));
		addSequential(new RunArm(NumberConstants.downArmAngle, 0.5, 5));

		// Go over drawbridge
		addSequential(new DriveCommand(150, 1, 0, 1));
	}
}
