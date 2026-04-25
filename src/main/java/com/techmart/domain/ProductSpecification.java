package com.techmart.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_specifications")
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Specification group is required")
    @Column(name = "spec_group")
    private String specGroup;

    @NotBlank(message = "Specification name is required")
    @Column(name = "spec_name")
    private String specName;

    @NotBlank(message = "Specification value is required")
    @Column(name = "spec_value")
    private String specValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductSpecification() {}

    public ProductSpecification(String specGroup, String specName, String specValue, Product product) {
        this.specGroup = specGroup;
        this.specName = specName;
        this.specValue = specValue;
        this.product = product;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSpecGroup() { return specGroup; }
    public void setSpecGroup(String specGroup) { this.specGroup = specGroup; }
    public String getSpecName() { return specName; }
    public void setSpecName(String specName) { this.specName = specName; }
    public String getSpecValue() { return specValue; }
    public void setSpecValue(String specValue) { this.specValue = specValue; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
