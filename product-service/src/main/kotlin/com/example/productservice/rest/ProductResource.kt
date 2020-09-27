package com.example.productservice.rest

import com.example.productservice.model.Inventory
import com.example.productservice.model.Price
import com.example.productservice.model.Product
import com.example.productservice.model.ProductInfo
import com.example.productservice.repository.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.RestTemplate

@RestController
class ProductResource(
        private val productRepository: ProductRepository
) {

    private val restTemplate: RestTemplate = RestTemplate()

    @GetMapping("/product/details/{productId}")
    fun getProductDetails(@PathVariable productId: Long): Product {
        //get id, name, desc from product-service
        var productInfo: ProductInfo? = productRepository.getProductInfo(productId)

        //get price from price-service
        var price: Price? = restTemplate.getForObject("http://localhost:8002/price/$productId", Price::class.java)
        //get stock available from stock-service
        var inventory: Inventory? = restTemplate.getForObject("http://localhost:8003/inventory/$productId", Inventory::class.java)

        return Product(productInfo?.productId, productInfo?.productName, productInfo?.productDesc, price?.discountPrice, inventory?.inStock)
    }
}