package frc.robot.games;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class GuessThePhrase extends GameCommand{
    private String answer = "";
    private String phrase = String.valueOf(Math.random()*1000*Math.random()*Math.random()*Math.random()*Math.random());

    @Override
    public String getGameName() {
        return "GuessThePhrase";
    }

    @Override
    public String getAuthors() {
        return "David";
    }

    public GuessThePhrase() {
        addCommands(AskPhrase(), Response());
    }

    private Command AskPhrase() {
        return Commands.runOnce(
            () -> {
                editOutput("What is the phrase?");
            }
        ).andThen(
            Commands.waitUntil(() -> !getInput().equals(""))
        ).andThen(
            Commands.runOnce(() -> {
                answer = getInput();
            })
        );
    }

    private Command Response() {
        return Commands.runOnce(() -> {
            if (Math.random() < 0.5) {
            if (answer.equals(phrase)) {
                editOutput("what");
            } else {
                editOutput("haha it was " + phrase);
            }
        } else {
            editOutput("haha is was acutally '" + answer + "'!");
        }
        });
    }
    
}
