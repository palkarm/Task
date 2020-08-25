import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadData {

     final static String path = "/Users/manasipalkar/Desktop/Output.txt";
    public static void main(String[] args){
        HashMap<String , Integer> mapFromfile = getHashMapFromTextFile ();
         for (Map.Entry<String,Integer> entry :mapFromfile.entrySet ()){
             System.out.println(entry.getValue () + " :User Id");
        }

    }

    private static HashMap<String, Integer> getHashMapFromTextFile() {
    Map<String,Integer> mapFileContents = new HashMap<String, Integer> ();
        BufferedReader br = null;
        try{
            FileReader file = new FileReader ("path");
            br = new BufferedReader (new FileReader (path));
            String line = null;

            //read file line by line
            while ( (line = br.readLine()) != null ){

                //split the line by :
                String[] parts = line.split(":");

                //first part is name, second is age
                String user_id = parts[0].trim();
                Integer id = Integer.parseInt( parts[1].trim() );

                //put name, age in HashMap if they are not empty
                if( !user_id.equals("") && !id.equals("") ) {
                    mapFileContents.put(user_id, id);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return (HashMap<String, Integer>) mapFileContents;
    }


}
