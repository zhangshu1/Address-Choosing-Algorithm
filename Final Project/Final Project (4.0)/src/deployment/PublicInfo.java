package deployment;

import java.util.Vector;



public interface PublicInfo {
	int SWARM_SIZE = 50;
	int MAX_ITERATION = 200;
	int PROBLEM_DIMENSION = 2;
	double C1 = 2.0;
	double C2 = 2.0;
	double W_UPPERBOUND = 1.0;
	double W_LOWERBOUND = 0.0;
        double RANGEBOUND = 150.0;
        public double[] fitnessValueList = new double[SWARM_SIZE];
        MethodSet methodSet = new MethodSet();
        public static Vector<Particle> swarm = methodSet.initializeSwarm();
        
}
