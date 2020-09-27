package com.example.productservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
class Price(
        val priceId: Long?,
        val productId: Long?,
        val originalPrice: Double? = 0.0,
        val discountPrice: Double? = 0.0
) {
}