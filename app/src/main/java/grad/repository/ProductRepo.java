package grad.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import grad.model.Product;

// public interface ProductRepo extends PagingAndSortingRepository<Product,Integer> {
public interface ProductRepo extends CrudRepository<Product,Integer>, PagingAndSortingRepository<Product,Integer> {
    
}
