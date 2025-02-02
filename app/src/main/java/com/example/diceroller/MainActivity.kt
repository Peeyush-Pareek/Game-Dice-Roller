package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                DiceRollerApp()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DiceRollerTheme {
//        Greeting("Android")
//    }
//}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier)
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier) {
   // var result = 1 /* fixed value */
    /* The mutableStateOf() function returns an observable.
    when the button is tapped, the result variable is updated with a random number value.*/
    var result by remember { mutableStateOf(1) }
    /*an immutable imageResource variable set
    to a when expression that accepts a result variable
    and then set each possible result to its drawable. */
    val imageResource= when(result){
        1-> R.drawable.dice_1
        2-> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5-> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
Column (
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
) {
   /* Image(
        painter = painterResource(R.drawable.dice_1),
        contentDescription = "1"
    )*/
    Image(
        painter = painterResource(imageResource),
        contentDescription = result.toString()
    )
    Spacer(modifier=Modifier.height(16.dp))
    Button(onClick = {result=(1..6).random()}) {
        Text(stringResource(R.string.roll))
    }
}
}