package com.example.pricingservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class Price(
        val priceId: Long?,
        val productId: Long?,
        val originalPrice: Double? = 0.0,
        val discountPrice: Double? = 0.0
) {
}