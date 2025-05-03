package com.fou.example.nosqlcrud.rest;

import com.fou.example.nosqlcrud.config.BaseIT;
import com.fou.example.nosqlcrud.domain.Product;
import com.fou.example.nosqlcrud.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ProductResourceTest extends BaseIT {

    @MockitoBean
    private ProductService productService;

    @Test
    void getAllProducts_success() throws Exception{
        mockMvc.perform(get("/api/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllProductsUnitTest_success() throws Exception{
        //given
        List<Product> mockProducts = List.of(new Product(null,"tv", UUID.randomUUID(),1),
                new Product(null,"phone", UUID.randomUUID(),6));

        when(productService.getAllProducts("label")).thenReturn(mockProducts);

        mockMvc.perform(get("/api/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //verify
        verify(productService, times(1)).getAllProducts("label");
    }

   @Test
   void getProductById_sucess() throws Exception {
        mockMvc.perform(get("/api/products/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
   }

    @Test
    void updateProduct_sucess() throws Exception {
        mockMvc.perform(put("/api/products/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteProduct_sucess() throws Exception {
        mockMvc.perform(put("/api/products/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
