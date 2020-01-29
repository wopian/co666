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
