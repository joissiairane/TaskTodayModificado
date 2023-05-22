package com.example.tasktodaymodificado

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktodaymodificado.ui.theme.TaskTodayModificadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent() {
    Scaffold (
        topBar = {
            TopAppBar(
                content = { Text(text = "TaskAppBar")}
                    )


        },
        content = {
            paddingValues -> Log.i("paddinValues","$paddingValues")
            Column(modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()
            ) {
               MySearchField(modificador = Modifier.fillMaxWidth())
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "PamI: Trabalhando com varias opções",
                    taskDetails = "Explicação da tarefa"
                    )
                Text("Task3")
                Text("Task4")
            }
        },
        bottomBar = {
            BottomAppBar(
                content = { Text("asdf")}
            )
        }
            )//Scaffold
}//fun MainScreenContent
@Composable
fun MySearchField(modificador: Modifier){
    TextField(
        value = "",
        onValueChange ={},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar tarefas")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon")
        }
        )
}
@Composable
fun MyTaskWidget(
    modificador:Modifier,
    taskName: String ,
    taskDetails:String
    ){
    Row(modifier = modificador) {
      Icon(
          imageVector = Icons.Default.Notifications,
          contentDescription = "Icons of a pendent task"
      )
    }
    Column(modifier = modificador
        .border(width = 1.dp, color = Color.Black)
        .padding(3.dp)
    ){
        Text(
            text = taskName,
            fontSize = 20.sp,
            fontWeight =  FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = taskDetails,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            FontStyle = FontStyle.Normal
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
 MainScreenContent()
}