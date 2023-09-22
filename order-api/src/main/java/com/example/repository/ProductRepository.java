package com.example.repository;

import com.example.domain.model.model.Product;
import com.example.domain.model.model.ProductItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"productItems"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Product> findByMemberIdAndId(Long memberId, Long id);

    @EntityGraph(attributePaths = {"productItems"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Product> findWithProductItemsById(Long id);

}
