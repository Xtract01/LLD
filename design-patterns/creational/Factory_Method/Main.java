interface Logistics {
    void send();
}
class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road logistics");
    }
}
class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air logistics");
    }
}

class Train implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by train logistics");
    }
}
// class LogisticsService {
//     public void send(String mode){
//        if(mode == "Air"){
//             Logistics logistics = new Air();
//             logistics.send();
//         }else if(mode == "Road"){
//             Logistics logistics = new Road();
//             logistics.send(); 
//         }
//     }
// }

// using factory method design pattern
class LogisticsFactory {
    public static Logistics getLogistics(String mode) {
        if(mode == "Air"){
            return new Air();
        }
        else if(mode == "Road"){
            return new Road();   
        }
        return new Train();
    }
}

class LogisticsService {
    public void send(String mode){
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class Main {
    public static void main(String[] args) {
        LogisticsService service = new LogisticsService();
        service.send("Air");
        service.send("Road");
        service.send("Train");
    }
}