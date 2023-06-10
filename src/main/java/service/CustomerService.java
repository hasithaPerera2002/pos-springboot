package service;

import com.devStack.pos.pos.dto.request.RequestCustomerDto;
import com.devStack.pos.pos.dto.response.ResponseCustomerDto;
import com.devStack.pos.pos.dto.response.paginated.model.CustomerPaginatedDto;

public interface CustomerService {
    ResponseCustomerDto createCustomer(RequestCustomerDto requestCustomerDto);

    ResponseCustomerDto findCustomer(long id);

    ResponseCustomerDto updateCustomer(RequestCustomerDto requestCustomerDto, long id);

    void deleteCustomer(long id);

    CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText);
}
