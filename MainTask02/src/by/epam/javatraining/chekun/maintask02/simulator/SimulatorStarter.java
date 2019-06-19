package by.epam.javatraining.chekun.maintask02.simulator;


public class SimulatorStarter {

    public static void main(String[] argc) {
        WorkSimulator workSimulator = AgencyWorkSimulator.getInstance();
        workSimulator.simulateWork();
    }
}
