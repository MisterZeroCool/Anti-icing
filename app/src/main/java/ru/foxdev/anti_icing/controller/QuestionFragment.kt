package ru.foxdev.anti_icing.controller

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import ru.foxdev.anti_icing.R
import ru.foxdev.anti_icing.model.Question
import java.util.UUID

private const val ARG_QUESTION_ID = "question_id"

class QuestionFragment:Fragment() {
    private lateinit var question: Question
    private lateinit var titleField: EditText
    private lateinit var answerField: EditText
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        question = Question()

        val questionId: UUID = arguments?.getSerializable(ARG_QUESTION_ID) as UUID
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_question, container, false)
        titleField = view.findViewById(R.id.question_title) as EditText
        answerField = view.findViewById(R.id.question_answer) as EditText
        dateButton = view.findViewById(R.id.question_date) as Button
        solvedCheckBox = view.findViewById(R.id.question_solved) as CheckBox

        dateButton.apply {
            text = question.date.toString()
            isEnabled = false
        }
        return view
    }

    //отображение заголовка и ответа
    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                question.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {setOnCheckedChangeListener{ _, isChecked -> question.isSolved = isChecked}
        }
    }

    companion object{
        fun newInstance(questionId: UUID): QuestionFragment{
            val args = Bundle().apply {
                putSerializable(ARG_QUESTION_ID, questionId)
            }
            return QuestionFragment().apply {
                arguments = args
            }
        }
    }
}