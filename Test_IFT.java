/**
 *
 * @author Alex
 */
package test_ift;

import test_lib.Point;
import java.awt.*;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.*;
 
public class Test_IFT extends JPanel
{
    public static void main(String[] args) 
    {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
     
class Frame extends JFrame
{
    public Frame()
    {
        setTitle("Window");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        Component component = new Component();
        add(component);
    }
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;
}
class Component extends JComponent
{
    public List<Point> points = new ArrayList<Point>();
    public int counter = 0;
    public static final int RADIUS = 50;
    
    public Component()
    {
        addMouseListener(new MouseHandler());
    }

    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
          counter++;
          int x = event.getX();
          int y = event.getY();
          String name = "Point" + counter;
          Point mousePos = new Point(x, y, name);
          points.add(mousePos);
          repaint();//will call paintComponent                       
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        for (Point point : points)
        {
            int x = point.getX();
            int y = point.getY();
            String name = point.getName();
            String str = name + " \n X: " + x + " Y: " + y;
            
            g.setColor(Color.red);
            g.drawString(str,x - RADIUS , y - (RADIUS/2) - 3);
            g.setColor(Color.blue);
            g.drawOval(x-25, y-25, RADIUS, RADIUS);
        }
    }
}