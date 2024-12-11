package frc.robot.games.namesayer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class NameSayer extends GameCommand {
    private String playerName = "";

    public NameSayer() {
        addCommands(askName(), sayName());
    }

    private Command askName() {
        return Commands.runOnce(
            () -> {
                editOutput("What is your name?");
            }
        ).andThen(
            Commands.waitUntil(() -> !getInput().equals(""))
        ).andThen(
            Commands.runOnce(() -> {
                playerName = getInput();
            })
        );
    }

    private Command sayName() {
        return Commands.runOnce(
            () -> {
                editOutput("Your name is " + playerName);
            }
        );
    }

    @Override
    public String getGameName() {
        return "NameSayer";
    }

    @Override
    public String getAuthors() {
        return "Sal and Vimal";
    }
    
}
