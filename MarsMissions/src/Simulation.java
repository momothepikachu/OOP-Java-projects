import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;


public class Simulation {
    private ArrayList<Item> phase1;
    private ArrayList<Item> phase2;
    private ArrayList loadItems(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> list = new ArrayList<Item>();
        while(scanner.hasNextLine()){
            String[] arrItem = scanner.nextLine().split("=");
            Item i = new Item(arrItem[0], Integer.parseInt(arrItem[1]));
            list.add(i);
        }
        return list;
    }
    public Simulation() throws Exception {
        this.phase1 = loadItems("phase1.txt");
        this.phase2 = loadItems("phase2.txt");
    }
    private ArrayList loadRocket(ArrayList<Item> phase, String type){
        ArrayList<Rocket> rockets = new ArrayList<Rocket>();
        Integer countRocket = 0;
        Integer countItem = 0;
        if(type.equals("U1")){
            rockets.add(new U1());
        }else{
            rockets.add(new U2());
        }

        while(countItem<phase.size()){
            Item i = phase.get(countItem);
            Rocket currentR = rockets.get(countRocket);
            if(currentR.canCarry(i)){
                currentR.carry(i);
                countItem++;
            }else{
                countRocket++;
                if(type.equals("U1")){
                    rockets.add(new U1());
                }else{
                    rockets.add(new U2());
                }
            }
        }
        return rockets;
    }
    public ArrayList loadU1(){
        return loadRocket(phase1, "U1");
    }
    public ArrayList loadU2(){
        return loadRocket(phase2, "U2");
    }
    public int runSimulation(ArrayList<Rocket> rockets){
        int budget=0;
        int count = 0;
        while(count<rockets.size()){
            Rocket currentR = rockets.get(count);
            budget += currentR.cost;
            if(currentR.launch() && currentR.land()){
                count++;
            }
        }
        return budget;
    }
}
