package com.example.productservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class ProductInfo(
        val productId: Long? = 1L,
        val productName: String? = "",
        val productDesc: String? = ""
) {
}