public class U1 extends Rocket {
    public U1(){
        super(10000, 18000, 100);
    }
    public Boolean launch(){
        return Math.random() > 0.05 * (this.carried / this.limit);
    }
    public Boolean land(){
        return Math.random() > 0.01 * (this.carried / this.limit);
    }
}
