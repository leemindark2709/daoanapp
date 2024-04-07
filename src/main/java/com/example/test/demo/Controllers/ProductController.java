package com.example.test.demo.Controllers;

import com.example.test.demo.Models.Product;
import com.example.test.demo.Models.ResponseObject;
import com.example.test.demo.Repositories.ProductRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//DI
@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository repository ;
    @GetMapping("")

    //this request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts(){
        return repository.findAll();

    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id ){
        Optional<Product> foundProduct =repository.findById(id);
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
    ResponseEntity<ResponseObject>insertProduct(@RequestBody Product newProduct){
        List<Product> foundProducts =repository.findByProductName(newProduct.getProductName().trim());
        if(foundProducts.size()>0){
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","product name already taken","")
            );
        }
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert product  successfuly",repository.save(newProduct))
        );
    }
    //delete
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean exists =repository.existsById(id);
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
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        Product updateProduct = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setNam(newProduct.getNam());
                    product.setUrl(newProduct.getUrl());
                    product.setPrice(newProduct.getPrice());
                    return repository.save(product);
                }).orElseGet(()->{
                    newProduct.setId(id);
                    return  repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert successfully",updateProduct)
        );

    }
}
