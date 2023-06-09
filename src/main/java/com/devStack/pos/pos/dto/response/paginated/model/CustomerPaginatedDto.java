package com.devStack.pos.pos.dto.response.paginated.model;

import com.devStack.pos.pos.dto.response.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPaginatedDto {
    private long dataCount;
    private List<ResponseCustomerDto> list;

}
