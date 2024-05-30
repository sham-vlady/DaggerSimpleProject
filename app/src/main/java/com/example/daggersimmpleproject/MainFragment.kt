package com.example.daggersimmpleproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.daggersimmpleproject.data.IDataRepository
import com.example.daggersimmpleproject.ui.theme.DaggerSimmpleProjectTheme
import com.example.daggersimmpleproject.utils.NetworkUtils
import com.example.daggersimmpleproject.utils.RxUtilsAbs
import com.example.daggersimmpleproject.translator.Translator
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Named

class MainFragment(private val onNextPageClick: () -> Unit) : Fragment() {

    @Inject
    lateinit var rxUtilsAbs: RxUtilsAbs

    @Inject
    lateinit var networkUtils: NetworkUtils

    @Inject
    lateinit var dataRepository: IDataRepository

    // TODO Provider<Executor> don't work
    @Inject
    @Named("SingleThread")
    lateinit var singleExecutorProvider: Executor

    @Inject
    @Named("MultiThread")
    lateinit var multiExecutorLazy: Executor

    @Inject
    @Named("MultiThread")
    lateinit var multiExecutorLazyCopy: Executor

    @Inject
    lateinit var translators: Set<@JvmSuppressWildcards Translator>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as MyApplication).appComponent.inject(this)

        // при каждом последующем вызове singleExecutorProvider.get() будет создаваться новый экземпляр
        val singleExecutor = singleExecutorProvider
        val singleExecutor2 = singleExecutorProvider

        // кэширует проинициализированные значения
        // multiExecutor и multiExecutor2 ссылаются на один объект, а multiExecutor3 на второй объект.
        val multiExecutor: Executor = multiExecutorLazy
        val multiExecutor2: Executor = multiExecutorLazy
        val multiExecutor3: Executor = multiExecutorLazyCopy

        println(rxUtilsAbs)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.padding(16.dp)) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            item {
                                Text(
                                    text = "Список доступных переводчиков:",
                                    style = MaterialTheme.typography.titleSmall
                                )
                            }
                            items(translators.toList(), key = { it.name }) {
                                Text(text = it.name)
                            }
                        }
                        Button(
                            modifier = Modifier.align(Alignment.BottomCenter),
                            onClick = onNextPageClick
                        ) {
                            Text(text = "Next page")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(bottom = 16.dp)
    )
    Button(onClick = onClick) {
        Text(text = "Next page")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerSimmpleProjectTheme {
        Greeting("Android", {})
    }
}