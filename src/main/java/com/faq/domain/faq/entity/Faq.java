package com.faq.domain.faq.entity;


import com.faq.core.jpa.entity.AuditEntity;
import com.faq.domain.category.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Entity
@Table(name = "faq")
public class Faq extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faqNo;

    @JoinColumn(nullable = false, name = "categoryNo")
    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    private Category category;

    private String title;

    private String content;
}
