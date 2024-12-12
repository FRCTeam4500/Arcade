package frc.robot.games.mariosEpicTextAdventure;

import java.nio.channels.Pipe;
import java.util.Random;

import javax.management.loading.PrivateClassLoader;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class mariosEpicTextAdventure extends GameCommand {
    private String action = "";
    private int level = 0;
    private double nextLvl;

    public mariosEpicTextAdventure() {
        addCommands(goomba(), hole(), levelUp(), gameover());
    }

    private Command goomba() {
            return Commands.runOnce(
                () -> {
                    editOutput("There is a goomba!");
                }
                ).andThen(
                    Commands.waitUntil(() -> !getInput().equals(""))
                ).andThen(
                    Commands.runOnce(() -> {
                        action = getInput();
                    })
                ).andThen(
                    Commands.runOnce(() -> {
                        if (action == "Jump") {
                            editOutput("You stomped it!");
                            Commands.waitSeconds(3);
                            levelUp();
                        } else {
                            gameover();
                        }
                    })
                );
        }
    private Command hole() {
            return Commands.runOnce(() -> {
                editOutput("There's a hole ahead of you!");
            }
            ).andThen(
                    Commands.waitUntil(() -> !getInput().equals(""))
                ).andThen(
                    Commands.runOnce(() -> {
                        action = getInput();
                    })
                ).andThen(
                    Commands.runOnce(() -> {
                        if (action == "Jump") {
                            editOutput("You made it over the hole!");
                            Commands.waitSeconds(3);
                            levelUp();
                        } else {
                            gameover();
                        }
                    })
                );
    }
    private Command levelUp() {
            return Commands.runOnce(() -> {
                level += 1;
            }).andThen(
                Commands.waitSeconds(3)
            ).andThen(
                Commands.runOnce(() -> {
                    nextLvl = Math.random();
                    if (nextLvl == 1) {
                        goomba();
                    } else {
                        hole();
                }
            }));
    }
    private Command gameover() {
        return Commands.waitSeconds(1.5).andThen(() -> {
            editOutput("YOU SUCK");
        }).andThen(
            Commands.waitSeconds(1.5)
        ).andThen(() -> {
                        editOutput("YOU ONLY MADE IT " + level + " LEVEL(S)");
        }).andThen(
            Commands.waitSeconds(1.5)
        ).andThen(() -> {
            editOutput("HA HA");
        }).andThen(
            Commands.waitSeconds(1.5)
        ).andThen(() -> {
            if (Math.random() == 1) {
                editOutput("activevimal.com");
                Commands.waitSeconds(0.2);
            }
        });
    };

    @Override
    public String getGameName() {
        return "Mario's Epic Text Adventure!";
    }

    @Override
    public String getAuthors() {
        return "Jumping Simulator Studios (Nicholas Kaikati)";
    }
}
