import java.util.ArrayList;
import java.util.List;

public class EmailManagementService {
    public static void main(String[] args) {
        Ems em = new Ems();
        OrderCompletedService service = OrderCompletedService.getInstance();
        service.orderCompleted();
    }
}


interface Observer {
    void notifyo();
}

class Ems implements Observer {
    Observable service = OrderCompletedService.getInstance();

    {
        service.subsribe(this);
    }


    @Override
    public void notifyo() {
        System.out.println("method notified");
    }
}



interface Observable {
    void subsribe(Observer observer);
    void unSubsribe(Observer observer);
}
class OrderCompletedService implements Observable {
    private OrderCompletedService () {}
    static OrderCompletedService service;
    static OrderCompletedService getInstance() {
        if (service == null) service = new OrderCompletedService();
        return service;
    }

    List<Observer> list = new ArrayList<>();


    @Override
    public void subsribe(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unSubsribe(Observer observer) {

        list.remove(observer);

    }

    void orderCompleted() {
        System.out.println("order completed");

        for (Observer observer : list) {
            observer.notifyo();
        }

    }
}
