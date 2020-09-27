package com.example.productservice.repository

import com.example.productservice.model.ProductInfo
import org.springframework.stereotype.Repository
import org.springframework.web.client.HttpClientErrorException
import java.lang.Error

@Repository
class ProductRepository {

    val productList: MutableList<ProductInfo> = mutableListOf()

    fun getProductInfo(productId: Long): ProductInfo? {
        populateProductList()

        for (product in productList)
            if(productId == product.productId) {
                return product
            }
        return null
    }

    private fun populateProductList() {
        productList.add(ProductInfo(1L, "Iphone", "Iphone very expensive"))
        productList.add(ProductInfo(2L, "Notebook", "Notebook very expensive"))
        productList.add(ProductInfo(3L, "Shoe", "Shoe very expensive"))

    }
}