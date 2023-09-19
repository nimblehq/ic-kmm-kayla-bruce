package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.surveydetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.R
import co.nimblehq.kaylabruce.kmmic.android.constants.Colors
import co.nimblehq.kaylabruce.kmmic.android.constants.Dimens
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.ImageBackground
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyDetailUiModel

// TODO: - Remove dummy data
private val _dummyData = SurveyDetailUiModel(
    imageUrl = "https://picsum.photos/375/813",
    titleText = "Working from home Check-In",
    descriptionText = "We would like to know how you feel about our work from home (WFH) experience.",
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SurveyDetailScreen(
    onNavigateToQuestion: (String, Int) -> Unit,
    onBack: () -> Unit,
) {
    Scaffold(
        backgroundColor = Color.Black,
    ) { padding ->
        val uiModel = _dummyData
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Box(modifier = Modifier.fillParentMaxHeight()) {
                        BackgroundImage(imageUrl = uiModel.imageUrl)
                        Box(
                            modifier = Modifier
                                .statusBarsPadding()
                                .padding(Dimens.medium.dp),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize(),
                            ) {
                                Column {
                                    BackButton(onBack = { onBack() })
                                    Spacer(modifier = Modifier.height(Dimens.medium.dp))
                                    TitleText(text = uiModel.titleText)
                                    Spacer(modifier = Modifier.height(Dimens.small.dp))
                                    DescriptionText(text = uiModel.descriptionText)
                                }
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.fillMaxWidth(),
                                ) {
                                    StartButton(onNavigateToQuestion = {
                                        onNavigateToQuestion(
                                            "dummyId",
                                            1,
                                        )
                                    })
                                }
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
private fun BackgroundImage(imageUrl: String) {
    ImageBackground(
        imageUrl = imageUrl,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BackButton(
    onBack: () -> Unit,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .size(30.dp)
            .clickable {
                onBack()
            },
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TitleText(text: String) {
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.h4,
        overflow = TextOverflow.Ellipsis,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DescriptionText(text: String) {
    Text(
        text = text,
        color = Colors.White70,
        style = MaterialTheme.typography.body1,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun StartButton(
    onNavigateToQuestion: () -> Unit,
) {
    Button(
        contentPadding = PaddingValues(Dimens.medium.dp),
        onClick = {
            onNavigateToQuestion()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
    ) {
        Text(
            text = "Start Survey",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun PreviewSurveyDetailScreen() {
    SurveyDetailScreen(
        onNavigateToQuestion = { id, number -> },
        onBack = {},
    )
}
