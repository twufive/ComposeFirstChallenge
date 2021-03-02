/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetailPage(navController: NavHostController, dogIndex: String?) {
    val showDialogState = remember { mutableStateOf(false) }
    val isAdopted = remember { mutableStateOf(false) }

    dogIndex?.let {
        val dog = DogData.dogs[dogIndex.toInt()]
        if (showDialogState.value) {
            ShowDialog(dog) {
                showDialogState.value = false
                isAdopted.value = it
            }
        }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Dog Detail")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigate("dogList") {
                                    popUpTo("dogList") {
                                        inclusive = true
                                    }
                                }
                            }
                        ) {
                            Icon(
                                Icons.Filled.ArrowBack, contentDescription = null,
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                // 提示是否收养
                                showDialogState.value = true
                            }
                        ) {
                            if (isAdopted.value) {
                                Icon(
                                    Icons.Filled.Favorite, contentDescription = null,
                                    tint = Color.Red
                                )
                            } else {
                                Icon(
                                    Icons.Filled.Favorite, contentDescription = null,
                                )
                            }
                        }
                    }
                )
            },
        ) {
            DogDetail(navController, dog)
        }
    }
}

@Composable
fun DogDetail(navController: NavHostController, dog: Dog) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoilImage(
            data = dog.image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text("Name:${dog.name}", style = typography.h4)
        Spacer(modifier = Modifier.height(5.dp))
        Text("Code:${dog.code}", style = typography.body1)
        Spacer(modifier = Modifier.height(2.dp))
        Text("Age:${dog.age}", style = typography.body1)
        Spacer(modifier = Modifier.height(2.dp))
        Text("Color:${dog.color}", style = typography.body1)
        Spacer(modifier = Modifier.height(2.dp))
        Text("Address:${dog.address}", style = typography.body1)
    }
}

@Composable
fun ShowDialog(dog: Dog, onButtonClick: (Boolean) -> Unit) {
    AlertDialog(
        title = { Text(text = "Adopt ${dog.name}", style = typography.h6) },
        text = { Text(text = "are you sure?") },
        buttons = {
            Row {
                OutlinedButton(
                    onClick = { onButtonClick(false) },
                    modifier = Modifier
                        .padding(6.dp)
                        .weight(1f)
                ) {
                    Text(text = "Cancel")
                }
                Button(
                    onClick = { onButtonClick(true) },
                    modifier = Modifier
                        .padding(6.dp)
                        .weight(1f)
                ) {
                    Text(text = "Ok")
                }
            }
        },
        onDismissRequest = { onButtonClick(false) }
    )
}
