package com.example.example_spring_batch.repository;

import com.example.example_spring_batch.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FooRepository extends JpaRepository<Foo, Long> {

}
