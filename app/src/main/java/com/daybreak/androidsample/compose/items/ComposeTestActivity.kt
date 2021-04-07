package com.daybreak.androidsample.compose.items

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daybreak.androidsample.R
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue;
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class ComposeTestActivity : ComponentActivity() {
    val viewModel by viewModels<HelloViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewStory(viewModel)
        }
    }
}

@Composable
fun NewStory(helloViewModel: HelloViewModel) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.requiredHeight(16.dp))
            Text("A day wandering through the sandhills " +
                    "in Shark Fin Cove, and a few of the " +
                    "sights I saw",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text("Davenport, California",
                style = typography.body2)
            Text("December 2018",
                style = typography.body2)

            HelloScreen(helloViewModel = helloViewModel)

            ExpandingCard(title = "Hello World", body = "GuoTianqi")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewStory(viewModel())
}

@Composable
fun HelloScreen(helloViewModel: HelloViewModel) {
    val name by helloViewModel.name.observeAsState("")
    val (value, setValue)= remember {
        mutableStateOf("")
    }
    HelloContent(name, onNameChange = { helloViewModel.onNameChange(it) });
    val (a, setA)= Test()
}

class Test {
    var a: Int = 0
        get() = 1
        set(value) {
            field = value
        }

    operator fun component1(): Int = a
    operator fun component2(): (value: Int) -> Unit = { a = it}
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

class HelloViewModel : ViewModel() {

    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    // onNameChange is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Composable
fun ExpandingCard(title: String, body: String) {
    var expanded by remember { mutableStateOf(false) }

    // describe the card for the current state of expanded
    Card {
        Column(
            Modifier
                .width(280.dp)
                .animateContentSize() // automatically animate size when it changes
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = title)
//            Text(text = "Guo Tianqi")

            // content of the card depends on the current value of expanded
            if (expanded) {
                Text(text = body, Modifier.padding(top = 8.dp))
                // change expanded in response to click events
                IconButton(onClick = { expanded = false }, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.ExpandLess, contentDescription = "Expand less")
                }
            } else {
                // change expanded in response to click events
                IconButton(onClick = { expanded = true }, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription = "Expand more")
                }
            }
        }
    }

//    data class City(val name: String, val country: String)
//
//    val CitySaver: Saver<City, Any> = run {
//        val nameKey = "Name"
//        val countryKey = "Country"
//        mapSaver(
//            save = { mapOf(nameKey to it.name, nameKey to it.country) },
//            restore = { City(it[nameKey] as String, it[countryKey] as String) }
//        )
//    }
//
//    @Composable
//    fun MyExample() {
//        var selectedCity = rememberSaveable(saver = CitySaver) { City("Madrid", "Spain") }
//    }
}