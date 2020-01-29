package me.wopian.module.hatayama.quizScreen

// TODO automate by generating questions on the fly from database fields
var quizList: MutableList<Quiz> = mutableListOf(
        Quiz(
                name = "Question", description = "Which one of these countries do not have a flag consisting of Red, Blue and White?",
                option1 = "Transvaal", option2 = "Mordova", option3 = "Norway", option4 = "Nepal",
                correct = QuizOption.ONE, quizType = QuizType.TEXT
        ),
        Quiz(
                name = "Question", description = "When was the current Flag of the Netherlands adopted?",
                option1 = "1575", option2 = "1815", option3 = "1946", option4 = "1734",
                correct = QuizOption.ONE, quizType = QuizType.TEXT
        ),
        Quiz(
                name = "Question", description = "Which country is this flag from?",
                option1 = "Greenland", option2 = "Poland", option3 = "Indonesia", option4 = "Japan",
                correct = QuizOption.ONE, quizType = QuizType.IMAGE, countryCode = "GL"
        )
)

var unseenQuizList = quizList.toMutableList()

enum class QuizType {
    TEXT, IMAGE
}

enum class QuizOption {
    ONE, TWO, THREE, FOUR
}

class Quiz(var name: String, var description: String, private var option1: String, private var option2: String, private var option3: String, private var option4: String, private var correct: QuizOption, var quizType: QuizType, var countryCode: String = "") {
    private var shuffledOptions = arrayListOf(QuizOption.ONE, QuizOption.TWO, QuizOption.THREE, QuizOption.FOUR).shuffled()
    private var correctOption = shuffledOptions[shuffledOptions.indexOf(correct)]

    private fun shuffledOption(option: QuizOption): String {
        return when (option) {
            QuizOption.ONE -> option1
            QuizOption.TWO -> option2
            QuizOption.THREE -> option3
            QuizOption.FOUR -> option4
        }
    }

    fun shuffle() {
        shuffledOptions = shuffledOptions.shuffled()
        correctOption = shuffledOptions[shuffledOptions.indexOf(correct)]
    }

    fun getOptions(): List<String> {
        return listOf(shuffledOption(shuffledOptions[0]), shuffledOption(shuffledOptions[1]), shuffledOption(shuffledOptions[2]), shuffledOption(shuffledOptions[3]))
    }

    fun isCorrect(optionPicked: Int): Boolean {
        return shuffledOptions[optionPicked] == correctOption
    }

    fun correctOption(): Int {
        return shuffledOptions.indexOf(correctOption)
    }
}

class Quizzes {
    fun getRandomQuiz(): Quiz? {
        return if (unseenQuizList.isNotEmpty()) {
            val selectedQuiz = unseenQuizList.shuffled().first()
            val index = unseenQuizList.indexOf(selectedQuiz)
            unseenQuizList.removeAt(index)
            selectedQuiz
        } else {
            unseenQuizList = quizList.toMutableList()
            null
        }
    }
}