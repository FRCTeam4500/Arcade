package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.games.vimalnotvimal.VimalNotVimal;
import frc.robot.spinner.SpinnerIO;

public class Robot extends TimedRobot {
    private SpinnerIO spinner;
    public Robot() {
        spinner = SpinnerIO.makeSpinner(new VimalNotVimal());
        SmartDashboard.putData("Spin Button", spinner.spin());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}