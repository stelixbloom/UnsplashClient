package com.example.unsplashclient.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.unsplashclient.domain.model.Photo
import com.example.unsplashclient.presentation.components.CountLabel
import com.example.unsplashclient.presentation.ui.theme.UnsplashClientTheme

@Composable
fun PhotoThumbnail(
    photo: Photo,
    onClick: (Photo) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .heightIn(min = 200.dp)
            .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter,
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth(),
            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(10.dp),
        ) {
           Column(
               modifier = Modifier.fillMaxWidth(0.8f),
           ) {
               Text(
                   text = photo.description ?: "No description",
                   color = Color.White,
                   style = MaterialTheme.typography.bodyLarge,
                   )
               Text(
                   text = photo.photographer ?: "Unknown photographer",
                   color = Color.White,
                   style = MaterialTheme.typography.bodyMedium,
                   )
           }
            Spacer(modifier = Modifier.weight(1f))
            CountLabel(
                imageVector = Icons.Default.Favorite,
                count = photo.likes ?: 0,
                iconTint = Color.Magenta,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
private fun PhotoThumbnailview() {
    val photo = Photo(
        photoId = "",
        description = "Image Description",
        likes = 100,
        imageUrl = "https://unsplash.com/ja/%E5%86%99%E7%9C%9F/%E5%A4%9C%E3%81%AE%E6%98%8E%E3%81%8B%E3%82%8A%E3%81%8C%E5%B7%9D%E3%81%8C%E6%B5%81%E3%82%8C%E3%82%8B%E5%BA%83%E5%A4%A7%E3%81%AA%E8%A1%97%E4%B8%A6%E3%81%BF%E3%82%92%E7%85%A7%E3%82%89%E3%81%97%E3%81%BE%E3%81%99-EAKnJiaJyPM",
        photographer = "Michael Pointner",
    )
    UnsplashClientTheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }
}