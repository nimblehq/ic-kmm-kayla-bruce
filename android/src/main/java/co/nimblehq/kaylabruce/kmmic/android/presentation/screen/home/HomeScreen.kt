package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.constants.Dimens
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.header.HomeHeaderView
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.HomeHeaderUiModel
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.ImageBackground
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.footer.HomeFooterView
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyListUiModel
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyUiModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = Color.Black,
    ) { padding ->
        val pagerState = rememberPagerState()
        // TODO: Remove dummy data
        val uiModel = SurveyListUiModel(
            surveys = listOf(
                SurveyUiModel(
                    url = "https://picsum.photos/375/812",
                    title = "Working from home Check-In",
                    description = "We would like to know how you feel about our work from home",
                ),
                SurveyUiModel(
                    url = "https://picsum.photos/375/813",
                    title = "Career training and development",
                    description = "We would like to know what are your goals and skills you wanted",
                ),
                SurveyUiModel(
                    url = "https://picsum.photos/375/814",
                    title = "Inclusion and belonging",
                    description = "Building a workplace culture that prioritizes belonging and inclusion",
                ),
            )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .statusBarsPadding()
                .padding(all = Dimens.medium.dp),
        ) {
            // pullRefresh needs a vertical scroll component to work
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(modifier = Modifier.fillParentMaxHeight()) {
                        HorizontalPager(
                            pageCount = uiModel.surveys.count(),
                            state = pagerState,
                            modifier = Modifier.fillMaxSize(),
                        ) { index ->
                            ImageBackground(
                                imageUrl = uiModel.surveys[index].url,
                            )
                        }

                        HomeHeaderView(
                            uiModel = HomeHeaderUiModel(
                                imageUrl = "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
                                dateText = "Monday, June 15",
                                todayText = "Today",
                            )
                        ) {
                            // TODO: Tap profile image
                            println("Tap profile image")
                        }

                        HomeFooterView(
                            pagerState = pagerState,
                            surveys = uiModel.surveys,
                        )
                    }
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
