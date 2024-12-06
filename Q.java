

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Questions {
    String questionText;
    String[] options;
    int correctOption;

    // Constructor
    Questions(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    // Parse a CSV string into a Questions object
    public static Questions parseQuestions(String csv) {
        String[] ar = csv.split(",");
        if (ar.length != 3) throw new IllegalArgumentException("The CSV is not properly formatted");
        String questionText = ar[0];
        String[] options = ar[1].split("\\|");
        int correctAns = 0;
        try {
            correctAns = Integer.parseInt(ar[2]);
        } catch (NumberFormatException e) {
            System.out.println("Correct Option is not a properly formatted number");
        }
        return new Questions(questionText, options, correctAns);
    }

    // Convert a Questions object to a CSV string
    public String toCSV() {
        return questionText + "," + String.join("|", options) + "," + correctOption;
    }

    // Display the question and its options
    public void displayQuestions(int queNum) {
        System.out.println("Question No: " + (queNum + 1) + " " + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Check if a given option is correct
    public boolean isCorrect(int opt) {
        return correctOption == opt;
    }
}

 class Test {
    static Scanner sc = new Scanner(System.in);
    private static final String Question_File = "Book2.csv";
    static ArrayList<Questions> questionBank = loadQuestions();

    // Load questions from the file
    public static ArrayList<Questions> loadQuestions() {
        ArrayList<Questions> questions = new ArrayList<>();
        File file = new File(Question_File);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("Question file not found. Creating a new file: " + Question_File);
            try {
                file.createNewFile(); // Create an empty file
            } catch (IOException e) {
                System.out.println("Failed to create the file: " + e.getMessage());
            }
            return questions; // Return an empty list
        }

        // If the file exists, read questions from it
        try (BufferedReader br = new BufferedReader(new FileReader(Question_File))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(Questions.parseQuestions(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    // Save questions to the file
    public static void saveQuestions() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Question_File))) {
            for (Questions question : questionBank) {
                bw.write(question.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add a question to the question bank
    public static void addQuestion() {
        System.out.println("Enter Question Text:");
        String questionText = sc.nextLine();
        System.out.println("Enter Options separated with commas:");
        String options = sc.nextLine();
        System.out.println("Enter the Correct Option Number:");
        int answer = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        questionBank.add(new Questions(questionText, options.split(","), answer));
        saveQuestions();
        System.out.println("Question added successfully!");
    }

    // Conduct a quiz
    public static void conductQuiz() {
        if (questionBank.isEmpty()) {
            System.out.println("No questions available. Please add questions first.");
            return;
        }
        System.out.println("Enter number of questions for the quiz:");
        int len = sc.nextInt();
        if (len > questionBank.size()) {
            System.out.println("Insufficient questions for the quiz. Select a number less than or equal to " + questionBank.size());
            return;
        }
        int score = 0;
        for (int i = 0; i < len; i++) {
            Questions que = questionBank.get(i);
            que.displayQuestions(i);
            System.out.println("Enter the Correct Option:");
            int cop = sc.nextInt();
            if (que.isCorrect(cop))
                score++;
        }
        System.out.println("Your Final Score is: " + score);
    }

    // Main method to handle the menu and operations
    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("1. Add Questions\n2. Conduct Quiz\n3. Save Questions\n4. Exit");
            int op = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (op) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    conductQuiz();
                    break;
                case 3:
                    saveQuestions();
                    break;
                case 4:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid Option. Please try again.");
            }
        }
    }
}
