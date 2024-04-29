package com.OrderingService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OrderingService.entity.Ordering;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, String>{

}
