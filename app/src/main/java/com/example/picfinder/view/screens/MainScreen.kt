package com.example.picfinder.view.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.picfinder.R
import com.example.picfinder.model.data.Image
import com.example.picfinder.viewmodel.ImageViewModel

const val API_KEY = "44004236-795eb4ba924519db97a8aafe5"

@Composable
fun ImageSearchScreen(navController: NavController, imageViewModel: ImageViewModel) {

    var imageSearch by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(
            start = 12.dp,
            end = 12.dp,
            top = 12.dp
        )
    ) {
        TextField(
            value = imageSearch,
            onValueChange = { userRequest ->
                imageSearch = userRequest
            },
            label = {
                Text(text = "Search for image:")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                if (imageSearch.isNotBlank()) {
                    imageViewModel.searchImages(API_KEY, imageSearch)
                    imageSearch = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Search")
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(), thickness = 2.dp
        )
        ImageList(imageViewModel = imageViewModel)
    }
}

@Composable
fun ImageItem(image: Image) {
    Card(
        modifier = Modifier
            .padding(vertical = 3.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image.imageThumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = "image_thumbnail",
                placeholder = painterResource(id = R.drawable.image_icon),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = image.userName, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = image.imageTags, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Composable
fun ImageList(imageViewModel: ImageViewModel) {

    val imageList by imageViewModel.imageList.collectAsState()

    LazyColumn{
        itemsIndexed(imageList) { _, image ->
            ImageItem(image = image)
        }
    }

}
