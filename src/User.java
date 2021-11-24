import java.util.ArrayList;


public class User extends Person implements Observer{
    private RideRequest rideRequests;
    private ArrayList<RideOffer> rideOfferses;
    private ArrayList<String> MyDrivers ;
    public RideRequest getRideRequests() {
        return rideRequests;
    }

    public void setRideRequests(RideRequest rideRequests) {
        this.rideRequests = rideRequests;
    }

    public ArrayList<RideOffer> getRideOfferses() {
        return rideOfferses;
    }

    public void setRideOfferses(ArrayList<RideOffer> rideOfferses) {
        this.rideOfferses = rideOfferses;
    }
    public void addDrivers(Driver driver){
        MyDrivers.add(driver.userName);
    }
    public ArrayList<String> get_MyDriver()
    {
        return MyDrivers;
    }


    public User(){
        rideRequests=new RideRequest();
        rideOfferses=new ArrayList<RideOffer>();
        MyDrivers=new ArrayList<String>();
    }
    public void addRideOffer(RideOffer r){
        rideOfferses.add(r);
    }

    public void register(String userName,String password, String email, String mobilNumber ,DataSystem database){
        this.userName=userName;
        this.email=email;
        this.mobilNumber=mobilNumber;
        this.password=password;
        database.addUser(this);

    }
    //    public User login(String name,String password,DataSystem database){
//        User user=new User();
//        user=database.check(name,password);
//        return user;
//    }
    public void requestRide(String source , String destination,DataSystem database ){
        rideRequests.makeRequest(source,destination,this,database);
    }
    public void rateDriver(Driver driver,int rate){
        driver.getRate().addRate(rate, this);
    }
    public void setOfferStatus(boolean f, RideOffer r){
        r.setOfferStatus(f);
    }
    public void getDriverAverageRate(Driver d){
        System.out.println("Average Rate: "+d.getRate().getAverageRate());

    }

    @Override
    public void update(RideRequest aRequest, RideOffer aOffer) {
        System.out.println(this.userName+" has new Offer \n"
                + "Price: "+aOffer.getPrice()+" \nDriver Name: "+aOffer.getDriver().userName);
    }


}
