package com.inkoteam.compose_1


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inkoteam.compose_1.ui.theme.Compose_1Theme
import com.inkoteam.compose_1.ui.theme.Gray100


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(){
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Gray100)
                ) {
                    itemsIndexed (
                        listOf(
                            ItemRowModel(R.drawable.a1, "Deidara"),
                            ItemRowModel(R.drawable.a2, "Itachi"),
                            ItemRowModel(R.drawable.a3, "Pain"),
                            ItemRowModel(R.drawable.a4, "Kisame"),
                            ItemRowModel(R.drawable.a5, "Hidan"),
                            ItemRowModel(R.drawable.a6, "Kakuzu"),
                        )
                    ){ _, item ->
                        MyRow(item = item)
                    }
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Gray100)
                ) {
                    itemsIndexed (
                        listOf(
                            ItemRowModel(R.drawable.a1, "Deidara"),
                            ItemRowModel(R.drawable.a2, "Itachi"),
                            ItemRowModel(R.drawable.a3, "Pain"),
                            ItemRowModel(R.drawable.a4, "Kisame"),
                            ItemRowModel(R.drawable.a5, "Hidan"),
                            ItemRowModel(R.drawable.a6, "Kakuzu"),
                        )
                    ){ _, item ->
                        MyRow(item = item)
                    }
                }
            }
        }
    }

/* Часть 1 */
//@Preview (showBackground = true)
@Composable
fun NewText (){
    /* Горизонтальный контейнер, изменили бг и сделали на весь экран */
    Row(modifier = Modifier.fillMaxSize()){
        /* Вертикальный контейнер */
        Column(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxHeight()
                .fillMaxWidth(0.25f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Btn -")
            Text(text = "Btn -")
            Text(text = "Btn -")
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.66f),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Введите значение")
            Text(text = "Введите значение")
            Text(text = "Введите значение")
        }
        Column(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Btn +")
            Text(text = "Btn +")
            Text(text = "Btn +")
        }
    }
}

/* Часть 2 */
@Composable
private fun ListItem (name:String, prof: String){
    /* Используем состояния, чтобы счетчик перерисовывался на экране */
    var counter = remember {
        mutableStateOf(0)
    }
    /* shape - скругление углов
       elevation - эффект парения в воздухе */
    Card(
        modifier = Modifier
            /* clickable - нажатие на карточку, (код прописываем внутри) */
            .fillMaxWidth()
            /*pointerInput - Сможем отслеживать например нажатия, удерживания и т.д. */
            .clickable {
                counter.value++
            }
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                /* painter - какую картинку выбираем, contentDescription - просто что нибудь написать */
                Image(
                    painter = painterResource(id = R.drawable.pict),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop, // обрежет картинку
                    modifier = Modifier
                        .padding(5.dp)     // внутренние отступы
                        .size(64.dp)       // размер картинки
                        .clip(CircleShape) // круглая форма картинки
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = counter.value.toString())
                    Text(
                        text = prof,
                        color = Color.Red)
                }
            }
        }
    }
}

@Composable
private fun CircleItem (){
    var counter = remember {
        mutableStateOf(0)
    }
    var color = remember {
        mutableStateOf(Color.Blue)
    }
    Box(modifier = Modifier
        .size(100.dp)
        .background(color = color.value, shape = CircleShape)
        .clickable {
            counter.value++
            when (counter.value) {
                10 -> color.value = Color.Red
                25 -> color.value = Color.Green
            }
        },
        contentAlignment = Alignment.Center ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 20.sp)
        )
    }
    }
}
