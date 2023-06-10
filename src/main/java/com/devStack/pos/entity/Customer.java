package com.devStack.pos.entity;

import com.devStack.pos.entity.process.FileResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long publicId;

    @Column(columnDefinition = "TINYINT")
    private boolean activeState;

    private String name;

    private String address;

    private  double salary;

    @Embedded
    private FileResource fileResource;
}
