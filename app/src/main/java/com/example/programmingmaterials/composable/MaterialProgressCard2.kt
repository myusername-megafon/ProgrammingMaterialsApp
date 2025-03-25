package com.example.programmingmaterials.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme


@Composable
fun MaterialProgressCard2(uiModel: MaterialProgressUiModel, cardColor: Color) {
    Box(
        modifier = Modifier
            .height(120.dp)
            .width(185.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(cardColor)
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .width(150.dp)
                    .height(45.dp),
                contentDescription = null,
                imageVector = Icons.AutoMirrored.Default.ArrowBack
            )
            Text(
                text = uiModel.materialName,
                color = Color.Black,
                fontSize = 14.sp
            )
            Text(
                text = uiModel.categoryName,
                color = Color.Black,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
@Preview(showBackground = true, widthDp = 200)
fun MaterialProgress2Preview() {
    ProgrammingMaterialsTheme {
        MaterialProgressCard2(
            MaterialProgressUiModel("Material 1", "Category 1", "Started"),
            cardColor = Color.LightGray
        )
    }
}

