package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.Set;

public class Spinner extends SubsystemBase {
    private CANSparkMax motor;
    private GameCommand[] games;

    public Spinner(GameCommand... games) {
        motor = new CANSparkMax(20, MotorType.kBrushless);
        motor.setIdleMode(IdleMode.kCoast);
        this.games = games;
    }

    public void periodic() {
        SmartDashboard.putNumber("Motor Position", Math.abs(motor.getEncoder().getPosition() % 1));
        SmartDashboard.putNumber("Index", (int) (Math.abs(motor.getEncoder().getPosition() % 1) * games.length));
    }
    
    public Command startSpin() {
        return Commands.runOnce(
            () -> {
                motor.setVoltage(2);
            }
        ).andThen(
            Commands.idle()
        ).finallyDo(() -> endSpin().schedule());
    }

    public Command endSpin() {
        return Commands.runOnce(
            () -> {
                motor.setVoltage(0);
            }
        ).andThen(
            Commands.waitSeconds(0.5)
        ).andThen(
            Commands.waitUntil(() -> Math.abs(motor.getEncoder().getVelocity()) < 5),
            Commands.print("Going to game")
        ).andThen(
            Commands.defer(() -> {
                CommandScheduler.getInstance().clearComposedCommands();
                return getNextGame();
            }, Set.of(this))
        );
    }

    public Command getNextGame() {
        double position = Math.abs(motor.getEncoder().getPosition() % 1);
        return games[(int) (position * games.length)];
    }

}