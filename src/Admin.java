public class Admin {
    public String id;
    public String password;

    Admin()
    {
        id="admin";
        password="admin";
    }

    public void verifyDriverRegistration(Driver d){
          d.setPendingState(false);
    }

    public void suspend(Person p){
        p.suspendStatus=true;
    }
    public void unSuspend(Person p){
        p.suspendStatus=false;
    }
}
