package ru.foxdev.anti_icing.controller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.foxdev.anti_icing.R
import ru.foxdev.anti_icing.model.Question

private const val TAG = "QuestionListFragment"

class QuestionListFragment:Fragment() {
    private lateinit var questionRecyclerView: RecyclerView
    private var adapter: QuestionAdapter? = null
    private val questionListViewModel: QuestionListViewModel by lazy {
        ViewModelProvider(this).get(QuestionListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total question: ${questionListViewModel.questions.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view = inflater.inflate(R.layout.fragment_question_list, container, false)
        questionRecyclerView = view.findViewById(R.id.question_recycler_view) as RecyclerView
        questionRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    private fun updateUI(){
        val questions = questionListViewModel.questions
        adapter = QuestionAdapter(questions)
        questionRecyclerView.adapter = adapter
    }

    private inner class QuestionHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener{

        private lateinit var question: Question

        private val titleTextView: TextView = itemView.findViewById(R.id.question_title)
        private val dateTextView: TextView = itemView.findViewById(R.id.question_date_of_creation)
        private val solvedImageView: ImageView = itemView.findViewById(R.id.question_solved)

        init {
            itemView.setOnClickListener(this)
        }



        fun bind(question: Question){
            this.question = question
            titleTextView.text = this.question.title
            dateTextView.text = this.question.date.toString()
            solvedImageView.visibility = if (question.isSolved) {
                View.VISIBLE
            }else {
                View.GONE
            }
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    private inner class QuestionAdapter(var questions: List<Question>) : RecyclerView.Adapter<QuestionHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
            val view = layoutInflater.inflate(R.layout.list_item_question, parent, false)
            return QuestionHolder(view)
        }

        override fun getItemCount() = questions.size

        override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
            val question = questions[position]
           holder.bind(question)
        }
    }

    companion object{
        fun newInstance(): QuestionListFragment{
            return QuestionListFragment()
        }
    }
}