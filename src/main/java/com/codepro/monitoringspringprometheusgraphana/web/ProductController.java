package com.codepro.monitoringspringprometheusgraphana.web;

import com.codepro.monitoringspringprometheusgraphana.entities.Product;
import com.codepro.monitoringspringprometheusgraphana.model.Post;
import com.codepro.monitoringspringprometheusgraphana.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductRepository productRepository;
    private final RestClient restClient;

    public ProductController(ProductRepository productRepository,
                             RestClient.Builder restClient) {

        this.productRepository = productRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        log.info("Find all products");
      return productRepository.findAll();
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        log.info("Find all posts");
      return restClient
              .get()
              .uri("/posts")
              .retrieve()
              .body(new ParameterizedTypeReference<List<Post>>() {});
    }
}
