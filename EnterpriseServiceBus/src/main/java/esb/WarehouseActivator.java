
package esb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class WarehouseActivator {

	@Autowired
	RestTemplate restTemplate;

	public Order checkStock(Order order) {
		if (order.getAmount() > 175) {
			System.out.println("WarehouseService: checking order " + order.toString());
			restTemplate.postForLocation("http://localhost:8083/orders", order);
			return order;
		} else {
			System.out.println("WarehouseService: checking order " + order.toString());
			restTemplate.postForLocation("http://localhost:8082/orders", order);
			return order;
		}
	}
}
