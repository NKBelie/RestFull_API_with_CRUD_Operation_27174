package auca.ac.rw.restfullApiAssignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        String saveProduct = productService.addNewProduct(product);

        if(saveProduct.equals("Product added successfully")){
            return new ResponseEntity<>(saveProduct, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(saveProduct, HttpStatus.CONFLICT);
        }
    }
  //Read all Products
  @GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getAllProducts() {  

    return new ResponseEntity<>(
        productService.getAllProducts(),
         HttpStatus.OK
    );
  }
  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?>searchProductByCategory(@RequestParam String category){
    List<Product> getProducts = productService.searchByCategory(category);
    if(getProducts!=null){
        return new ResponseEntity<>(getProducts, HttpStatus.FOUND);
    }else{
        return new ResponseEntity<>("Product with that category are not Found:  " + category, HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping(value = "/searchByPriceAndBrand", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>searchProductByPriceAndBrand(@RequestParam Double price, @RequestParam String brand){
        List<Product> getProducts = productService.searchByPriceAndBrand(price, brand);
        if(getProducts!=null){
            return new ResponseEntity<>(getProducts, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Product with that price and brand are not Found:  " + price + " and " + brand, HttpStatus.NOT_FOUND);
        }
    }

  //----------------------------------------
    // read by id
    @GetMapping(value = "/getProductById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
    // update product
    @PutMapping(value = "/updateProduct/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        String updateResponse = productService.updateProduct(id, updatedProduct);
        if (updateResponse.equals("Product updated successfully")) {
            return new ResponseEntity<>(updateResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updateResponse, HttpStatus.NOT_FOUND);
        }
    }
    // delete product
    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        String deleteResponse = productService.deleteProduct(id);
        if (deleteResponse.equals("Product deleted successfully")) {
            return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deleteResponse, HttpStatus.NOT_FOUND);
        }
    }
}