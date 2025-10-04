package ca.qc.listeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import ca.qc.listeapp.ui.theme.ListeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItemListScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemListScreen(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(listOf("Apples", "Bananas")) }
    var newItem by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Input Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = newItem,
                onValueChange = { newItem = it },
                label = { Text("New item") },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (newItem.isNotBlank()) {
                        items = items + newItem
                        newItem = ""
                    }
                }
            ) {
                Text("Add")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(){
            items(items.size){ index ->
                Text(
                    text = items[index],
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemsListPreview() {
    ListeAppTheme {
        ItemListScreen()
    }
}