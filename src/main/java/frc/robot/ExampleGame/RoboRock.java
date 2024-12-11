package frc.robot.ExampleGame;

import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class RoboRock extends GameCommand {

    public RoboRock() {
        addCommands(
            Commands.none()
        );
    }

    @Override
    public String getPlayers() {
        return "meow,me";
    }

    @Override
    public String getGameName() {
        return "RoboRock";
    }
    
}
