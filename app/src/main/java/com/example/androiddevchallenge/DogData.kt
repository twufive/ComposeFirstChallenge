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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

object DogData {

    val dogs by mutableStateOf(
        mutableListOf(
            Dog(
                0,
                89755,
                "Eric",
                "LA CJS KJK DSJ D",
                2,
                "Red",
                vac = true,
                ste = false,
                fav = false,
                adopt = false,
                R.drawable.dog1
            ),
            Dog(
                1,
                10655,
                "Nance",
                "HS CJS KJK DSJ D",
                1,
                "Blue",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog2
            ),
            Dog(
                2,
                108635,
                "Johnny",
                "HS CJS KJK DSJ D",
                3,
                "Yellow",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog3
            ),
            Dog(
                3,
                108635,
                "Steve",
                "HS CJS KJK DSJ D",
                3,
                "GRAY",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog4
            ),
            Dog(
                4,
                89755,
                "Eric",
                "LA CJS KJK DSJ D",
                2,
                "Red",
                vac = true,
                ste = false,
                fav = false,
                adopt = false,
                R.drawable.dog1
            ),
            Dog(
                5,
                10655,
                "Nance",
                "HS CJS KJK DSJ D",
                1,
                "Blue",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog2
            ),
            Dog(
                6,
                108635,
                "Johnny",
                "HS CJS KJK DSJ D",
                3,
                "Yellow",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog3
            ),
            Dog(
                7,
                108635,
                "Steve",
                "HS CJS KJK DSJ D",
                3,
                "GRAY",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog4
            ),
            Dog(
                8,
                89755,
                "Eric",
                "LA CJS KJK DSJ D",
                2,
                "Red",
                vac = true,
                ste = false,
                fav = false,
                adopt = false,
                R.drawable.dog1
            ),
            Dog(
                9,
                10655,
                "Nance",
                "HS CJS KJK DSJ D",
                1,
                "Blue",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog2
            ),
            Dog(
                10,
                108635,
                "Johnny",
                "HS CJS KJK DSJ D",
                3,
                "Yellow",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog3
            ),
            Dog(
                11,
                108635,
                "Steve",
                "HS CJS KJK DSJ D",
                3,
                "GRAY",
                vac = true,
                ste = true,
                fav = false,
                adopt = false,
                R.drawable.dog4
            )
        )
    )
}

data class Dog(
    val index: Int,
    val code: Int,
    val name: String,
    val address: String,
    val age: Int,
    val color: String,
    val vac: Boolean, // 疫苗
    val ste: Boolean, // 绝育
    val fav: Boolean,
    val adopt: Boolean,
    val image: Int,
)
