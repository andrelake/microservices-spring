package com.example.pricingservice.rest

import com.example.pricingservice.model.ExgVal
import com.example.pricingservice.model.Price
import com.example.pricingservice.repository.PricingRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.RestTemplate

@RestController
class PricingResource(
        private val pricingRepository: PricingRepository
) {

    val restTemplate: RestTemplate = RestTemplate()

    @GetMapping("/price/{productId}")
    fun getProductDetails(@PathVariable productId: Long): Price? {

        var price: Price? = pricingRepository.getPriceInfo(productId)

        //Get exchange value
        var exgVal: Int? = restTemplate.getForObject("http://localhost:8004/exchange/from/USD/to/YEN", ExgVal::class.java)?.getExgVal()

        var discountExchangedPrice: Double? = price?.discountPrice?.let { exgVal?.times(it) }

        return Price(price?.priceId, price?.productId, price?.originalPrice, discountExchangedPrice)
    }
}