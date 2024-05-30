package com.example.daggersimmpleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.daggersimmpleproject.chat.screen.SingleChatFragment
import com.example.daggersimmpleproject.ui.theme.DaggerSimmpleProjectTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(MainFragment { openFragment(SingleChatFragment()) })
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.fragment_container,
            fragment
        ) // fragment_container is the ID of the container in your activity's layout
        transaction.addToBackStack(null) // Optional: adds the transaction to the back stack
        transaction.commit()
    }

}