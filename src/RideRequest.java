import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
class RideRequest implements Subject{

    private String source;
    private String destination;
    private User user;
    private ArrayList<Observer>observers;

    public RideRequest() {
        observers=new ArrayList<Observer>();
    }

    public void makeRequest(String source, String destination, User aThis, DataSystem database) {
        this.source=source;
        this.destination=destination;
        this.user=aThis;
        database.addRideRequest(this);
        notify(database);
    }
    private void notifyDriver(DataSystem dataSystem){

        for(int i=0;i<dataSystem.drivers.size();i++)
        {
            FavAreas favA=dataSystem.drivers.get(i).getFavAreas();
            ArrayList<String>favAreas=favA.returnAllAreas() ;
            for(int j=0;j<favAreas.size();j++)
            {
                if(source.equals(favAreas.get(j)))
                {
                    dataSystem.drivers.get(i).addRideRequest(this);
                }
            }
        }

    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public User getUser() {
        return user;
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
        observers= new ArrayList<Observer>();
        for(int i=0;i<dataSystem.drivers.size();i++)
        {
            FavAreas favA=dataSystem.drivers.get(i).getFavAreas();
            ArrayList<String>favAreas=favA.returnAllAreas() ;
            for(int j=0;j<favAreas.size();j++)
            {
                if(source.equals(favAreas.get(j)))
                {
                    dataSystem.drivers.get(i).addRideRequest(this);
                    subscribe(dataSystem.drivers.get(i));

                }
            }

        }
        for(Observer ob:observers )
        {
            ob.update(this,null);
        }
    }
}
