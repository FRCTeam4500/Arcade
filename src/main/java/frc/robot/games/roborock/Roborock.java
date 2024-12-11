package frc.robot.games.roborock;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class Roborock extends GameCommand {
    private String playerName;

    public Roborock() {
        addCommands(askName());
    }

    private Command askName() {
        return Commands.runOnce(
            () -> {
                editQuestion("What is your name?");
            }
        ).andThen(
            Commands.waitUntil(() -> !inputGetter.get().equals(""))
        ).andThen(
            Commands.runOnce(() -> playerName = inputGetter.get())
        );
    }

    @Override
    public String getGameName() {
        return "Roborock";
    }

    @Override
    public String getPlayers() {
        return playerName;
    }
    
}
