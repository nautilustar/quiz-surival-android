package br.com.nautilustar.data.repository

interface Mapper<E, T> {
    fun transform(entity: E): T
}