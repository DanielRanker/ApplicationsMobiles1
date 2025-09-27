package ca.qc.listeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.qc.listeapp.ui.theme.ListeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ItemList(
                        modifier = Modifier.padding(innerPadding)
                   )
                }
            }
        }
    }
}

@Composable
fun ItemList(modifier: Modifier = Modifier) {
    val items = listOf("Apples", "Bananas", "Carrots", "Dates")

    androidx.compose.foundation.lazy.LazyColumn(
        modifier = modifier
    ) {
        items(items.size) { index ->
            Text(
                text = items[index],
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemsListPreview() {
    ListeAppTheme {
        ItemList()
    }
}