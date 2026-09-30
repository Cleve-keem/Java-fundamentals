public class Main {
    public static  void main(String[] args){
        // Task 1 — Personal Profile
        String name = "Hakeem";
        int age = 30;
        String country = "Nigeria";
        boolean isStudent = false;
        String favoriteProgrammingLanguage = "JavaScript";
        int yearsOfCoding = 3;

        String status = isStudent? "student" : "not a student";

        System.out.println(name + " is " + age + " years old." + " He is from " + country + " and his favorite language is " + favoriteProgrammingLanguage + " with " + yearsOfCoding + "years of coding experience and he is " + status);

        System.out.format("User would be: %d, in 5 years%n", age + 5);
        System.out.format("User would be: %d, in 10 years%n", age + 10);
        System.out.format("User would be: %d, in 20 years%n", age + 20);

        // Task 2 — Simple Calculator
        int firstNumber = 20;
        int secondNumber = 0;

        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber - secondNumber);
        System.out.println(firstNumber * secondNumber);
        
        if(secondNumber != 0){
            System.out.println(firstNumber % secondNumber);
            System.out.println(firstNumber / secondNumber);
        }

        // Task 3 — Student Grade Calculator
        int English = 78;
        int Mathematics = 85;
        int JavaScript = 92;
        int Design = 90;

        int totalScore = English + Mathematics + JavaScript + Design;
        int avarageScore = totalScore / 4;

        System.out.println(calculateGrade(avarageScore));

        // Task 4 - Login Validator
        String username = "admin";
        String password = "123456";

        if(username.isEmpty() || password.isEmpty()){
            System.out.println("Invalid username or password!");
        }else if(password.length() < 5){
            System.out.println("password must contain at least 5 characters!");
        }else if(username != "admin" || password != "12345"){
            System.out.println("Invalid username or password!");
        }
        else{
            System.out.println("Login successful");
        }
        
        // Task 5 - Mini Expense Calculator
        int food = 5000;
        int transport = 3000;
        int internet = 7000;
        int entertainment = 4000;
        int income = 100000;

        int totalExpenses = food + transport + internet + entertainment;
        int averageExpense = totalExpenses / 4;

        int highestExpense = Math.max(food, Math.max(transport, Math.max(internet, entertainment)));
        int balance = income - totalExpenses;

        System.out.println(averageExpense);
        System.out.println(highestExpense);
        System.out.println(balance);

        System.out.println(calculateExpenses(100, 300, 600, 7000));
    }

    static String calculateGrade(int score){
        if(score >= 90 && score <= 100){
            return "A";
        }else if(score >= 80){
            return "B";
        }else if(score >= 70){
            return "C";
        }else if(score >= 60){
            return "D";
        }else if(score >= 0){
            return "F";
        }else{
            return "Invalid grade!";
        }
    }

    // calculate expense
    static double calculateExpenses(double... amounts){
        double total = 0;
        for(double amount : amounts){
            total += amount;
        }
        return total;
    }
}