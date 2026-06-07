package com.fintrack.fintrack.category;

import com.fintrack.fintrack.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String color;

    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType type;

    public enum CategoryType {
        INCOME,
        EXPENSE
    }
}