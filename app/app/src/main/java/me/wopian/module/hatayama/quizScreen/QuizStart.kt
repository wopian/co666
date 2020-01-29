package me.wopian.module.hatayama.quizScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import me.wopian.module.hatayama.R

/**
 * Shows a static leaderboard with multiple users.
 */
class QuizStart : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Quiz"

        view.findViewById<Button>(R.id.startQuiz).setOnClickListener {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_quiz_to_question)
        }
    }
}