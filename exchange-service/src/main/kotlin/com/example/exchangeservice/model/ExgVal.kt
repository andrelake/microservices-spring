package com.example.exchangeservice.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class ExgVal(
        private val id: Long,
        private val from: Currencies = Currencies.USD,
        private var to: Currencies = Currencies.YEN,
        private var exgVal: Int
) {

    fun getExgVal(): Int {
        return this.exgVal
    }
}