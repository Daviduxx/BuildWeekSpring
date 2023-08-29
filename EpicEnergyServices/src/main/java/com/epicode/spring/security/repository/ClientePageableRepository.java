package com.epicode.spring.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.spring.security.entity.Cliente;

public interface ClientePageableRepository extends PagingAndSortingRepository<Cliente, Long>{

}
