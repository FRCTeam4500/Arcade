package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.games.GuessThePhrase;
import frc.robot.games.activevimal.activevimal;
import frc.robot.games.namesayer.NameSayer;
import frc.robot.games.vimalnotvimal.VimalNotVimal;
import frc.robot.spinner.SpinnerIO;

public class Robot extends TimedRobot {
    private SpinnerIO spinner;
    public Robot() {
        spinner = SpinnerIO.makeSpinner(new NameSayer(), new activevimal(), new VimalNotVimal(), new GuessThePhrase());
        SmartDashboard.putData("Spin Button", spinner.spin());
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
}