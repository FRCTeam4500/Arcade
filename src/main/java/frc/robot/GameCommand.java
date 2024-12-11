package frc.robot;

import java.util.function.Supplier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public abstract class GameCommand extends SequentialCommandGroup {
    private NetworkTable table;
    protected Supplier<String> inputGetter;
    public abstract String getGameName();
    public abstract String getPlayers();

    public GameCommand() {
        table = NetworkTableInstance.getDefault().getTable(getGameName()).getSubTable("Input");
        table.getEntry("Question").setString("");
        table.getEntry("Answer").setString("");
        inputGetter = () -> table.getEntry("Answer").getString("");
    }

    public void editQuestion(String prompt) {
        table.getEntry("Question").setString(prompt);
        table.getEntry("Answer").setString("");
    }
}
