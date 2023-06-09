package esb;

import org.springframework.integration.annotation.Router;

public class OrderRouter {
    @Router(inputChannel = "domesticshippingchannel")
    public String route(Order order){
        String destinationChannel = null;
        if (order.getAmount()>175){
            destinationChannel="nextdayshippingchannel";
        }else {
            destinationChannel="shippingchannel";
        }
        return destinationChannel;
    }
    @Router(inputChannel = "wharehousechannel")
    public String routeShipping(Order order){
        if (order.getOrderType().equals("International")){
            return "internationalshippingchannel";
        }else {
            return "domesticshippingchannel";
        }
    }
}
