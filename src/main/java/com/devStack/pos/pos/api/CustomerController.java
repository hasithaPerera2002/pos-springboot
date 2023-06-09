package com.devStack.pos.pos.api;

import com.devStack.pos.pos.db.DataBase;
import com.devStack.pos.pos.dto.request.RequestCustomerDto;
import com.devStack.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/customers",consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        System.out.println("created");
        var saveData = DataBase.createCustomer(requestCustomerDto).toString();
        return new ResponseEntity<>(new StandardResponse(201,"customer save",saveData), HttpStatus.ACCEPTED);

    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestParam int id,@RequestBody RequestCustomerDto customerDto) throws ClassNotFoundException {
        var saveData = DataBase.updateCustomer(customerDto,id);
        return new ResponseEntity <> ( new StandardResponse(201,"customer updated",saveData), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable int id) throws ClassNotFoundException {
        DataBase.deleteCustomer(id);
        System.out.println(id);
        return  new ResponseEntity<>(new StandardResponse(204,"customer Deleted",null),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable int id) throws ClassNotFoundException {
        return new ResponseEntity<>(new StandardResponse(201,"customer data",DataBase.findCustomer(id)), HttpStatus.OK);

    }

   @GetMapping(value = "/list" ,params = {"page","size","searchText"})
    public ResponseEntity<StandardResponse> getAll(@RequestParam int page,
                         @RequestParam int size,
                         @RequestParam String searchText
                         ) {
        return new ResponseEntity<>(new StandardResponse(201,"customer data",DataBase.allCustomers(page,size,searchText)), HttpStatus.OK);
    }
}
