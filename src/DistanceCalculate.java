import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DistanceCalculate {
    public static final double Radius = 6372.8;//radius of earth in km
    public static  final double lat2 = 53.339428;//office coordinate
    public static final double long2 = -6.257664;
    
    public static void main(String [] args) throws IOException ,FileNotFoundException {
        String path = "/Users/manasipalkar/Desktop/CustomerList.txt";
        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer ();//string buffer with no characters
        String line ;
        while ((line= br.readLine ())!=null){

           System.out.println(line);
        }
        reader.close ();

       //System.out.println(distanceCalculate(line,-6.043701 ,53.339428,-6.257664));

    }

    private static double distanceCalculate(double lat1, double long1, double lat2,double long2) {
                double deltaLat = Math.toRadians (lat2-lat1);
                double deltaLong = Math.toRadians (long2-long1);
                lat1 = Math.toRadians(lat1);
                lat2 = Math.toRadians(lat2);

                double a = (Math.pow(Math.sin(deltaLat/2),2))+((Math.cos (lat1))*(Math.cos(lat2))*(Math.pow(Math.sin(deltaLong/2),2)));
                double c = 2 * Math.asin(Math.sqrt (a));

                return Radius*c;//if this value is less than equal to 100 return the corresponding user.


    }

}
