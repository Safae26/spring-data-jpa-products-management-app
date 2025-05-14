package net.safae.spring_data_jpa_products_management_app;

import net.safae.spring_data_jpa_products_management_app.entities.Product;
import net.safae.spring_data_jpa_products_management_app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaProductsManagementAppApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaProductsManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"Computer",4300,3));
		productRepository.save(new Product(null,"Smart Phone",1200,10));
		productRepository.save(new Product(null,"Printer",1000,9));
		List<Product> products = productRepository.findAll();
		products.forEach(
				p->{
					System.out.println(p);
				}
		);
		Product product = productRepository.findById(Long.valueOf(1l)).get();
		System.out.println("************************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());
		System.out.println("************************");
		System.out.println("------------------------");
		List<Product> productList = productRepository.findByNameContains("n");
		productList.forEach(p->{
			System.out.println(p);
		});

	}
}
