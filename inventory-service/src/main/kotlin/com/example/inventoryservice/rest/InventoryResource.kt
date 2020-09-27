package com.example.inventoryservice.rest

import com.example.inventoryservice.model.Inventory
import com.example.inventoryservice.repository.InventoryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

@RestController
class InventoryResource(
        private val inventoryRepository: InventoryRepository
) {

    @GetMapping("/inventory/{productId}")
    fun getProductDetails(@PathVariable productId: Long): Inventory? {

        return inventoryRepository.getInventoryInfo(productId)
    }
}