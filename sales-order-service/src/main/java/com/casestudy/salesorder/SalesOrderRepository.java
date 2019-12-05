package com.casestudy.salesorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>{

}
