
public class App {
    public static void main(String[] args) {
        // Temperature calculator
        System.out.println("Celsius to fahrenheit " + celsiusToFahrenheit(30));
        System.out.println("Fahrenheit to celsius " + fahrenheitToCelsius(89));
        // Calculate age and tell if can vote
        System.out.println(canVote(ageCalculator(2000, 2026)));
        // password checker
        System.out.println(checkPasswordStrength("ackhim"));
        // Calculate subtotal
        double subtotal = calculateSubtotal(15000, 15000);
        double discount = calculateDiscount(subtotal);
        double finalTotal = calculateFinalTotal(subtotal, discount);
        // print
        System.out.println("Sub total: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Final total: " + finalTotal);
        // number analyzer
        System.out.println(analyzeNumber(-24.5));
    }

    static float celsiusToFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }

    static float fahrenheitToCelsius(float fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }

    // Age Calculator
    static int ageCalculator(int birthYear, int currentYear){
        if(birthYear > currentYear){
            throw new Error("Age can't be greater than current year!");
        }
        
        return currentYear - birthYear;
    }

    static boolean canVote(int age){
        if(age < 18){
            return false;
        }
        return true;
    }
    
    static String checkPasswordStrength(String password){
        if(password == null || password.isEmpty()){
          return "Invalid (empty)";
        }

        boolean hasMinLength = password.length() > 8;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSymbols = false;

        String allowedSymbols = "@#!$%^&*-";

        for(int i = 0; i < password.length(); i++){
            char ch = password.charAt(i);

            if(Character.isUpperCase(ch)){
                hasUppercase = true;
            }else if(Character.isLowerCase(ch)){
                hasLowercase = true;
            }else if(Character.isDigit(ch)){
                hasDigit = true;
            }else if(allowedSymbols.indexOf(ch) != -1){
                hasSymbols = true;
            }
        }

        int requirementMets = 0;
        if(hasMinLength) requirementMets++;
        if(hasDigit) requirementMets++;
        if(hasLowercase) requirementMets++;
        if(hasUppercase) requirementMets++;
        if(hasSymbols) requirementMets++;

        String strength;
        if(requirementMets == 4){
            strength = "strong";
        }else if(requirementMets >= 2){
            strength = "medium";
        }else{
            strength = "weak";
        }

        StringBuilder missing = new StringBuilder();
        if(!hasMinLength) missing.append(" 8 characters,");
        if(!hasDigit) missing.append(" a number,");
        if(!hasLowercase) missing.append(" a lowercase letter,");
        if(!hasUppercase) missing.append(" an uppercase letter,");
        if(!hasSymbols) missing.append(" a symbol");

        if(missing.length() == 0){
            return strength + " -- meets all requirements";
        }else{
            String missingList = missing.substring(0, missing.length());
            return strength + " -- password must contain at least" + missingList;
        }
    }

    static double calculateSubtotal(double... amounts){
        double subtotal = 0;
    
        for(double amount : amounts){
            subtotal += amount;   
        }

        return subtotal;
    }

    static double calculateDiscount(double subtotal){
        if(subtotal > 50000){
            return 0.1;
        }else if(subtotal > 20001){
            return subtotal * 0.05;
        }else {
            return 0;
        }
    }

    static double calculateFinalTotal(double subtotal, double discount){
        return subtotal - discount;
    }

    static String analyzeNumber(double number){
        String numberSign;
        String numberType = (number == Math.floor(number)) ? "Integer" : "Decimal";
        String isEven = number % 2 == 0? "Even" : "Odd";

        if (number > 0) {
            numberSign = "Positive";
        } else if (number < 0) {
            numberSign = "Negative";
        } else {
            numberSign = "Zero";
        }

        return String.format("%s / %s / %s", numberSign, isEven, numberType);
    }

}
