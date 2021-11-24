import java.util.ArrayList;

public class DataSystem {
    ArrayList<User> users;
    ArrayList<Driver> drivers;
    ArrayList<RideRequest> rideRequests;
    ArrayList<Driver> pendingList;

    public DataSystem()
    {
        users=new ArrayList<User>();
        drivers=new ArrayList<Driver>();
        rideRequests=new ArrayList<RideRequest>();
        pendingList=new ArrayList<Driver>();
    }
    public  void removePendingDrivers(Driver d)
    {
        pendingList.remove(d);
    }
    public  void addPendingDrivers(Driver d )
    {
        pendingList.add(d);
    }
    public ArrayList <Driver> getPendingList ()
    {
        return pendingList;
    }
    public void printAllData(){

        System.out.println("Users");
        for(int i=0;i<users.size();i++)
        {
            System.out.println("User Name: "+users.get(i).userName+" \nUser Email: "+users.get(i).email
                    +" \n Suspend Status: "+users.get(i).suspendStatus);
            ArrayList<RideOffer> rideOffer = users.get(i).getRideOfferses();
            System.out.println("Ride Offer ");
            for(int j=0;j<rideOffer.size();j++){
                System.out.println("Price: "+rideOffer.get(j).getPrice()
                        +" \n Driver Name: "+rideOffer.get(j).getDriver().userName);
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Driver");
        for(int i=0;i<drivers.size();i++)
        {
            System.out.println("User Name: "+drivers.get(i).userName+" \nUser Email: "+drivers.get(i).email
                    +" \n Suspend status: "+drivers.get(i).suspendStatus+"\n"
                            + "Pendind status: "+drivers.get(i).pendingState);
            System.out.println("Fav Areas ");
            FavAreas favA=drivers.get(i).getFavAreas();
            ArrayList<String>favAreas=favA.returnAllAreas() ;
            for(int j=0;j<favAreas.size();j++){
                System.out.println(favAreas.get(j)+"  ");
            }
            ArrayList<RideRequest> rideRequests=drivers.get(i).getRideRequests();
            System.out.println("Ride Requests ");
            for(int j=0;j<rideRequests.size();j++){
                System.out.println("source: "+rideRequests.get(j).getSource()+" \nDestination:  "+rideRequests.get(j).getDestination()
                        +" \n User Name: "+rideRequests.get(j).getUser().userName);
            }
        }

    }
    public void addUser(User user){
        users.add(user);
    }
    public void addDriver(Driver Driver){
        drivers.add(Driver);
    }
    public User loginUser(String name, String password){
        User user=null;
        for(int i=0;i<users.size();i++)
        {
            if((password.equals(users.get(i).password))&&(name.equals(users.get(i).userName))){

                    user=users.get(i);

            }
        }
        return user;
    }
    public Driver loginDriver(String name, String password){
        Driver driver=null;
        for(int i=0;i<drivers.size();i++)
        {
            if((password.equals(drivers.get(i).password))&&(name.equals(drivers.get(i).userName))){
                    driver=drivers.get(i);

            }
        }
        return driver;
    }



    public void addRideRequest(RideRequest r) {
        rideRequests.add(r);
    }

}
