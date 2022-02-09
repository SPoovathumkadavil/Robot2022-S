package frc.robot.subsystem.turret;

import edu.wpi.first.util.sendable.SendableBuilder;
import frc.robot.component.AngleComponent;

public class TurretImpl implements Turret{
    private AngleComponent motor;
    private double targetAngle;
    public TurretImpl(AngleComponent motor){
        this.motor = motor;
    }

    public void setAngle(double angle){
        motor.setAngle(angle / TurretConstants.TURRET_RATIO);
    }

    public double getAngle(){
        return motor.getAngle() * TurretConstants.TURRET_RATIO;
    }

    public void initSendable(SendableBuilder builder){
        builder.addDoubleProperty("Target Angle", () -> targetAngle, null);
        builder.addDoubleProperty("Current Angle", () -> motor.getAngle(), null);
    }
}
