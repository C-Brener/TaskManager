package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SplashScreen(
                        painterResource(id = R.drawable.ic_task_completed),
                        taskStatus = stringResource(
                            id = R.string.task_status_text
                        ),
                        subTitle = stringResource(id = R.string.nice_work_text)
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen(imageResource: Painter?, taskStatus: String?, subTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Image(
            painter = imageResource ?: painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("${imageResource ?: R.drawable.ic_launcher_background.toString()}")
        )
        Text(
            text = taskStatus ?: stringResource(id = R.string.app_name),
            fontSize = 24.sp,
            modifier = Modifier
                .testTag("Title")
                .padding(top = 24.dp, bottom = 8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = subTitle,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("Sub Title"),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(
        imageResource = painterResource(id = R.drawable.ic_task_completed),
        taskStatus = stringResource(R.string.task_status_text),
        subTitle = stringResource(R.string.nice_work_text)
    )
}