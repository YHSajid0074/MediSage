package com.example.MediSage.generic.model;

import com.example.MediSage.auth.model.User;
import com.example.MediSage.generic.utils.Helper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @CreatedBy
    private User createdBy;
    @Column(name = "created_by_id", insertable = false, updatable = false)
    private Long createdById;

    @ManyToOne(fetch = FetchType.LAZY)
    @LastModifiedBy
    private User updatedBy;
    @Column(name = "updated_by_id", insertable = false, updatable = false)
    private Long updatedById;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = true;

    @PrePersist
    private void onBasePersist() {
        User user = Helper.getCurrentUser();
        if (user != null && this.createdBy == null) {
            this.createdBy = user;
        }
        this.isActive = true;
    }


    @PreUpdate
    private void onBaseUpdate() {
        User user = Helper.getCurrentUser();
        if (user != null) {
            this.updatedBy = user;
        } else {
            this.updatedBy = this.createdBy;
        }
        this.updatedTime = LocalDateTime.now();
    }

}