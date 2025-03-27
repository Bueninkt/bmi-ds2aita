package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance

import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Height

import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Numbers

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun userDateScreen(modifier: Modifier = Modifier){

    val ageState = remember {
        mutableStateOf("")
    }

    val weightState = remember {
        mutableStateOf("")
    }

    val heightState = remember {
        mutableStateOf("")
    }


    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)
        val username = userFile.getString("user_name", "User name not found!")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF9D00FF),
                        Color(0xFF583BFF),
                    )
                )
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = stringResource(R.string.hi) + ", $username!" ,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(32.dp)
                    .weight(1f)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    ),

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(130.dp),
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 2.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFF9D00FF),
                                            Color(0xFFFF0000),
                                        )
                                    )

                                )
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.homem),
                                    contentDescription = ""
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                colors = ButtonDefaults
                                    .buttonColors(
                                        containerColor = Color(0xFF0900FF)
                                    )
                            ) {
                                Text(
                                    text = stringResource(R.string.male),

                                    )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) { Card(
                            modifier = Modifier
                                .size(130.dp),
                            shape = CircleShape,
                            border = BorderStroke(
                                width = 2.dp,
                                brush = Brush.linearGradient(
                                    listOf(
                                        Color(0xFF9D00FF),
                                        Color(0xFFFF0000),
                                    )
                                )

                            )
                        ) {
                            Image(
                                painter = painterResource(R.drawable.mulher),
                                contentDescription = ""
                            )
                        }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                colors = ButtonDefaults
                                    .buttonColors(
                                        containerColor = Color(0xFF0900FF)
                                    )
                            ) {
                                Text(
                                    text = stringResource(R.string.female),

                                    )
                            } }

                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.age)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = ""
                                )

                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {weightState.value = it
                                             },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(16.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = ""
                                )
                            },



                            label = {
                                Text(
                                    text = stringResource(R.string.weight)
                                )
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )

                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",

                                    )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.height)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            )

                        )

                    }
                    Button(
                        onClick = {
                            val editor = userFile.edit()
                            editor.putInt("user_age", ageState.value.toInt())
                            editor.putInt("user_weight", weightState.value.toInt())
                            editor.putFloat("user_height", heightState.value.toFloat())
                            editor.apply()

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color(0xff9c27b0)
                            )
                    ) {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 20.sp
                        )
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun userDateScreenPreview() {
    userDateScreen()
}