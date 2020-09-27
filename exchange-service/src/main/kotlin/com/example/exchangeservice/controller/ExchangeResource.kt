package com.example.exchangeservice.controller

import com.example.exchangeservice.model.Currencies
import com.example.exchangeservice.model.ExgVal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeResource {

    @GetMapping("/exchange/from/{from}/to/{to}")
    fun getExchangeDetails(@PathVariable("from") from: Currencies, @PathVariable("to") to: Currencies): ExgVal? {

        var exgVal: ExgVal? = null

        if (Currencies.USD == from && Currencies.INR == to) {
            exgVal = ExgVal(31, from, to, 60)
        } else if (Currencies.USD == from && Currencies.YEN == to) {
            exgVal = ExgVal(31, from, to, 105)
        }

        return exgVal
    }
}