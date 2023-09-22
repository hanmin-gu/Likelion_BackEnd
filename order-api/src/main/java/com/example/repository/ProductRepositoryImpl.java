package com.example.repository;

import com.example.domain.model.model.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Product> searchByName(String name){
        String search = "%" + name + "%" ;
        QProduct
    }
}
