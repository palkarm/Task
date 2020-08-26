import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortUserName {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader ( new FileReader ( "/Users/manasipalkar/Desktop/CustomerList.txt" ) );

        ArrayList<Customer> customerslist = new ArrayList<Customer> ();

        String line = br.readLine ();
        while (line!=null){
            String[] customerDetails = line.split ( " , " ) ;
            int user_id = Integer.parseInt ( customerDetails[3] );
            String name = customerDetails[5];
            //Creating Student object for every student record and adding it to ArrayList

            customerslist.add(new Customer (name, user_id));
            line = br.readLine ();
        }

        //Sorting Arraylist based on user_id
        Collections.sort(customerslist, new idCompare());

        //BufferWriter to write in op.txt file
        BufferedWriter bw = new BufferedWriter (  new FileWriter ( "/Users/manasipalkar/Desktop/op.txt" ));

        //Writing data for each user
        for (Customer customer : customerslist)
        {
            bw.write(customer.name);

            bw.write(" "+customer.user_id);

            bw.newLine();
        }
        br.close ();
        bw.close ();
    }



//marksCompare Class to compare the marks

    static class idCompare implements Comparator<Customer>
    {

        public int compare(Customer s1, Customer s2)
        {
            return s2.user_id - s1.user_id;
        }
    }
}
