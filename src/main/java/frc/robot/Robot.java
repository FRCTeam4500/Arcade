package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.games.namesayer.NameSayer;

public class Robot extends TimedRobot {
    private Spinner spinner;
    public Robot() {
        spinner = new Spinner(new NameSayer());
        SmartDashboard.putData("Spin Button", spinner.startSpin());
        SmartDashboard.putData("Scheduler", CommandScheduler.getInstance());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}