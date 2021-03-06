package com.megaretail.resource;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.megaretail.entity.ProductEntity;
import com.megaretail.service.ProductService;

@Path("products") // resources/products
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource
{
	// for HATEOS
	@Context
	private UriInfo uriInfo;
	
	@Inject
	ProductService productService;
	
	// get all products in database
	@GET // resources/products
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts()
	{
		List<ProductEntity> products = productService.getProducts();
		
		return Response.ok(products).build();
	}
	
	// get a product by id
	@GET
	@Path("product/{id}")
	public Response productById(@PathParam("id") Long id)
	{
		ProductEntity product = productService.getProductById(id);
		
		return Response.ok(product).build();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
