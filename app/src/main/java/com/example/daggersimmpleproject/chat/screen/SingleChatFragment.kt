package com.example.daggersimmpleproject.chat.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.daggersimmpleproject.MyApplication
import com.example.daggersimmpleproject.utils.RxUtilsAbs
import javax.inject.Inject

class SingleChatFragment : Fragment() {

    @Inject
    lateinit var rxUtilsAbs: RxUtilsAbs

    @Inject lateinit var serviceFactory: SCPresenterFactory
    lateinit var scPresenter: ISCPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ------------ for subcomponent

        val chatSubComponent =
            (requireActivity().application as MyApplication).plusChatComponent()
        val scSubComponent = (requireActivity().application as MyApplication).plusSCComponent()

        scSubComponent.inject(this)


        // -------------

        // check rxUtilsAbs is the same object as in MainFragment cos @Reusable
        println(rxUtilsAbs)

        scPresenter = serviceFactory.create("chatId")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "SingleChatFragment")
                            Text(text = scPresenter.getChatId())
                        }
                    }
                }
            }
        }
    }
}