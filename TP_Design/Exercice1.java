
class Database{
    private static Database instance;
    
    private String name;

    private Database(String name) {
        this.name = name;
    }

    public static synchronized Database getInstance(String name ){
        if(instance == null){
            instance = new Database(name);
        }
        return instance ;
    }

    public void getConnection(){
        System.out.println("You are connected to the database " + name);

    }

}
public class Exercice1{

    public static void main(String[] args){
        Database b1 = Database.getInstance("MedicationDB") ;
        Database b2 = Database.getInstance("ProductDB") ;

        b1.getConnection() ;
        b2.getConnection() ;


        System.out.println("Is b1 and b2 the same ?  :  " + (b1 == b2)) ;
    }
}