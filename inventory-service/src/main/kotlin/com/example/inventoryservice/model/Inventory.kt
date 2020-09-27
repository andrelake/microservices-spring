package com.example.inventoryservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class Inventory(
        val inventoryId: Long?,
        val productId: Long?,
        var inStock: Boolean = true
) {
}