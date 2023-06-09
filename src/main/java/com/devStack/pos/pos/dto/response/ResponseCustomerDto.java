package com.devStack.pos.pos.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseCustomerDto {

    private long publicId;

    private boolean activeState;

    private String name;

    private String address;

    private  double salary;
}
