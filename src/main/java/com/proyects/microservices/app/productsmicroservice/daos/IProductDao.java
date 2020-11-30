package com.proyects.microservices.app.productsmicroservice.daos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.proyects.microservices.app.commonsmicroservice.models.Product;

@RepositoryRestResource(path = "products")
public interface IProductDao extends PagingAndSortingRepository <Product, Long>{
	
	//NATIVE QUERY
	@RestResource(path="search-by-nationality")
	@Query(value = "SELECT * FROM PRODUCTS U WHERE U.nationality=?1", nativeQuery = true)
	public Product findByNationality(String nat);
	
	@RestResource(path="search-by-description")
	@Query(value = "SELECT * FROM PRODUCTS U WHERE U.description=?1", nativeQuery = true)
	public Product findByDescription(String desc);
	
	//JPQL
	@RestResource(path = "search-by-description2")
	@Query(value = "SELECT u FROM Product u where u.description=?1")
	public Product obtenerPorDescription(String desc);
	
	//By method name
	public Product findByPrice(Double price);

}
