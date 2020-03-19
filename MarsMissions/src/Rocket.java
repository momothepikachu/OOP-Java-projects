public class Rocket implements SpaceShip {
    public int cost ;
    public int weight ;
    public int maxWeight ;
    public int limit ;
    public int carried = 0;
    public Rocket(int weight, int maxWeight, int cost){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.limit = maxWeight - weight;
    }
    public Boolean launch(){
        return true;
    }
    public Boolean land(){
        return true;
    }
    public Boolean canCarry(Item item) {
        return item.weight+this.carried<=this.limit;
    }
    public void carry(Item item) {
        this.carried += item.weight;
    }
}
