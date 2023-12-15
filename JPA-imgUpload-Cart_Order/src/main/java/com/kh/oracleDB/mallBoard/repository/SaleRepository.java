package com.kh.oracleDB.mallBoard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kh.oracleDB.mallBoard.model.vo.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findAll();
    List<Sale> findSalesById(int id);
    Sale findBySellerId(int id);
}
