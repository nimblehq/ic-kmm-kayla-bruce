package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SurveyButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 24.dp),
        modifier = modifier.height(56.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
        )
    }
}

@Preview
@Composable
fun SurveyButtonPreview() {
    SurveyButton(
        text = "Button",
        onClick = {}
    )
}
