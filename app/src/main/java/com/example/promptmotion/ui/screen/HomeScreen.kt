package com.example.promptmotion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.promptmotion.ImageViewModel

@Composable
fun HomeScreen(viewModel: ImageViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

        val image = viewModel.state.value.image
        val isLoading = viewModel.state.value.isLoading
        image?.let {
            Image(
                painter = rememberImagePainter(data = image.imageUrl,
                    builder = { crossfade(true) }
                ),
                contentDescription = null,
                modifier = Modifier
                    .width(400.dp)
                    .height(300.dp)
                    .padding(top = 80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = image.date,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = image.description)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button(
            onClick = viewModel::getRandomImage,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Next Knock!")
        }
        Spacer(Modifier.height(8.dp))
        if (isLoading) {
            CircularProgressIndicator()
        }
    }

}