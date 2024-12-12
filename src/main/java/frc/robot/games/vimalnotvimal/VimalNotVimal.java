package frc.robot.games.vimalnotvimal;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class VimalNotVimal extends GameCommand {
    private String playerName = "";

    public VimalNotVimal() {
        addCommands(askName(), checkVimal());
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

    private Command checkVimal() {
        return Commands.runOnce(
            () -> {
                if (playerName.toLowerCase().contains("vimal")) {
                    editOutput("You are Vimal.");
                }

                else {
                    editOutput("You are not Vimal.");
                }
            }
        );
    }

    @Override
    public String getGameName() {
        return "VimalNotVimal";
    }

    @Override
    public String getAuthors() {
        return "Not Vimal";
    }
    
}
