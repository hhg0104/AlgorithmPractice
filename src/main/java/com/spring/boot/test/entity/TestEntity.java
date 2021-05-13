package com.spring.boot.test.entity;

import lombok.Data;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(schema = "BUS", name = "TEST")
public class TestEntity {

    @Id
    private int id;

    @Column
    private int cnt;

    @Column
    private String name;
}
