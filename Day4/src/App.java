import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Product;
import models.Student;

public class App {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Wireless Mouse", 12000, "Accessories", true),
            new Product(2, "Mechanical Keyboard", 80000, "Accessories", false),
            new Product(3, "USB-C Hub", 25000, "Accessories", true),
            new Product(4, "Mechanical Keyboard", 65000, "Accessories", true),
            new Product(5, "Gaming Monitor", 180000, "Monitors", false),
            new Product(6, "Wireless Headphones", 95000, "Audio", true),
            new Product(7, "Webcam", 45000, "Cameras", false)
        };

        for (Product product : products) {
            System.out.println(Product.formatProduct(product.name, product.price, product.inStock));
        }

        String[] productNames = Product.getProductNames(products);
        System.out.println(Arrays.toString(productNames));

        Product foundProduct = Product.findProductsById(products, 2);
        System.out.println(foundProduct.name);

        double totalCatalogValue = Product.getTotalCatalogValue(products);
        System.out.println(totalCatalogValue);

        Map<String, List<Product>> groupedProducts = Product.groupByCategory(products);
        System.out.println(groupedProducts);

        Student[] students = {
            new Student(1, "David", 85, "Mathematics"),
            new Student(2, "Sarah", 72, "English"),
            new Student(3, "Michael", 48, "Physics"),
            new Student(4, "Grace", 91, "Chemistry"),
            new Student(5, "Daniel", 56, "Biology"),
            new Student(6, "Esther", 39, "Mathematics"),
            new Student(7, "James", 67, "Computer Science"),
            new Student(8, "Mary", 78, "Physics"),
            new Student(9, "John", 44, "English"),
            new Student(10, "Deborah", 95, "Computer Science")
        };

        Student[] passingStudents = Student.getPassingStudents(students, 50);
        System.out.println(Arrays.toString(passingStudents));

        double averageScore = Student.getAverageScore(students);
        System.out.println(averageScore);

        Student topStudent = Student.getTopStudent(students);
        System.out.println("Top Student is " + topStudent.name + " with the score of " + topStudent.score);

        Student[] studentsWithGrades = Student.addStudentGrades(students);
        for (Student student : studentsWithGrades) {
            System.out.println(student.name + " has " + student.grade + " in " + student.subject);
        }
    }

    static String assignGrade(int score) {
        if (score >= 90 && score <= 100) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else if (score >= 50) {
            return "E";
        } else if (score >= 0) {
            return "F";
        } else
            return "Invalid score";
    }
}
