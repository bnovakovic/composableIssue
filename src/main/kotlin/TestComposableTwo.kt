import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun TestComposableTwo(viewModelTwo: ViewModelTwo) {

    val currentIndex by viewModelTwo.currentListItem.collectAsState()
    println("Index is: $currentIndex")
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

    ) {
        // At the point where we recreate this composable view, currentIndex keeps it's old value, and then changes it
        // to the new one causing the app to crash since new list does not have index of 1
        Text(text = viewModelTwo.stringList[currentIndex])
        Button(onClick = {
            viewModelTwo.changeIndex()
        }) {
            Text("Click me before clicking button above")
        }
    }

}