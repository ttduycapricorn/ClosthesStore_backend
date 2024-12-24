package com.devteria.server.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
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
