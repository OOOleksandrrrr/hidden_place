package com.example.hiddenplace.screen

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.room.Delete
import com.example.hiddenplace.Eptit
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage(context : Context){

        val coroutineScope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()

        Scaffold(
            scaffoldState = scaffoldState,
            snackbarHost = { host ->
                SnackbarHost(hostState = host){ data ->
                    Snackbar(
                        backgroundColor = Color.White,
                        snackbarData = data,
                        shape = RoundedCornerShape(20.dp),
                        contentColor = Color.Green,
                        modifier = Modifier.padding(bottom = 100.dp)
                    )
                }
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Menu")
                    },
                    backgroundColor = Color.White,
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch{
                                    val result = scaffoldState.snackbarHostState.showSnackbar(
                                        message = "Item deleted!",
                                        actionLabel = "Undone"
                                    )
                                    if(result == SnackbarResult.ActionPerformed){
                                        Toast.makeText(context, "Item recovered", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Delete")
                        }
                        IconButton(
                            onClick = {
                                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Share,
                                contentDescription = "Share")
                        }
                    }
                )
            },
            drawerContent = {
                Menu()
                MenuBody()
            }
        ) {

        }

}



/*
fun MainPage(){




    val epta = listOf<Eptit>(
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("aaaaaaas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 9),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdar1s", 11234124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 124),
        Eptit("asdas", 1),
        Eptit("asdas", 124)
    )
    val epa = epta.size
    val ep = epa / 2 + epa % 2

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier
                .defaultMinSize(50.dp, 150.dp)
        ) {
            items(10){pos ->
                                    Card(
                        modifier = Modifier
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = epta[pos].name)
                            Text(text = epta[pos].pos.toString())
                        }
                    }
            }

        }
        LazyColumn(
            modifier = Modifier
                .defaultMinSize(50.dp, 150.dp)
        ) {
            items(9){pos ->
                Card(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = epta[pos].name)
                        Text(text = epta[pos].pos.toString())
                    }
                }
            }

        }
    }
}*/

