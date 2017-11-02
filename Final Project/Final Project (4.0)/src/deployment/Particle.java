package deployment;

public class Particle implements Runnable{
    
    private int Id;
    private double fitnessValue;
    private Velocity velocity;
    private Location location;
    private double distance; //distance from living area C
    private double population;
    private PBest pBest;

    @Override
    public void run() {
        PSOProcess process = new PSOProcess();
        process.execute(Id);
//        Location gBest = process.execute(Id);
//        System.out.println("\nthe solutions is:");
//	System.out.println("     Best X: " + gBest.getLoc()[0]);
//	System.out.println("     Best Y: " + gBest.getLoc()[1]);
    }

    public Particle(double fitnessValue, Velocity velocity, Location location) {
        super();
        this.fitnessValue = fitnessValue;
        this.velocity = velocity;
        this.location = location;
    }

    public Particle() {

    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getFitnessValue() {
        fitnessValue = MethodSet.calculateFitnessValue(location, population);
        return fitnessValue;
    }

    public double getDistance() {
        distance = MethodSet.calculateDistance(location);
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPopulation() {
        population = MethodSet.calculatePopulation(location);
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setpBest(PBest pBest) {
        this.pBest = pBest;
    }

    public PBest getpBest() {
        return pBest;
    }

    
}
