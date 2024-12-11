package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public abstract class GameCommand extends SequentialCommandGroup {
    private NetworkTable table;
    public abstract String getGameName();
    public abstract String getAuthors();

    public GameCommand() {
        table = NetworkTableInstance.getDefault().getTable("Game");
        addCommands(Commands.runOnce(
            () -> {
                table.getEntry("Game Name").setString(getGameName());
                table.getEntry("Authors").setString(getAuthors());
                table.getEntry("Output").setString("");
                table.getEntry("Input").setString("");
            }    
        )); 
    }

    protected String getInput() {
        return table.getEntry("Input").getString("");
    }

    protected void editOutput(String prompt) {
        table.getEntry("Output").setString(prompt);
        table.getEntry("Input").setString("");
    }
}
