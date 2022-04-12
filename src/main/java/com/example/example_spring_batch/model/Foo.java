package com.example.example_spring_batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Foo {

  @Id
  private Long id;

  @Column
  private String bar;
}
