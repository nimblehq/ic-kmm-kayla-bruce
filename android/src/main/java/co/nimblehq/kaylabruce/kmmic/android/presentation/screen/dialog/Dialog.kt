package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.dialog

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.nimblehq.kaylabruce.kmmic.android.constants.Colors
import co.nimblehq.kaylabruce.kmmic.android.R

@Composable
fun Dialog(
    title: String,
    message: String,
    onDismiss: () -> Unit,
    onYes: () -> Unit = onDismiss,
    onCancel: () -> Unit = onDismiss,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                onClick = { onYes() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Colors.Black
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.dialog_yes_button),
                    color = Colors.White70,
                    )
            }
        },
        dismissButton = {
            Button(
                onClick = { onCancel() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Colors.Black,
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.dialog_cancel_button),
                    color = Colors.White50,
                    )
            }
        },
        title = { Text(text = title, color = Colors.White) },
        text = { Text(text = message, color = Colors.White) },
        backgroundColor = Colors.Black,
    )
}

@Preview
@Composable
fun PreviewDialog() {
    Dialog(
        title = "Title",
        message = "Message",
        onDismiss = {},
    )
}
