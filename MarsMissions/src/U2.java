public class U2 extends Rocket {
    public U2(){
        super(18000, 29000, 120);
    }
    public Boolean launch(){
        return Math.random() > 0.04 * (carried / this.limit);
    }
    public Boolean land(){
        return Math.random() > 0.08 * (carried / this.limit);
    }
}
