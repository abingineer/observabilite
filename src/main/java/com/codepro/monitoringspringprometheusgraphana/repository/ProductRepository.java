package com.codepro.monitoringspringprometheusgraphana.repository;

import com.codepro.monitoringspringprometheusgraphana.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
