import java.util.Scanner;

public class DeleteBook {
    public void delete(BookDAO bookDAO, Scanner sc){
        System.out.print("Enter book title to delete: ");
        String title=sc.nextLine();
        if(bookDAO.deletebook(title)){
            System.out.println("Book deleted successfully.");
        } else{
            System.out.println("Book not found or deletion failed");
        }
    }
}
