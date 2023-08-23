package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.footer

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.constants.Colors
import co.nimblehq.kaylabruce.kmmic.android.constants.Dimens
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.HorizontalPagerIndicator
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.NextCircleButton
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyUiModel
import com.google.accompanist.placeholder.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeFooterView(
    pagerState: PagerState,
    surveys: List<SurveyUiModel>,
    isLoading: Boolean,
) {
    var survey by remember { mutableStateOf<SurveyUiModel?>(null) }
    LaunchedEffect(surveys) {
        snapshotFlow { pagerState.currentPage }.collect { index ->
            survey = surveys.getOrNull(index)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        if (isLoading) {
            HomeFooterLoadingView()
            return
        }
        HorizontalPagerIndicator(
            pageCount = surveys.count(),
            pagerState = pagerState,
        )
        Crossfade(
            targetState = survey?.title.orEmpty(),
            label = "",
            ) {
            Text(
                text = it,
                color = Colors.White,
                style = MaterialTheme.typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Crossfade(
                targetState = survey?.description.orEmpty(),
                modifier = Modifier.weight(1f),
                label = ""
            ) {
                Text(
                    text = it,
                    color = Colors.White70,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.width(Dimens.medium.dp))
            NextCircleButton(
                onClick = {  },
            )
        }
    }
}

fun Modifier.placeholder(
    isLoading: Boolean,
    shapeValue: Dp = 100.dp // rounded corners shimmer item effect
) = placeholder(
    visible = isLoading,
    color = Colors.White50,
    shape = RoundedCornerShape(shapeValue),
    highlight = PlaceholderHighlight.shimmer(
        highlightColor = Colors.White70,
    )
)

@Composable
private fun HomeFooterLoadingView() {
    Spacer(
        modifier = Modifier
            .size(30.dp, 14.dp)
            .placeholder(true)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Spacer(
        modifier = Modifier
            .size(240.dp, 18.dp)
            .placeholder(true)
    )
    Spacer(modifier = Modifier.height(5.dp))
    Spacer(
        modifier = Modifier
            .size(120.dp, 18.dp)
            .placeholder(true)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Spacer(
        modifier = Modifier
            .size(300.dp, 18.dp)
            .placeholder(true)
    )
    Spacer(modifier = Modifier.height(5.dp))
    Spacer(
        modifier = Modifier
            .size(200.dp, 18.dp)
            .placeholder(true)
    )
}
