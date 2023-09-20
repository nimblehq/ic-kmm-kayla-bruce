package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.constants.Dimens
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.ImageBackground
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.footer.HomeFooterView
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.header.HomeHeaderView
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.*
import co.nimblehq.kaylabruce.kmmic.android.util.genericError
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

private val _headerData = HomeHeaderUiModel(
    imageUrl = "https://avatars.githubusercontent.com/u/7391673?s=200&v=4",
    dateText = "Monday, June 15",
    todayText = "Today",
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel(),
    onNavigateToSurveyDetail: (String) -> Unit,
) {
    val surveys by viewModel.surveyList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current

    error?.let {
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(message = it.genericError(context))
        }
        viewModel.clearError()
    }

    LaunchedEffect(Unit) {
        viewModel.init()
    }

    Scaffold(
        backgroundColor = Color.Black,
    ) { padding ->
        val pagerState = rememberPagerState()
        val uiModel = SurveyListUiModel(surveys = surveys)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(modifier = Modifier.fillParentMaxHeight()) {
                        BackgroundImage(
                            uiModel = uiModel,
                            pagerState = pagerState,
                        )
                        Box(
                            modifier = Modifier
                                .statusBarsPadding()
                                .padding(Dimens.medium.dp),
                        ) {
                            HomeHeaderView(
                                uiModel = _headerData,
                                isLoading = isLoading,
                            ) {
                                // TODO: Tap profile image
                                println("Tap profile image")
                            }
                            HomeFooterView(
                                pagerState = pagerState,
                                surveys = uiModel.surveys,
                                isLoading = isLoading,
                            ) {
                                onNavigateToSurveyDetail(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BackgroundImage(
    uiModel: SurveyListUiModel,
    pagerState: PagerState,
) {
    HorizontalPager(
        pageCount = uiModel.surveys.count(),
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
    ) { index ->
        ImageBackground(
            imageUrl = uiModel.surveys[index].url,
        )
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(onNavigateToSurveyDetail = {})
}
