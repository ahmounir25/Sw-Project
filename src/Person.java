public class Person {
    protected String userName;
    protected String email;
    protected String mobilNumber;
    protected String password;
    protected boolean suspendStatus;
    // protected DB database;

    public Person(String userName, String email,String mobilNumber,String password){
        this.userName=userName;
        this.mobilNumber=mobilNumber;
        this.password=password;
        this.email=email;
        suspendStatus=false;
    }
    public  Person(){
        suspendStatus=false;
    }
    public void register(String userName,String password, String email, String mobilNumber){

    }
    public boolean login(String name,String password){
        boolean flag=false;
        return flag;
    }

}
