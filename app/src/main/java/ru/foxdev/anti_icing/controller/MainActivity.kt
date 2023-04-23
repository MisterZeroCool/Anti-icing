package ru.foxdev.anti_icing.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.foxdev.anti_icing.R
import java.util.UUID

class MainActivity : AppCompatActivity(), QuestionListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null){
            val fragment = QuestionListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }

    override fun onQuestionSelected(questionId: UUID) {
        val fragment = QuestionFragment.newInstance(questionId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }

}
