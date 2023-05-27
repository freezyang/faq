package com.faq.domain.category.entity;

import com.faq.core.jpa.entity.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

@Audited
@Getter @Setter
@ToString
@Entity
@Table(name = "category")
public class Category extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryNo;

    private long parentCategoryNo;

    private String name;
}
