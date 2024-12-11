package frc.robot.spinner;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.GameCommand;

public interface SpinnerIO {
    public Command spin();

    public static SpinnerIO makeSpinner(GameCommand... games) {
        if (RobotBase.isReal()) {
            return new Spinner(games);
        } else {
            return new SpinnerSim(games);
        }
    }
}
