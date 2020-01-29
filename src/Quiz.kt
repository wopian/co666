class Quiz(
  var name: String, var description: String,
  private var option1: String, private var option2: String,
  private var option3: String, private var option4: String,
  private var correct: QuizOption, var quizType: QuizType,
  var countryCode: String = "") {
    private var shuffledOptions = arrayListOf(
      QuizOption.ONE, QuizOption.TWO,
      QuizOption.THREE, QuizOption.FOUR
    ).shuffled()

    private var correctOption = shuffledOptions[
      shuffledOptions.indexOf(correct)
    ]

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
        return listOf(
          shuffledOption(shuffledOptions[0]), shuffledOption(shuffledOptions[1]),
          shuffledOption(shuffledOptions[2]), shuffledOption(shuffledOptions[3])
        )
    }

    fun isCorrect(optionPicked: Int): Boolean {
        return shuffledOptions[optionPicked] == correctOption
    }

    fun correctOption(): Int {
        return shuffledOptions.indexOf(correctOption)
    }
}
