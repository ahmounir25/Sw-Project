import java.util.ArrayList;


class RideOffer implements Subject{
    private double price;
    private Driver driver;
    private boolean offerStatus;
    private ArrayList<Observer>observers;

    public RideOffer() {
        offerStatus=false;
        observers=new ArrayList<Observer>();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(boolean offerStatus) {
        this.offerStatus = offerStatus;
    }
    public void makeOffer(User user, Driver aThis , double price, DataSystem database) {
        driver=aThis;
        this.price=price;
        notifyUser(user,database);
    }
    public void notifyUser(User user,DataSystem dataSystem){
        observers= new ArrayList<Observer>();
        for(int i=0;i<dataSystem.users.size();i++)
        {
            if((user.email.equals(dataSystem.users.get(i).email)) &&(user.mobilNumber.equals(dataSystem.users.get(i).mobilNumber))){
                dataSystem.users.get(i).addRideOffer(this);
                subscribe(dataSystem.users.get(i));

            }
        }
        notify(dataSystem);

    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(DataSystem dataSystem) {
        for(Observer ob:observers )
        {
            ob.update(null,this);
        }
    }


}

