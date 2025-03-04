/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.primeiroprojetosb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.primeiroprojetosb.entities.Category;
import com.primeiroprojetosb.entities.Order;
import com.primeiroprojetosb.entities.Product;
import com.primeiroprojetosb.entities.User;
import com.primeiroprojetosb.enums.OrderStatus;
import com.primeiroprojetosb.repository.CategoryRepository;
import com.primeiroprojetosb.repository.OrderRepository;
import com.primeiroprojetosb.repository.ProductRepository;
import com.primeiroprojetosb.repository.UserRepository;

@Configuration
@Profile("test") // Só vai funcionar quando o perfil teste estiver ativo
public class TestConfig implements CommandLineRunner { // Injeção de dependencia, precisa do Repository
    // CommandLineRunner é uma interface que é usada para executar códigos dentro
    // dela

    @Autowired // Injeta a dependencia pra não precisar instanciar
    private UserRepository us;

    @Autowired
    private OrderRepository or;

    @Autowired
    private CategoryRepository cr;

    @Autowired
    private ProductRepository pr;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category("Electronics");
        Category cat2 = new Category("Books");
        Category cat3 = new Category("Computers");

        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

        us.saveAll(Arrays.asList(u1, u2));
        or.saveAll(Arrays.asList(o1, o2, o3));
        cr.saveAll(Arrays.asList(cat1, cat2, cat3));
        pr.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2); // Pega a categoria e adiciona
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        pr.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // Salvando novamente

    }

}
