
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navegacao: NavHostController?){

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("user_file", Context.MODE_PRIVATE)
    val userName = userFile.getString("user_name", "")

    var ageState = remember{
        mutableStateOf("")
    }
    var weightState = remember{
        mutableStateOf("")
    }
    var heightState = remember{
        mutableStateOf("")
    }


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
                text = stringResource(R.string.hi) + ", $userName!",
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
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(R.string.age)
                                )
                            },
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions =  KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
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
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions =  KeyboardOptions(
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
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions =  KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )

                        )

                    }
                    Button(
                        onClick = {
                            val editor = userFile.edit()
                            editor.putInt("user_age", ageState.value.toInt())
                            editor.putFloat("user_weight", weightState.value.toFloat())
                            editor.putFloat("user_height", heightState.value.toFloat())
                            editor.apply()
                            navegacao!!.navigate("bmi_result")
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
private fun UserDataScreenPreview() {
    UserDataScreen(null)
}
