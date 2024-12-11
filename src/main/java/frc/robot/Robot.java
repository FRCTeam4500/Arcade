
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.games.roborock.Roborock;

public class Robot extends TimedRobot {
    private GameCommand game = new Roborock();
    public Robot() {
        SmartDashboard.putData("Test", game);

    }

    @Override
    public void teleopInit() {
        System.out.println(game.getPlayers());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}