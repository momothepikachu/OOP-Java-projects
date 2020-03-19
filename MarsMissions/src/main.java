import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception{
        Simulation sim = new Simulation();
        ArrayList<Rocket> fleet1 = sim.loadU1();
        ArrayList<Rocket> fleet2 = sim.loadU2();
        Integer budget1 = sim.runSimulation(fleet1);
        Integer budget2 = sim.runSimulation(fleet2);
        System.out.println("fleet1 budget is:"+budget1);
        System.out.println("fleet2 budget is:"+budget2);
    }
}
