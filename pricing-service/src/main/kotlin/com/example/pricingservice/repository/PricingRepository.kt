package com.example.pricingservice.repository

import com.example.pricingservice.model.Price
import org.springframework.stereotype.Repository

@Repository
class PricingRepository {

    val priceList: MutableList<Price> = mutableListOf()

    fun getPriceInfo(productId: Long): Price? {
        populatePriceList()

        for (price in priceList)
            if(productId == price.productId) {
                return price
            }
        return null
    }

    private fun populatePriceList() {
        priceList.add(Price(11L, 1, 8888.80, 8500.0))
        priceList.add(Price(12L, 2, 5000.00, 4500.0))
        priceList.add(Price(13L, 3, 700.0, 500.0))
    }
}