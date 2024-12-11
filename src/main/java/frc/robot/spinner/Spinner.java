package frc.robot.spinner;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.GameCommand;

import java.util.Set;

public class Spinner extends SubsystemBase implements SpinnerIO {
    private CANSparkMax motor;
    private GameCommand[] games;

    public Spinner(GameCommand... games) {
        motor = new CANSparkMax(20, MotorType.kBrushless);
        motor.setIdleMode(IdleMode.kCoast);
        this.games = games;
    }
    
    public Command spin() {
        return Commands.runOnce(
            () -> {
                motor.setVoltage(2);
            }
        ).andThen(
            Commands.idle()
        ).finallyDo(() -> endSpin().schedule());
    }

    private Command endSpin() {
        return Commands.runOnce(
            () -> {
                motor.setVoltage(0);
            }
        ).andThen(
            Commands.waitSeconds(0.5)
        ).andThen(
            Commands.waitUntil(() -> Math.abs(motor.getEncoder().getVelocity()) < 5)
        ).andThen(
            Commands.defer(() -> {
                CommandScheduler.getInstance().clearComposedCommands();
                return getNextGame();
            }, Set.of(this))
        );
    }

    private Command getNextGame() {
        double position = Math.abs(motor.getEncoder().getPosition() % 1);
        return games[(int) (position * games.length)];
    }

}