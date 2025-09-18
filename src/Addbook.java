import java.util.List;
import java.util.Scanner;

public class Addbook {
    public Book addbook(BookDAO bookDAO, Scanner sc){
        System.out.print("Enter title: ");
        String title= sc.nextLine();
        System.out.print("Enter author: ");
        String author= sc.nextLine();
        System.out.print("Enter file path: ");
        String pdfPath= sc.nextLine();
        List<Book> existing= bookDAO.searchbook(title);
        boolean alreadyexists = false;
        for(Book b: existing){
            if(b.getTitle().equalsIgnoreCase(title) && b.getAuthor().equalsIgnoreCase(author)){
                alreadyexists=true;
                break;
            }
        }
        if(alreadyexists){
            System.out.println("The book is already present in the library.");
            return null;
        }

        return new Book(title,author,pdfPath);
    }
}
