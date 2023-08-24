package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.nimblehq.kaylabruce.kmmic.android.R

@Composable
fun NextCircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.ic_arrow_right),
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable { onClick() },
    )
}
