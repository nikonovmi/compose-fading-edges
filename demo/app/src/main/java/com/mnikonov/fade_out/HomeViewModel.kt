package com.mnikonov.fade_out

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState(emptyList()))
    val state = _state.asStateFlow()

    init {
        _state.value = HomeViewState(
            items = listOf(
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_dog,
                    itemCopyrightRes = R.string.photo_copyright_dog,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_city,
                    itemCopyrightRes = R.string.photo_copyright_city,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_food,
                    itemCopyrightRes = R.string.photo_copyright_food,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_road,
                    itemCopyrightRes = R.string.photo_copyright_road,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_rocket,
                    itemCopyrightRes = R.string.photo_copyright_rocket,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_travel,
                    itemCopyrightRes = R.string.photo_copyright_travel,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_city,
                    itemCopyrightRes = R.string.photo_copyright_city,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_dog,
                    itemCopyrightRes = R.string.photo_copyright_dog,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_food,
                    itemCopyrightRes = R.string.photo_copyright_food,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_road,
                    itemCopyrightRes = R.string.photo_copyright_road,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_rocket,
                    itemCopyrightRes = R.string.photo_copyright_rocket,
                ),
                HomeItem(
                    itemImageRes = R.drawable.vecteezy_travel,
                    itemCopyrightRes = R.string.photo_copyright_travel,
                ),
            )
        )
    }
}

data class HomeViewState(
    val items: List<HomeItem>
)

data class HomeItem(
    @DrawableRes
    val itemImageRes: Int,
    @StringRes
    val itemCopyrightRes: Int,
)
