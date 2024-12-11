package frc.robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public abstract class GameCommand extends SequentialCommandGroup {
    public abstract String getGameName();
    public abstract String getPlayers();
}
