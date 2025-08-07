package com.example.WebThoiTrang.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class Order_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price_at_time", nullable = false)
    private Double priceAtTime;

    // Constructors
    public Order_Item() {}

    public Order_Item(Order order, Product product, Integer quantity, Double priceAtTime) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceAtTime = priceAtTime;
    }

    // Getters and Setters
    public Integer getOrderItemId() { return orderItemId; }
    public void setOrderItemId(Integer orderItemId) { this.orderItemId = orderItemId; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPriceAtTime() { return priceAtTime; }
    public void setPriceAtTime(Double priceAtTime) { this.priceAtTime = priceAtTime; }
}