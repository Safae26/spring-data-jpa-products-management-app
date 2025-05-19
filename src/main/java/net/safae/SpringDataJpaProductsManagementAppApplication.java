package net.safae;

import net.safae.entities.Product;
import net.safae.repositories.ProductRepository;
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
	public void run(String... args)
	{
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
		System.out.println("FIND BY NAME");
		System.out.println("Method 1");
		List<Product> productList = productRepository.findByNameContains("n");
		productList.forEach(p->{
			System.out.println(p);
		});
		System.out.println("------------------------");
		System.out.println("Method 2");
		List<Product> productList2 = productRepository.search("%C%");
		productList2.forEach(p->{
			System.out.println(p);
		});
		System.out.println("************************");
		System.out.println("PRICE GREATER THAN..");
		System.out.println("Method 1");
		List<Product> productList3 = productRepository.findByPriceGreaterThan(1000);
		productList3.forEach(p->{
			System.out.println(p);
		});
		System.out.println("------------------------");
		System.out.println("Method 2");
		List<Product> productList4 = productRepository.searchByPrice(1000);
		productList4.forEach(p->{
			System.out.println(p);
		});
	}
}
