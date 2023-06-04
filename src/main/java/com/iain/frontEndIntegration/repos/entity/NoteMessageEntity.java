package com.iain.frontEndIntegration.repos.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_note_message")
@Getter
@Setter
public class NoteMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "note_message")
    private String noteMessage;

    @Column(name = "note_status")
    private String noteStatus;

    @Column(name = "create_Datetime")
    private LocalDateTime createDatetime;

    @Column(name = "updated_Datetime")
    private LocalDateTime updatedDatetime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "remark")
    private String remark;
}
