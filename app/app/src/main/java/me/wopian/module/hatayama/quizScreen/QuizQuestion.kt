package me.wopian.module.hatayama.quizScreen

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_quiz_question.*
import me.wopian.module.hatayama.R
import me.wopian.module.hatayama.getFlagResource
import java.util.*

/**
 * Shows a static leaderboard with multiple users.
 */
class QuizQuestion : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val quiz = Quizzes().getRandomQuiz()

        if (quiz !is Quiz) {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_question_to_quiz)
        }

        (activity as AppCompatActivity).supportActionBar?.title = quiz?.name
        quiz_description.text = quiz?.description

        if(quiz?.quizType == QuizType.IMAGE) question_flag.setImageResource(getFlagResource(resources, quiz.countryCode.toLowerCase(Locale.ENGLISH)))

        quiz?.shuffle()
        val options = quiz?.getOptions()

        if (options is List) {
            quiz_question_one_text.text = options[0]
            quiz_question_two_text.text = options[1]
            quiz_question_three_text.text = options[2]
            quiz_question_four_text.text = options[3]

            fun setBackgroundColor(card: CardView, color: Int) {
                card.setCardBackgroundColor(color)
            }

            fun setCorrectAnswer(card: CardView) {
                setBackgroundColor(card, Color.GREEN)
            }

            fun setRealCorrectAnswer(card: CardView) {
                setBackgroundColor(card, Color.YELLOW)
            }

            fun setCorrectAnswerWhenUserIncorrect() {
                when (quiz.correctOption()) {
                    0 -> setRealCorrectAnswer(quiz_question_one)
                    1 -> setRealCorrectAnswer(quiz_question_two)
                    2 -> setRealCorrectAnswer(quiz_question_three)
                    3 -> setRealCorrectAnswer(quiz_question_four)
                    /*
                    QuizOption.ONE -> setRealCorrectAnswer(quiz_question_one)
                    QuizOption.TWO -> setRealCorrectAnswer(quiz_question_two)
                    QuizOption.THREE -> setRealCorrectAnswer(quiz_question_three)
                    QuizOption.FOUR -> setRealCorrectAnswer(quiz_question_four)
                     */
                }
            }


            fun setIncorrectAnswer(card: CardView) {
                setBackgroundColor(card, Color.RED)
                setCorrectAnswerWhenUserIncorrect()
            }

            fun nextQuestion() {
                // Prevent further answers
                quiz_question_one.setOnClickListener(null)
                quiz_question_two.setOnClickListener(null)
                quiz_question_three.setOnClickListener(null)
                quiz_question_four.setOnClickListener(null)
                // Continue to next question
                quiz_next.visibility = View.VISIBLE
                quiz_next.setOnClickListener {
                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_question_to_question)
                }
            }

            quiz_question_one.setOnClickListener {
                if (quiz.isCorrect(0)) setCorrectAnswer(quiz_question_one)
                else setIncorrectAnswer((quiz_question_one))
                nextQuestion()
            }
            quiz_question_two.setOnClickListener {
                if (quiz.isCorrect(1)) setCorrectAnswer(quiz_question_two)
                else setIncorrectAnswer((quiz_question_two))
                nextQuestion()
            }
            quiz_question_three.setOnClickListener {
                if (quiz.isCorrect(2)) setCorrectAnswer(quiz_question_three)
                else setIncorrectAnswer((quiz_question_three))
                nextQuestion()
            }
            quiz_question_four.setOnClickListener {
                if (quiz.isCorrect(3)) setCorrectAnswer(quiz_question_four)
                else setIncorrectAnswer((quiz_question_four))
                nextQuestion()
            }
        }
    }
}