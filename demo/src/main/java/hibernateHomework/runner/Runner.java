package hibernateHomework.runner;
import hibernateHomework.model.Order;
import hibernateHomework.model.Product;
import hibernateHomework.model.User;
import hibernateHomework.repository.OrderRepository;
import hibernateHomework.repository.ProductRepository;
import hibernateHomework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    @Autowired
    public Runner(UserRepository userRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setFirstName("Martin");
        user.setLastName("Zhelyazkov");
        user.setEmail("marto123_123_1990@abv.bg");
        user.setNationality("Bulgaria");
        userRepository.save(user);

        Order order = new Order();
        order.setQuantity(5);
        order.setTotalPrice(100);
        order.setUser(user);
        orderRepository.save(order);

        Product product = new Product();
        product.setName("Bananas");
        product.setPrice(2.50);
        product.setWeight(1.00);
        productRepository.save(product);

    }
}
