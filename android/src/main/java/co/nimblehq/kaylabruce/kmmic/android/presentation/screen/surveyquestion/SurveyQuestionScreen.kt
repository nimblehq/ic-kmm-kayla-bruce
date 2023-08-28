package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.surveyquestion

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
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
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common.NextCircleButton
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyQuestionUiModel

// TODO: - Remove dummy data
private val _dummyData = SurveyQuestionUiModel(
    imageUrl = "https://picsum.photos/375/813",
    questionNumber = 3,
    totalQuestion = 10,
    questionTitle = "How fulfilled did you feel during this WFH period?",
    isLastQuestion = true,
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SurveyQuestionScreen() {
    val uiModel = _dummyData
    Scaffold(
        backgroundColor = Color.Black,
    ) { padding ->
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
                                    Row(
                                        horizontalArrangement = Arrangement.End,
                                        modifier = Modifier.fillMaxWidth(),
                                    )  {
                                        CloseButton()
                                    }
                                    Spacer(modifier = Modifier.height(Dimens.medium.dp))
                                    QuestionNumberText(text = uiModel.questionIndex)
                                    Spacer(modifier = Modifier.height(Dimens.small.dp))
                                    QuestionTittleText(text = uiModel.questionTitle)
                                }
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier.fillMaxWidth(),
                                )  {
                                    PrimaryButton(isLastQuestion = uiModel.isLastQuestion)
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
private fun CloseButton() {
    Image(
        painter = painterResource(id = R.drawable.ic_close),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .size(30.dp)
            .clickable {
                // TODO: - Close question
            },
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun QuestionNumberText(text: String) {
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
private fun QuestionTittleText(text: String) {
    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.h4,
        overflow = TextOverflow.Ellipsis,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PrimaryButton(isLastQuestion: Boolean) {
    if (isLastQuestion) SubmitButton() else NextButton()
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun NextButton() {
    NextCircleButton(
        onClick = {
                  // Todo: - Navigate to the next question
        },
        )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SubmitButton() {
    Button(
        contentPadding = PaddingValues(Dimens.medium.dp),
        onClick = {
            // TODO: - Submit answers and show lottie
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
    ) {
        Text(
            text = "Submit",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
private fun PreviewSurveyQuestionScreen() {
    SurveyQuestionScreen()
}
