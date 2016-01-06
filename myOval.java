import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;

public class MyOval extends MyBoundedShape {
    
    // constructor without input values
    public MyOval( ) {
        super();
    }
    
    // constructor with input values
    public MyOval( int x1, int y1, int x2, int y2, float strokeWidth, float dashLength, Color color1, Color color2,
                  boolean filledF, boolean gradient, boolean dashed ) {
        super(x1, y1, x2, y2, strokeWidth, dashLength, color1, color2, filledF, gradient, dashed);
    }
    
    // Actually draws the oval
    public void draw( Graphics g ) {
        Graphics2D g2 = (Graphics2D) g; // create a Graphics2D object
        if (getGradient()){ // if gradient option is selected
            GradientPaint gradientPaint = new GradientPaint(getUpperLeftX(),getUpperLeftY(), getColor(),
                                                            getUpperLeftX()+getWidth(),getUpperLeftY()+getHeight(),
                                                            getColor2());
            g2.setPaint(gradientPaint);       
        }
        else
            g2.setPaint(getColor());
        
        if (getDashed()){ // if dashed option is selected
            float dash1[] = {10.0f};
            BasicStroke dashedLine = new BasicStroke(getDashLength(),BasicStroke.CAP_BUTT,
                                                                  BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
            g2.setStroke(dashedLine);
        }
        else {
            g2.setStroke(new BasicStroke(getStrokeWidth()));
        }
        
        if (getFilledF()) // if filled option is selected
            g2.fill(new Ellipse2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth() , getHeight()));
        else
            g2.draw(new Ellipse2D.Double(getUpperLeftX(), getUpperLeftY(), getWidth() , getHeight()));
    }
}
