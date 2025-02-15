package dharsh_new;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuizApplication {

    private static final int TIME_LIMIT = 30; // Time limit for the quiz in seconds
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Start timer thread
        TimerThread timerThread = new TimerThread(TIME_LIMIT);
        Thread timer = new Thread(timerThread);
        timer.start();

        // Display welcome message and instructions
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + TIME_LIMIT + " seconds to complete the quiz.");
        
        // Quiz questions and answers
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "A) Paris", "B) London", "C) Rome", "D) Berlin", 'A'));
        questions.add(new Question("Who is the CEO of Tesla?", "A) Jeff Bezos", "B) Elon Musk", "C) Bill Gates", "D) Mark Zuckerberg", 'B'));
        questions.add(new Question("What is the largest planet in our solar system?", "A) Earth", "B) Mars", "C) Jupiter", "D) Saturn", 'C'));
        questions.add(new Question("Who wrote 'To Kill a Mockingbird'?", "A) J.K. Rowling", "B) Harper Lee", "C) Jane Austen", "D) Mark Twain", 'B'));
        questions.add(new Question("What is 5 + 3?", "A) 7", "B) 8", "C) 9", "D) 10", 'B'));

        // Start quiz
        for (Question question : questions) {
            if (timerThread.isTimeUp()) {
                break;
            }

            System.out.println("\n" + question.getQuestion());
            System.out.println(question.getOptionA());
            System.out.println(question.getOptionB());
            System.out.println(question.getOptionC());
            System.out.println(question.getOptionD());
            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.next().toUpperCase().charAt(0);

            if (answer == question.getCorrectAnswer()) {
                score++;
            }
        }

        // End of quiz, show results
        System.out.println("\nQuiz over!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
        
        scanner.close();
    }

    static class TimerThread implements Runnable {
        private final int timeLimit;
        private boolean timeUp = false;

        public TimerThread(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(timeLimit);
                timeUp = true;
                System.out.println("\nTime's up! The quiz has ended.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public boolean isTimeUp() {
            return timeUp;
        }
    }

    static class Question {
        private final String question;
        private final String optionA;
        private final String optionB;
        private final String optionC;
        private final String optionD;
        private final char correctAnswer;

        public Question(String question, String optionA, String optionB, String optionC, String optionD, char correctAnswer) {
            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOptionA() {
            return optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public char getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
