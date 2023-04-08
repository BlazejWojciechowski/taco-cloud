package blaze.springframework.tacocloud.controllers;

import blaze.springframework.tacocloud.domain.Order;
import blaze.springframework.tacocloud.domain.User;
import blaze.springframework.tacocloud.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(Order order, @AuthenticationPrincipal User user) {
        orderRepository.save(order);

        order.setUser(user);

        log.info("Zamówienie zostało złożone: " + order);
        return "redirect:/";
    }
}
