package com.devteria.server.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String content;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // Foreign key to Product
    Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false) // Optional: link to Order if needed
    Order order;
}
