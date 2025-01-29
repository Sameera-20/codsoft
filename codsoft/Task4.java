//QUIZ APPLICATION WITH TIMER


import java.util.*;
import java.util.concurrent.TimeUnit;

class Question 
{
    String question;
    String[] options;
    String correct;
    public Question(String question, String[] options, String correct) 
    {
        this.question=question;
        this.options=options;
        this.correct=correct;
    }
    public void displayQuestion()
    {
        System.out.println(question);
        for(int i=0;i<options.length;i++)
        {
            System.out.println((i+1)+"."+options[i]);
        }
    }
}

class Task4 
{
    private static final int TIMER_LIMIT= 10; 
    private static List<Question> questions;
    private static int score = 0;
    private static int currentQuestionIndex = 0;

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        initializeQuestions();
        System.out.println("Welcome to the Quiz! You have "+TIMER_LIMIT+" seconds to answer each question.");
        System.out.println("Let's start!\n");
        for (currentQuestionIndex=0; currentQuestionIndex < questions.size(); currentQuestionIndex++)
        {
            Question currentQuestion = questions.get(currentQuestionIndex);
            currentQuestion.displayQuestion();
            boolean answeredCorrectly = askQuestionWithTimer(s, currentQuestion);
            if (answeredCorrectly)
            {
                score++;
            }
        }
        System.out.println("\nQuiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
    private static void initializeQuestions()
    {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of china?", new String[]{"Shanghai", "Chengdu", "Beijing", "Guilin"},"Beijing"));
        questions.add(new Question( "What is slang name for New York city?", new String[]{"The Big Apple", "Sin City",
                     "Beantown", "Tinseltown"}, "The Big Apple"));
        questions.add(new Question("Who wrote 'Harry Potter'?",new String[]{"J.K.Rowling", "Charles Dickens", "Mark Twain", 
                      "Jane Austen"},"J.K.Rowling"));
    }

     private static boolean askQuestionWithTimer(Scanner s, Question question)
    {
        long startTime = System.currentTimeMillis();

        System.out.print("You have " + TIMER_LIMIT + " seconds to answer. Your answer: ");
        String userAnswer = null;
        while (System.currentTimeMillis() - startTime < TIMER_LIMIT * 1000) 
        {
            if (s.hasNextLine()) 
            {
                userAnswer = s.nextLine();
                break;
            }
        }
        if (userAnswer == null || userAnswer.trim().isEmpty()) 
        {
            System.out.println("Time's up! You didn't answer in time.");
            return false;
        }
        if (userAnswer.equalsIgnoreCase(question.correct)) 
        {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect! The correct answer was: " + question.correct);
            return false;
        }
    }
}
