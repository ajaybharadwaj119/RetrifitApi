package com.aj.retrofitapi.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aj.retrofitapi.ui.theme.RetrofitApiTheme

class MainActivity : ComponentActivity() {

    private val viewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   bankScreen(viewModel)
                }
            }
        }
    }

    @Composable
    private fun bankScreen(viewModel: BankViewModel) {
        val bankData by viewModel.bankLiveData.observeAsState()

        LaunchedEffect(Unit){
            viewModel.fetchBankDetails()
        }

        Column{
            when(bankData){
                null-> Text("Loading")
                else->{
                    Column(Modifier.padding(10.dp)) {
                        Text(text = bankData!!.count)

                    }
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitApiTheme {
        Greeting("Android")
    }
}