package com.example.inventoryservice.repository

import com.example.inventoryservice.model.Inventory
import org.springframework.stereotype.Repository

@Repository
class InventoryRepository {

    val inventoryList: MutableList<Inventory> = mutableListOf()

    fun getInventoryInfo(productId: Long): Inventory? {
        populateInventoryList()

        for (inventory in inventoryList)
            if(productId == inventory.productId) {
                return inventory
            }
        return null
    }

    private fun populateInventoryList() {
        inventoryList.add(Inventory(21L, 1, true))
        inventoryList.add(Inventory(22L, 2, true))
        inventoryList.add(Inventory(23L, 3, false))
    }
}