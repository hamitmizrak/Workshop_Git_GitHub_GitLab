package com.hamitmizrak.data.entity;

import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import com.hamitmizrak.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.io.Serializable;

// LOMBOK
@Data
@Log4j2

// ENTITY
@Entity
@Table(name = "blogs")
// Blog(N)  Category(1)
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long blogId;

    // Embedded
    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable=new BlogEntityEmbeddable();

    //  RELATION
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    private CategoryEntity relationCategoryEntity;

    // Constructor (Parametresiz)
    public BlogEntity() {
    }

    // Constructor (Parametreli)
    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }
} //end class
