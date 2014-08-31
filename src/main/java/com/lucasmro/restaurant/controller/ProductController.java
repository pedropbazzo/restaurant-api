package com.lucasmro.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.lucasmro.restaurant.enums.ProductType;
import com.lucasmro.restaurant.exception.ResourceNotFoundException;
import com.lucasmro.restaurant.model.Product;

@Path("/products")
public class ProductController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {
		// TODO: Create persistence layer

		Product product1 = new Product();
		product1.setId(1);
		product1.setType(ProductType.HAMBURGUER);
		product1.setDescription("X-EGG");
		product1.setPrice(10.5);

		Product product2 = new Product();
		product2.setId(2);
		product2.setType(ProductType.DRINK);
		product2.setDescription("Coca-Cola");
		product2.setPrice(4.0);

		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);

		return Response.status(Status.OK).entity(products).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("id") Integer id) throws ResourceNotFoundException {
		// TODO: Create persistence layer
		Product product = null;

		if (id == 1) {
			product = new Product();
			product.setId(1);
			product.setType(ProductType.HAMBURGUER);
			product.setDescription("X-EGG");
			product.setPrice(10.5);
		}

		if (null == product) {
			throw new ResourceNotFoundException("No Product found with Id " + id);
		}

		return Response.status(Status.OK).entity(product).build();
	}
}
