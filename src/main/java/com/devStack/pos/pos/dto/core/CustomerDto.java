package com.devStack.pos.pos.dto.core;


import lombok.*;

import java.sql.Blob;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CustomerDto {
    private long id;

    private long publicId;

    private boolean activeState;

    private String name;

    private String address;

    private  double salary;

    private String fileName;

    private String resourceURL;

    private Blob directory;

    private Blob hash;
}
