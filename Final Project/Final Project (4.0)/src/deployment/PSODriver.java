package deployment;

import static deployment.PublicInfo.SWARM_SIZE;
import static deployment.PublicInfo.swarm;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;




public class PSODriver {

    public static void main(String args[]) {
        //paint part 
        JFrame newFrame = new JFrame();
        newFrame.setVisible(true);
        newFrame.setSize(500, 500);


        //thread part begins
        Thread[] threadList = new Thread[SWARM_SIZE];
        for (int i = 0; i < SWARM_SIZE; i++) {
            threadList[i] = new Thread(swarm.get(i));

        }
        for (int i = 0; i < SWARM_SIZE; i++) {
            threadList[i].start();
//                sleep(100);

//            int bestParticleIndex = MethodSet.getMaxPos(fitnessValueList);//to find a maximum position
//            if (fitnessValueList[bestParticleIndex] > gBest) {
//                gBest = fitnessValueList[bestParticleIndex];
//                gBestLocation = swarm.get(bestParticleIndex).getLocation();
//            }
            newFrame.add(new Display());
//	new PSOProcess().execute();

        }
    }
}
