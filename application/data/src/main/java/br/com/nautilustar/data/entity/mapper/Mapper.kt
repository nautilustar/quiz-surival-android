package br.com.engcad.data.model.mapper

interface Mapper<E, T> {
    fun transform(entity: E): T
}