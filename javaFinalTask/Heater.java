package javaFinalTask;

public class Heater implements Appliance{

    @Override
    public void execute(int value, House house) {
        house.temperature += value;
    }

}
