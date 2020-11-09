package com.proyects.microservices.app.productsmicroservice.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyects.microservices.app.productscommonsmicroservice.models.Product;

@RepositoryRestResource(path = "products")
public interface IProductDao extends PagingAndSortingRepository <Product, Long>{
	
//	@RestResource(path="search-products-all")
//	@Query(value = "SELECT * FROM PRODUCTS", nativeQuery = true)
//	public Product getAllProducts();
	
	@RestResource(path="search-id-products")
	@Query(value = "SELECT * FROM PRODUCTS U WHERE U.nationality=?", nativeQuery = true)
	public Product findProductByNationality(@Param("nat") String nat);

}
