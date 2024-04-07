package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Product1;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.Product1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//DI
@RestController
@RequestMapping(path = "/api/v1/Products1")
public class Product1Controller {
    @Autowired

    private Product1Repository repository1 ;
    @GetMapping("")

            //------------------------------------------
    List<Product1> getAllProducts1(){
        return repository1.findAll();

    }

            //------------------------------------------
        //this request is: http://localhost:8080/api/v1/Products


    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id ){
        Optional<Product1>  foundProduct =repository1.findById(id);
        if (foundProduct.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","query product successfully",foundProduct));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","can not  find  product with  id ="+id,"")
            );
        }

    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject>insertProduct(@RequestBody Product1 newProduct){
        List<Product1> foundProducts =repository1.findByName(newProduct.getName().trim());
        if(foundProducts.size()>0){
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","product name already taken","")
            );
        }
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert product  successfuly",repository1.save(newProduct))
        );
    }
    //delete
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exists =repository1.existsById(id);
        if(!exists){
            return      ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","Delete product Successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","can't find  product to delete ","")
        );
    }
    //up date ,upsert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product1 newProduct, @PathVariable Long id){
        Product1 updateProduct = repository1.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCateID(newProduct.getCateID());
                    product.setSupplierID(newProduct.getSupplierID());
                    product.setStatus(newProduct.getStatus());
                    product.setQuantity(newProduct.getQuantity());
                    return repository1.save(product);
                }).orElseGet(()->{
                    newProduct.setProductID(id);
                    return  repository1.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert successfully",updateProduct)
        );

    }
}
