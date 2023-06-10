package service.impl;

import com.devStack.pos.entity.Customer;
import com.devStack.pos.pos.dto.core.CustomerDto;
import com.devStack.pos.pos.dto.request.RequestCustomerDto;
import com.devStack.pos.pos.dto.response.ResponseCustomerDto;
import com.devStack.pos.pos.dto.response.paginated.model.CustomerPaginatedDto;
import com.devStack.pos.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CustomerService;


import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto requestCustomerDto) {

        CustomerDto customerDto=new CustomerDto(
                0,
                new Random().nextInt(1000001),
                true,
                requestCustomerDto.getName(),
                requestCustomerDto.getAddress(),
                requestCustomerDto.getSalary(),
                null,null,null,null
        );
        Customer customer=new Customer(
                0,
                customerDto.getPublicId(),
                customerDto.isActiveState(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                null
        );
            customerRepo.save(customer);

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.isActiveState(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary()
        );


    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        return null;
    }

    @Override
    public ResponseCustomerDto updateCustomer(RequestCustomerDto requestCustomerDto, long id) {
        return null;
    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public CustomerPaginatedDto searchAllCustomer(int page, int size, String searchText) {
        return null;
    }
}
