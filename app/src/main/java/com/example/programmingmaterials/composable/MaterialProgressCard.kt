package com.example.programmingmaterials.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.programmingmaterials.model.MaterialProgressUiModel
import com.example.programmingmaterials.ui.theme.ProgrammingMaterialsTheme


@Composable
fun MaterialProgressCard(uiModel: MaterialProgressUiModel) {
    val (materialName: String, categoryName: String, status: String) = uiModel
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)) {
        Text(materialName, fontWeight = FontWeight.Bold, maxLines = 1, softWrap = false)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(categoryName, fontSize = 12.sp, color = Color.Gray)
            Text(text = status, fontSize = 12.sp)
        }
    }
}


@Composable
@Preview(showBackground = true, widthDp = 200)
fun MaterialProgressPreview() {
    ProgrammingMaterialsTheme {
        MaterialProgressCard(MaterialProgressUiModel("Material 1", "Category 1", "Started"))
    }
}


@Composable
@Preview(showBackground = true, widthDp = 200)
fun MaterialProgressPreviewLongLines() {
    ProgrammingMaterialsTheme {
        MaterialProgressCard(
            MaterialProgressUiModel(
                "Material 1 with very long string in material name",
                "Category 1",
                "Started"
            )
        )
    }
}
