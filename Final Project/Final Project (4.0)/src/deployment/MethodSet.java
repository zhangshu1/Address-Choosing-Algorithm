package deployment;

import static deployment.PublicInfo.PROBLEM_DIMENSION;
import static deployment.PublicInfo.SWARM_SIZE;
import java.util.Random;
import java.util.Vector;

public class MethodSet {

    private Vector<Particle> swarm = new Vector<Particle>();
    public static final double LOC_X_LOW = 0;
    public static final double LOC_X_HIGH = 200;
    public static final double LOC_Y_LOW = 0;
    public static final double LOC_Y_HIGH = 200; // define the range of location
    public static final double VEL_LOW = 0;
    public static final double VEL_HIGH = 10; // define the range of velocity

    public static final double ERR_TOLERANCE = 1E-20; // the smaller the tolerance, the more accurate the result, 
    // but the number of iteration is increased

    public static final double X_C = 100;
    public static final double Y_C = 100; //initialize the location of living area C
    public static final double X_D = 150;
    public static final double Y_D = 150; //initialize the location of living area D

    public static final double X_B = 0;
    public static final double Y_B = 0;
    public static final long POPULATION_B = 50;
    public static final long POPULATION_C = 100;
    public static final double DIATANCE_B = Math.sqrt((Math.pow((X_B - X_C), 2) + Math.pow((Y_B - X_C), 2))); //set some attributes for the basic point B, can be modified

    public static double calculateFitnessValue(Location location, double population) { // Reilly's law of retail gravitation

        double x = location.getLoc()[0];
        double y = location.getLoc()[1];

        double distance1 = Math.sqrt((Math.pow((x - X_C), 2) + Math.pow((y - Y_C), 2))); // calculate the distance from C
        double distance2 = Math.sqrt((Math.pow((x - X_D), 2) + Math.pow((y - Y_D), 2)));
        double ratio1 = (population / POPULATION_B) * Math.pow((DIATANCE_B / distance1), 2);
        double ratio2 = (population / POPULATION_B) * Math.pow((DIATANCE_B / distance2), 2);
        double result = 3000 - Math.pow((distance1 - 30), 2);
//        return ratio1 - ratio2;
        return result;
    }

    public static int getMaxPos(double[] list) {
        int result = 0;
        double maxValue = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > maxValue) {
                maxValue = list[i];
                result = i;
            }
        }
        return result;
    }

    public static double calculatePopulation(Location location) {
        double population = 0;
        double x = location.getLoc()[0];
        double y = location.getLoc()[1];
        double distance = Math.sqrt((Math.pow((x - X_C), 2) + Math.pow((y - Y_C), 2)));
        population = POPULATION_C - distance / 2 ; // cause the distribution of population is linear, so I designed a linear f(x) to calculate population
        if (population > 0) {
            return population;
        } else {
            return 0;
        }
    }

    public static double calculateDistance(Location location) {
        double x = location.getLoc()[0];
        double y = location.getLoc()[1];
        double distance = Math.sqrt((Math.pow((x - X_C), 2) + Math.pow((y - Y_C), 2)));
        return distance;
    }

    public Vector<Particle> initializeSwarm() {
        
        Random generator = new Random();
        for (int i = 0; i < SWARM_SIZE; i++) {
            Particle p = new Particle();

            // randomize location inside a space defined in Problem Set
            double[] loc = new double[PROBLEM_DIMENSION];
            loc[0] = MethodSet.LOC_X_LOW + generator.nextDouble() * (MethodSet.LOC_X_HIGH - MethodSet.LOC_X_LOW);
            loc[1] = MethodSet.LOC_Y_LOW + generator.nextDouble() * (MethodSet.LOC_Y_HIGH - MethodSet.LOC_Y_LOW);
            Location location = new Location(loc);

            // randomize velocity in the range defined in Problem Set
            double[] vel = new double[PROBLEM_DIMENSION];
            vel[0] = MethodSet.VEL_LOW + generator.nextDouble() * (MethodSet.VEL_HIGH - MethodSet.VEL_LOW);
            vel[1] = MethodSet.VEL_LOW + generator.nextDouble() * (MethodSet.VEL_HIGH - MethodSet.VEL_LOW);
            Velocity velocity = new Velocity(vel);

            //at the very beginning, the pBest is current particle itself
            PBest pBest = new PBest();
            pBest.setId(i);
            pBest.setLocation(location);
            pBest.setFitnessValue(calculateFitnessValue(location, calculatePopulation(location)));

            p.setLocation(location);
            p.setVelocity(velocity);
            p.setId(i);
            p.setPopulation(calculatePopulation(location));
            p.setDistance(calculateDistance(location));
            p.setpBest(pBest);

            swarm.add(p);
        }
        return swarm;
    }
}
