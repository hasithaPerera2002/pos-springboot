package com.devStack.pos.pos.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RequestCustomerDto {

    private String name;

    private String address;

    private  double salary;
}
