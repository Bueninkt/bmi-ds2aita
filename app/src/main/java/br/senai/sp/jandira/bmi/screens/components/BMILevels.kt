package br.senai.sp.jandira.bmi.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BMILevel(
    leftText: String = "Texto da Esquerda",
    rightText: String = "Texto da Direita",
    bulletColor: Color = Color.LightGray,
    background: Color = Color.Transparent
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card (
            modifier = Modifier
                .size(10.dp),
            shape = CircleShape,
            colors = CardDefaults
                .cardColors(
                    containerColor = bulletColor
                )
        ){  }
        Spacer(modifier = Modifier.width(16.dp))
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults
                .cardColors(
                    containerColor = background
                )
        ){
            Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = leftText)
            Text(text = rightText)
        }
        }

    }
}

@Preview
@Composable
private fun BMILevelPreview() {
    BMILevel()
}