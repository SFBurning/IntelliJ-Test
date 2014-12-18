import processing.core.*;
import gluegen.*;
import jogl.*;
import de.looksgood.ani.*;
import peasy.*;
public class P1 extends PApplet {


    BarGraph3D graph1;
    PeasyCam cam;

    public void setup() {
        size(600,600, OPENGL);
        cam = new PeasyCam(this, 100);
        graph1 = new BarGraph3D(this, color(25, 240, 30), 60f);
        Ani.init(this);

    }

    public void draw() {
        background(5);
        rotateX(-.5f);
        rotateY(-.5f);
        background(0);
        fill(255,0,0);
        box(30);
        pushMatrix();
        translate(0,0,20);
        fill(0,0,255);
        box(5);
        popMatrix();
        graph1.display();

    }

    public void mouseReleased() {

    }

}