package app.storecms.api.order;

import app.storecms.model.shopping.basis.order.Order;
import app.storecms.model.shopping.basis.product.Product;
import app.storecms.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.List;

@RestController
public class OrderController {
    OrderService orderService;
    public OrderController(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }
    // -------------------------------------------------- //
    @GetMapping("api/order/validate/")
    public boolean validate(@RequestBody List<Product> list) {
        return orderService.validateProducts(list);
    }
    @Secured("USER")
    @GetMapping("api/order/{id}")
    public Mono<Order> getInfo(@PathVariable String id, Principal principal) {
        return orderService.getOrderInfo(id, principal);
    }
    @Secured("USER")
    @PostMapping("api/order/")
    public Mono<String> submitOrder(@RequestBody Order order) {
        return orderService.submitOrder(order);
    }
    @Secured("USER")
    @GetMapping("api/orders/")
    public Flux<Order> getOrders(Principal principal) {
        return orderService.getOrders(principal);
    }
}