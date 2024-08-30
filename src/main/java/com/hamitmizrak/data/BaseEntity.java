package com.hamitmizrak.data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

// LOMBOK
@Getter
@Setter

// SUPER CLASS
@MappedSuperclass
// Json'a emir veriyoruz Buradaki date olanaları takip etme
@JsonIgnoreProperties(value = {"created_date,updated_date"},allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseEntity extends AuditingAwareBaseEntity {

    // ID (Unique)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date systemDate;
}
