package com.saydullin.yamapp.domain.utils

class RestaurantMenuCategoryTranslate() {

    companion object {
        fun execute(value: String): RestaurantMenuCategory {
            return when (value.uppercase()) {
                "BREAKFASTS" -> RestaurantMenuCategory.BREAKFASTS
                "SALADS" -> RestaurantMenuCategory.SALADS
                "SNACKS" -> RestaurantMenuCategory.SNACKS
                "DESERTS" -> RestaurantMenuCategory.DESERTS
                else -> RestaurantMenuCategory.SOUPS
            }
        }
        fun executeReverse(value: RestaurantMenuCategory): String {
            return when (value) {
                RestaurantMenuCategory.BREAKFASTS -> "BREAKFASTS"
                RestaurantMenuCategory.SALADS -> "SALADS"
                RestaurantMenuCategory.SNACKS -> "SNACKS"
                RestaurantMenuCategory.DESERTS -> "DESERTS"
                else -> "SOUPS"
            }
        }
    }

}