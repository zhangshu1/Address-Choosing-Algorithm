/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deployment;

import static deployment.MethodSet.X_C;
import static deployment.MethodSet.X_D;
import static deployment.MethodSet.Y_C;
import static deployment.MethodSet.Y_D;
import static deployment.PublicInfo.SWARM_SIZE;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**5
 *
 * @author zhangshu
 */
public class Display extends JPanel implements PublicInfo{
    
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval((int)X_C, (int)Y_C, 15, 15);
        g2d.fillOval((int)X_D, (int)Y_D, 15, 15);
        g2d.setColor(Color.red);
//        g2d.fillOval(6, 6, 6, 6);
//        Vector<Particle> swarm = new MethodSet().initializeSwarm();
        for(int i = 0; i < SWARM_SIZE; i++){
            g2d.fillOval((int) swarm.get(i).getLocation().getLoc()[0], (int) swarm.get(i).getLocation().getLoc()[1], 10, 10);//should be double, need to be modified
            repaint((int) swarm.get(i).getLocation().getLoc()[0], (int) swarm.get(i).getLocation().getLoc()[1], 10, 10);
        }
  
    }
}
