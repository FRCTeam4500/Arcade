package frc.robot.spinner;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.GameCommand;

@FunctionalInterface
public interface SpinnerIO {
    public Command spin();

    public static SpinnerIO makeSpinner(GameCommand... games) {
        if (RobotBase.isReal()) {
            return new Spinner(games);
        }
        return new SpinnerIO() {
            @Override
            public Command spin() {
                return games[(int) (Math.random() * games.length)]
                    .andThen(() -> CommandScheduler.getInstance().clearComposedCommands());
            }
        };
    }
}
