package frc.robot.games.activevimal;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.GameCommand;

public class activevimal extends GameCommand {
    private String playerName = "";

    public activevimal() {
        addCommands(askName(), sayName());
    }

    private Command askName() {
        return Commands.runOnce(
            () -> {
                editOutput("who is active?");
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
                if (playerName.toLowerCase().contains("vimal")) {
                editOutput("Your active is https://media.licdn.com/dms/image/D5622AQFUWVtkfUD7nQ/feedshare-shrink_2048_1536/0/1718005528521?e=2147483647&v=beta&t=1LrdpOTjAtELrAm-G1lY0ymr3rTnxgorxs1ouBpaVY4");
                                        }
                else if (playerName.toLowerCase().contains("simal")||(playerName.toLowerCase().contains("val"))){
editOutput("https://www.activevimal.com/product/active-vimal-detergent-110gm/");
                }



                else if (playerName.toLowerCase().contains("sal")){
                editOutput("sal says you should go to    https://docs.google.com/document/d/1CkNUl08mFW8FMWaxhhAACrvYkBsnTUZyebrwD1UbIv0/edit?usp=sharing");
}
                else{
                    editOutput("https://docs.google.com/document/d/1MYUN4L0IAgHRwVy0fKkg5F3c6q0umxG4-aYRWQPzEwg/edit?usp=sharing");}

            }
        );
    }

    @Override
    public String getGameName() {
        return "Active Vimal";
    }

    @Override
    public String getAuthors() {
        return "cheeseconsumer42";
    }
    
}
