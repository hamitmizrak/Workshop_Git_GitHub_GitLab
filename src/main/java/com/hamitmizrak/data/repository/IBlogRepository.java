package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository
// JpaRepository
@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {
}
