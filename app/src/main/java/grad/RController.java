package grad;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import grad.model.Product;
import grad.repository.ProductRepo;

@RestController
public class RController {


    @Autowired
    ProductRepo productRepo;

    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/register")
    String getRegisterPage()  {
        return "form";  
    }


    @GetMapping("/all")
    ResponseEntity<Iterable<Product>> getLoginPage()  {

        for (Product product : App.products) {
            productRepo.save(product);
        }
        
        System.out.println("FINISHED LOADING");
        return new ResponseEntity<>(productRepo.findAll(),HttpStatus.OK);  
    }

    @GetMapping("/paged")
    ResponseEntity<List<Product>> getPagedProducts(Pageable pageable){
        Page<Product> page = productRepo.findAll(PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            pageable.getSort()
            ));
        return ResponseEntity.ok(page.getContent());
    }

}
