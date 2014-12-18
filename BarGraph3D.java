import processing.core.*;
import de.looksgood.ani.*;
/**
 * Created by SFBurning on 12/16/14.
 */
public class BarGraph3D {

    // Data
    PApplet p; // Parent applet
    private int c; // Color
    private int[] palette;
    private float value;
    private float displayValue;
    // Constructor
    Ani valueAni;

    BarGraph3D(PApplet p, int c) {

        this.p = p;
        this.c = c;

        // Modify Colors
        palette = new int[4];
        p.colorMode(PConstants.HSB, 100);
        palette[0] = c;
        palette[1] = p.color(p.hue(c), (p.saturation(c) - 10), p.brightness(c));
        palette[2] = p.color(p.hue(c), (p.saturation(c) - 6), (p.brightness(c) - 10));
        palette[3] = p.color(p.hue(c), (p.saturation(c) + 4), (p.brightness(c) - 7));

        // dummy value, will be overridden immediately in other constructor
        value = 50;

        // An ani for displayvalue
        valueAni = new Ani(p, 1, "displayValue", value, AniConstants.CIRC_IN);
        valueAni.setPlayMode(AniConstants.YOYO);
        valueAni.repeat(3);
    }

    BarGraph3D(PApplet p, int c, float value) {

        this(p, c); // Call parent constructor
        this.value = value; // Also fill in the data

    }

    // Global draw method
    public void display(float v){
        setValue(v);
        display();
    }

    public void display() {
        p.rectMode(PConstants.CORNERS);
        p.pushMatrix();
            p.pushMatrix();
            {
                p.fill(palette[0]);
                p.translate(0, 0, 50);
                p.rect(-25f,0f, 25f, displayValue);
            }
            p.popMatrix();
            p.pushMatrix();
            {
                p.fill(palette[1]);
                p.translate(0,0,-50);
                p.rect(-25f,0f, 25f, displayValue);

            }
            p.popMatrix();
            p.pushMatrix();
            {
                p.fill(palette[2]);
                p.rotate(p.radians(90));
                p.translate(0,0,-50);
                p.rect(-25f,0f, 25f, displayValue);

            }
            p.popMatrix();
            p.pushMatrix();
            {
                p.fill(palette[3]);
                p.rotate(p.radians(90));
                p.translate(0,0,-50);
                p.rect(-25f,0f, 25f, displayValue);
            }
        p.popMatrix();
        p.popMatrix();
    }

    private void setValue(float v) {
        this.value = v;
    }

    // The data value
    public float getValue() {
        return value;
    }

    // The displayed value-- might be different from data to smooth animation
    public float getDisplayValue() {
        return displayValue;
    }
}
