import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args){
        // Array Basics
        String[] languages = {"JavaScript", "Python", "Java", "C#", "Go", "PHP", "Ruby", "TypeScript"}; // imutable array
        System.out.println("First item => " + languages[0]); // first item
        System.out.println("Last item => " + languages[languages.length - 1]); // last item
        System.out.println("Item at index 3 => " + languages[3]); // item at index 3
        System.out.println("Array length => " + languages.length); // array length
        languages[5] = "C"; // change one item
        System.out.println(Arrays.toString(languages));

        ArrayList<String> languageList = new ArrayList<>(List.of("JavaScript", "Python", "Java", "C#", "Go", "PHP", "Ruby", "TypeScript")); // mutable array
        System.out.println(languageList);
        languageList.add("C"); // adding new item
        System.out.println(languageList);
        languageList.remove("PHP");
        System.out.println(languageList);

        // Student Score Analyzer
        int[] scores = {78, 92, 65, 88, 54, 71, 96, 83};
        // calculate the total score
        int totalScore = 0;
        for(int score : scores){
            totalScore +=score;
        }
        // calculate the avarage score
        double avarageScore = totalScore / scores.length;
        System.out.println("Total score" + totalScore);
        System.out.println("Avarage score" + avarageScore);
        // highest score
        int max = scores[0];
        int min = scores[0];
        for(int score : scores){
            if(score > max){
                max = score;
            }else{
                min = score < min? score:min;
            }
        }

        System.out.println("max score => " + max);
        System.out.println("min score => " + min);

        // passed student
        int passMark = 70;
        int numberOfPassedStudent = 0;
        int numberOfFailedStudent = 0;

        for(int score : scores){
            if(score > passMark){
                numberOfPassedStudent++;
            }else{
                numberOfFailedStudent++;
            }
        }

        System.out.println("Number of passed student: " + numberOfPassedStudent);
        System.out.println("Number of failed student: " + numberOfFailedStudent);

        ScoreAnalysis analysis = analyzeScore(scores);
        System.out.println(analysis.avarageScore);

        Product[] products = {new Product("iPhone 12", 440000, 2), new Product("HP Revolve 810", 240000, 1)};
        System.out.println("Total products " + products.length);

        Product mostExpensiveProduct = products[0];
        Product cheapProduct = products[0];
        double initialPrice = products[0].price;

        for(Product product : products){
            if(product.price > initialPrice){
                mostExpensiveProduct = product;
            }
            if(product.price < initialPrice) cheapProduct = product;
        }

        double cartTotal = 0;
        for(Product product : products){
            cartTotal = product.price * product.quantity;
        }
        
        System.out.println("Most expensive product is " + mostExpensiveProduct.name);
        System.out.println("Cheapest product is " + cheapProduct.name);
        System.out.println("Cart total " + cartTotal);

        // Array Search
        User[] users = {
            new User("Tram", "tram@gmail.com", "user"),
            new User("barry", "barry@gmail.com", "user"),
            new User("Aikuo", "aikuo@gmail.com", "admin"),
            new User("Kiavo", "kiavo@gmail.com", "admin")
        };

        User found = User.findUserByEmail("barry@gmail.com", users);
        System.out.println(found.name);

        List<User> admins = User.findAdmins(users);
        for(User admin : admins){
            System.out.println("admin " + admin.name);
        }

        // find users by role
        List<User> userList = User.findUserByRole("user", users);
        for(User user : userList){
            System.out.println("User's list by role " + user.name);
        }

        // Array Transformation
        int[] prices = {1000, 2500, 5000, 7500, 10000};
        double[] discountedPrices = Arrays.stream(prices).mapToDouble(price -> price * 0.1).toArray();
        for(double price : discountedPrices){
            System.out.println("Price with 10 percent discount: " + price);
        }

        // prices above 5000.
        int[] pricesAbove5000 = Arrays.stream(prices).filter(price -> price > 5000).toArray();
        for(int price : pricesAbove5000){
            System.out.println("Price above 5000 => " + price);
        }

        int[] pricesBelow5000 = Arrays.stream(prices).filter(price -> price < 5000).toArray();
        for(int price : pricesBelow5000){
            System.out.println(price);
        }

        int[] sortedPrices = Arrays.stream(prices).sorted().toArray();
        System.out.println(Arrays.toString(sortedPrices));
    }

    // Creating analysis object
    static class ScoreAnalysis {
        int totalScore;
        int avarageScore;
        int max;
        int min;
        int numberOfPassedStudent;
        int numberOfFailedStudent;
        
        ScoreAnalysis(int total, int avarage, int max, int min, int passed, int failed){
            this.totalScore = total;
            this.avarageScore = avarage;
            this.max = max;
            this.min = min;
            this.numberOfFailedStudent = failed;
            this.numberOfPassedStudent = passed;
        }
    }

    static ScoreAnalysis analyzeScore(int[] scores){
        int totalScore = 0;
        int max = scores[0];
        int min = scores[0];
        int numberOfPassedStudent = 0;
        int numberOfFailedStudent = 0;
        int passMark = 50;

        for(int score : scores){
            totalScore += score;
            if(score > max) max = score;
            if(score < min) min = score;
            if(score > passMark) numberOfPassedStudent++;
            else numberOfFailedStudent++;
            
        }

        int avarageScore = totalScore / scores.length;
        return new ScoreAnalysis(totalScore, avarageScore, max, min, numberOfPassedStudent, numberOfFailedStudent);
    }

    // Built the Object
    static class Product{
        String name;
        double price;
        int quantity;

        Product(String name, double price, int quantity){
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    // users
    static class User{
        String name;
        String email;
        String role;

        User(String name, String email, String role){
            this.name = name;
            this.email = email;
            this.role = role;
        }

        static User findUserByEmail(String email, User[] users){
            for(User user : users){
                if(user.email.equalsIgnoreCase(email)){
                    return user;
                }
            }
            return  null;
        }

        static List<User> findAdmins(User[] users){
            ArrayList<User> admins = new ArrayList<>();

            for(User user : users){
                if(user.role.equals("admin")) admins.add(user);
            }

            return admins;
        }

        static User checkUser(User user, User[] users){
            for(User u : users){
                if(u.email.equals(user.email) && u.name.equals(user.name) && u.role.equals(user.role)) return u;
            }
            return null;
        }

        static List<User> findUserByRole(String role, User[] users){
            ArrayList<User> usersList = new ArrayList<>();
            for(User user : users){
                if(user.role.equals(role)) usersList.add(user);
            }
            return usersList;
        }

    }

    static void sortPriceDescendingOrder(int[] prices) {
        Arrays.sort(prices);
    }
}