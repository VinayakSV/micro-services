package com.vmicro.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vmicro.os.api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
