package com.spartan.todo.model.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "ORGINIZATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ORGINIZATION {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "CREATED_DTTM")
    private Date created_dttm;

    @Column(name = "UPDATED_DTTM")
    private Date updateddttm;

    @Column(name = "IS_DELETED")
    private int isDeleted;
}
