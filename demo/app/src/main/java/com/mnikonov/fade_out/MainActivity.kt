package com.mnikonov.fade_out

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.mnikonov.fade_out.ui.theme.Fade_OutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(0x000000))
        setContent {
            Fade_OutTheme(
                darkTheme = true,
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = R.drawable.vecteezy_background,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                    )
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    HomeScreenContent(
        modifier = modifier,
        viewState = viewModel.state.collectAsState().value,
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    viewState: HomeViewState,
) {
    val scrollableState = rememberLazyListState()
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .fadingEdges(scrollableState),
        state = scrollableState,
    ) {
        items(viewState.items) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .aspectRatio(16f / 12f),
                contentAlignment = Alignment.BottomCenter,
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp)),
                    model = it.itemImageRes,
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .padding(12.dp)
                        .background(Color(0x55000000), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    text = stringResource(id = it.itemCopyrightRes),
                    style = TextStyle(textAlign = TextAlign.Center),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Fade_OutTheme(
        darkTheme = true,
    ) {
        HomeScreenContent(
            viewState = HomeViewState(
                items = listOf(
                    HomeItem(
                        itemImageRes = R.drawable.vecteezy_city,
                        itemCopyrightRes = R.string.photo_copyright_city,
                    ),
                    HomeItem(
                        itemImageRes = R.drawable.vecteezy_dog,
                        itemCopyrightRes = R.string.photo_copyright_dog,
                    ),
                )
            )
        )
    }
}
