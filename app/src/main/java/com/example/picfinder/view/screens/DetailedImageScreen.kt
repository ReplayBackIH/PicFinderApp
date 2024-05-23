package com.example.picfinder.view.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.picfinder.viewmodel.ImageViewModel

@Composable
fun DetailedImageScreen(
    imageId: Int,
    navController: NavController,
    imageViewModel: ImageViewModel
) {

    val image by imageViewModel.getImageById(imageId = imageId).collectAsState(initial = null)

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        AsyncImage(
            model = image?.largeImage,
            contentDescription = "large_image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "User : ${image?.userName}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tags: ${image?.imageTags}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Likes: ${image?.likes}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Downloads: ${image?.numberOfDownloads}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Comments: ${image?.numberOfComments}")
    }
}