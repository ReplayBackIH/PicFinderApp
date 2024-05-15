package com.example.picfinder.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.picfinder.R
import com.example.picfinder.ui.theme.PicFinderTypography

@Composable
fun MainScreen(navController: NavController) {

    val textFieldText = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            singleLine = true,
            value = textFieldText.value,
            onValueChange = { userInput ->
                textFieldText.value = userInput
            },
            label = {
                Text(text = "Search for")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = "search_icon"
                )
            },
            keyboardActions = KeyboardActions(
                onNext = {
                    /*TODO*/
                }
            )
        )
        Spacer(
            modifier = Modifier
                .padding(15.dp)
        )
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Button(modifier = Modifier
                .padding(end = 18.dp),
                onClick = {
                    /*TODO*/
                }) {
                Text(
                    text = "Search"
                )
            }
        }
    }

}