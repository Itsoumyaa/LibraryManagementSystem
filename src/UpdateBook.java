import java.util.Scanner;

public class UpdateBook {
    public void update(BookDAO bookDAO, Scanner sc){
        System.out.print("Enter ID of the book to update: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new title: ");
        String title=sc.next();
        System.out.print("Enter new author: ");
        String author=sc.next();
        System.out.print("Enter new path: ");
        String pdfPath=sc.next();
        Book updatedBook= new Book(id,title,author,pdfPath);
        if(bookDAO.updatebook(updatedBook)){
            System.out.println("Book updated successfully.");
        } else{
            System.out.println("Book not found.");
        }
    }
}
