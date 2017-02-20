import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math.*;

public class trace {    

    //ArrayList<Double> pointArr;

    public static void main(String[] args) {
        Path inputPath = new Path(3.5, 2.5, 5.5, 1.5);
        trace field = new trace();
        inputPath.pointArr = field.points(inputPath);
        field.drawPoints(inputPath.pointArr);
        //System.out.println("done");
        
                
                
    } 

    public trace(){

        //pointArr = new ArrayList<Double>();
        Draw.setXscale(0, 8);
        Draw.setYscale(0, 8);
        Draw.setPenColor(Draw.BLACK);
        Draw.filledSquare(3.5, 2.5, .25);
        Draw.filledSquare(5.5, 1.5, .25);

    }

    /**
     * Records points traced on map, and draws a rudimentary path. Points are drawn on either 
     * the millionth cycle, or when the coordinates deviate from the previous coordinates by 
     * .2 points
     * @param the path that will be used to copy the arraylist to, and get the coordinates from
     */
    private ArrayList<Double> points(Path inputPath){
        ArrayList<Double> pointArr = new ArrayList<Double>();
        double startX = inputPath.startX;
        double startY = inputPath.startY;
        double endX = inputPath.endX;
        double endY = inputPath.endY;
        double x = startX;
        double y = startY;
        double prevX = startX;
        double prevY = startY; 
        boolean started = false;
        Draw.setPenColor(Draw.CYAN);
        int count = 0;
        boolean sigChange = false;

        
        while(true){
            x = Draw.mouseX();
            y = Draw.mouseY();
            if (((x < startX + .25) && (x > startX - .25)) && ((y < startY + .25) && (y > startY - .25))){
                started = true;
            }
            if (((x < endX + .25) && (x > endX - .25)) && ((y < endY + .25) && (y > endY - .25))){
                pointArr.add(endX);
                pointArr.add(endY);
                return pointArr;
            }
            if((count == 0 && started) || (sigChange && started)){
                pointArr.add(x);
                pointArr.add(y);
                sigChange = false;
                Draw.filledSquare(x, y, .025);
                prevX = x;
                prevY = y;

            }
            count += 1;
            count = count % 250000;

            if(Math.abs(prevX - x) > .2 || Math.abs(prevY - y) > .2){
                sigChange = true;
            }



                        
                    
                    
        }
    }
    /**
     * Draw a line of 100 points in between points. Points are taken from 
     * pointArr, with x coordinates on odd number, and the corresponding
     * y coordinate on the following even number
     * @param the array being iterated through
     * @throws IllegalArgumentException if r is negative
     */
    private void drawPoints(ArrayList<Double> pointArr){
        if (pointArr.isEmpty()) throw new IllegalArgumentException("Input Array not initialized");
        if (pointArr.size()%2 != 0) throw new IllegalArgumentException("Input Array doesn't contain correct # of coordinates");
        double firstX;
        double firstY;
        double secondX;
        double secondY;
        double granX;
        double granY;
        double midX;
        double midY;
        int i;
        Draw.setPenColor(Draw.RED   );
        Iterator<Double> iterX = pointArr.iterator();
        firstX = iterX.next();
        firstY = iterX.next();
        while(iterX.hasNext()){
            secondX = iterX.next();
            secondY = iterX.next();
            granX = (secondX - firstX) / 100;
            granY = (secondY - firstY) / 100;
            //System.out.println(secondX);
            midX = firstX;
            midY = firstY;
            for (i = 0; i < 100 ; i++ ) {
                Draw.filledSquare(midX, midY, .01);
                midX += granX;
                midY += granY;
            }
            firstX = secondX;
            firstY = secondY;



        }



    }
            

            
}

