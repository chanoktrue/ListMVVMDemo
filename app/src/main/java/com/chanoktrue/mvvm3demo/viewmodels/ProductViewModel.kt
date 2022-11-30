package com.chanoktrue.mvvm3demo.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.chanoktrue.mvvm3demo.models.ProductModel

class ProductViewModel: ViewModel() {

    private var products = mutableStateListOf<ProductModel>()

    fun add(product: ProductModel) {
        products.add(product)
    }

    fun  remove(product: ProductModel) {
        products.remove(product)
    }

    fun getAll(): List<ProductModel> {
        return  products
    }

}