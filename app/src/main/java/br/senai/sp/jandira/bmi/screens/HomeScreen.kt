package br.senai.sp.jandira.bmi.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons


import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun HomeScreen() {

    val nameState = remember {
        mutableStateOf("")
    }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xF7FFC107),
                        Color(0xFFFFC000)
                    )
                )
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally


        )

        {

            Image(
                painter = painterResource(
                    R.drawable.fitness
                ),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        top = 32.dp
                    )
            )
            Text(
                text = stringResource(
                    R.string.welcome
                ),
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold


            )
            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 60.dp,
                    topEnd = 60.dp

                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End


                ){
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()

                    ){
                        Text(
                            text = stringResource(
                                R.string.your_name
                            ),
                            fontSize = 24.sp


                        )
                        TextField(
                            value =  nameState.value,
                            onValueChange = {
                                nameState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 10.dp
                                ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "",
                                    tint = Color.Blue
                                )
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences

                            )
                        )
                    }
                    Button(onClick = {}) {
                        Text(
                            text = stringResource(
                                R.string.next
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()

}