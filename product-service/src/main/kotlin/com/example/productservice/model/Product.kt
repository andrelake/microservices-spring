package com.example.productservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class Product(
        val productId: Long?,
        val productName: String? = "",
        val productDesc: String? = "",
        val productPrice: Double? = 0.0,
        var productStock: Boolean? = true
) {
}