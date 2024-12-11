package frc.robot.spinner;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.GameCommand;

import java.util.Set;

public class SpinnerSim extends SubsystemBase implements SpinnerIO {
    private GameCommand[] games;

    public SpinnerSim(GameCommand... games) {
        this.games = games;
    }

    @Override
    public Command spin() {
        return Commands.defer(
            () -> {
                CommandScheduler.getInstance().clearComposedCommands();
                return games[(int) (Math.random() * games.length)];
            }, 
            Set.of(this)
        );
    }
    
}
