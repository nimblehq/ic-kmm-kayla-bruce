package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.constants.Dimens
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.home_header.HomeHeaderView
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.HomeHeaderUiModel

@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = Color.Black,
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .statusBarsPadding()
                .padding(all = Dimens.medium.dp),
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                HomeHeaderView(
                    uiModel = HomeHeaderUiModel(
                    imageUrl = "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
                    dateText = "Monday, June 15",
                    todayText = "Today",
                    ),
                ) {
                    // TODO: Tap profile image
                    println("Tap profile image")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
