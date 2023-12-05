package com.saydullin.yamapp.domain.mapper

abstract class Mapper<From, To> {

    abstract fun map(from: From): To

}