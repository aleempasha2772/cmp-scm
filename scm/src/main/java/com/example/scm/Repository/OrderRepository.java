package com.example.scm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scm.Entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
