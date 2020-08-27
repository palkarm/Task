public class Customer {
    String name;
    int user_id;

    public Customer(int user_id , String name){
        this.name = name;
        this.user_id = user_id;
    }
    @Override
    public String toString(){
        return String.valueOf ( user_id );
    }
}
