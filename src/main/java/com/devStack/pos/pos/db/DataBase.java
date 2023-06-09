package com.devStack.pos.pos.db;

import com.devStack.pos.pos.dto.core.CustomerDto;
import com.devStack.pos.pos.dto.request.RequestCustomerDto;
import com.devStack.pos.pos.dto.response.ResponseCustomerDto;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class DataBase {
    public static ArrayList<CustomerDto> customerTable=new ArrayList<>();

    public static ResponseCustomerDto createCustomer(RequestCustomerDto requestCustomerDto){
        CustomerDto customerDto=new CustomerDto(
                new Random().nextInt(1000001),
                new Random().nextInt(1000001),
                true,
                requestCustomerDto.getName(),
                requestCustomerDto.getAddress(),
                requestCustomerDto.getSalary(),
                null,null,null,null
        );
        customerTable.add(customerDto);
        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.isActiveState(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary()
        );
    }

    public static ResponseCustomerDto findCustomer(int id) throws ClassNotFoundException {

        Optional<CustomerDto> customerDto = customerTable.stream().filter(e -> e.getPublicId()== id).findFirst();

        if (customerDto.isPresent()) {
            return new ResponseCustomerDto(
                    customerDto.get().getPublicId(),
                    customerDto.get().isActiveState(),
                    customerDto.get().getName(),
                    customerDto.get().getAddress(),
                    customerDto.get().getSalary()
            );
        }
throw new ClassNotFoundException();
    }
    public static ResponseCustomerDto updateCustomer(RequestCustomerDto requestCustomerDto,int id) throws ClassNotFoundException {
        Optional<CustomerDto> customerDto = customerTable.stream().filter(e -> e.getPublicId() == id).findFirst();

        if (customerDto.isPresent()) {
            customerDto.get().setName(requestCustomerDto.getName());
            customerDto.get().setAddress(requestCustomerDto.getAddress());
            customerDto.get().setSalary(requestCustomerDto.getSalary());

            return new ResponseCustomerDto(
                    customerDto.get().getPublicId(),
                    customerDto.get().isActiveState(),
                    customerDto.get().getName(),
                    customerDto.get().getAddress(),
                    customerDto.get().getSalary()
            );
        }
         throw new ClassNotFoundException();
    }

    public static void deleteCustomer(int id) throws ClassNotFoundException {
        System.out.println("delete method called");
        Optional<CustomerDto> customerDto = customerTable.stream().filter(e -> e.getPublicId() == id).findFirst();

        if (customerDto.isPresent()) {
           customerTable.remove(customerDto.get());
            System.out.println("deleted");
           return ;

        }
        throw new ClassNotFoundException();
    }
}
