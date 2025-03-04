package com.primeiroprojetosb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_categories")
public class Category implements Serializable {

    private final static long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "category")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories") // A tabela que vai procurar/associar
    private Set<Product> products = new HashSet<>();

    public Category() {
        this.products = new HashSet<>();

    }

    public Category(String name) {
        this.products = new HashSet<>();
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        return true;
    }

}
