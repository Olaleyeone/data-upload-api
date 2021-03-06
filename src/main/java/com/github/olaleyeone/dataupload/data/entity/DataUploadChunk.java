package com.github.olaleyeone.dataupload.data.entity;

import com.olaleyeone.audittrail.api.IgnoreData;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class DataUploadChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private DataUpload dataUpload;

    @Column(nullable = false, updatable = false)
    private Long start;

    @Setter(AccessLevel.NONE)
    @Column(nullable = false, updatable = false)
    private Integer size;

    @IgnoreData
    @Column(length = 64 * 1024 * 1024)
    private byte[] data;

    @Column(
            updatable = false,
            nullable = false
    )
    private OffsetDateTime createdOn;

    @PrePersist
    public void prePersist() {
        if (this.createdOn == null) {
            this.createdOn = OffsetDateTime.now();
        }
        this.size = data.length;
    }
}
