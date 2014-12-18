import peasy.*;
import processing.core.*;
import processing.opengl.*;


public class P1 extends PApplet {


    BarGraph3D graph1;
    PeasyCam cam;

    public void setup() {
        de.looksgood.ani.Ani.init(this);
        size(600,600, OPENGL);
        frameRate(60);
        cam = new PeasyCam(this, 10);
        graph1 = new BarGraph3D(this, color(25, 240, 30), 60f);

    }

    public void draw() {
        background(50);

        graph1.display();

    }

    public void mousePressed() {
        graph1.setValue(random(100));
    }

    public void mouseReleased() {
        graph1.animate();
    }

    public void keyPressed(){
        graph1.setValue(random(1000));
        graph1.animate();
    }


}