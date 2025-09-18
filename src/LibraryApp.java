import java.util.*;
import java.sql.*;
public class LibraryApp {
    public static void main(String[] args) {
        final String url="jdbc:mysql://localhost:3306/lib";
        final String user="root";
        final String pass="soumya";
        try(Connection conn= DriverManager.getConnection(url,user,pass)){
            BookDAO bookDAO = new BookDAO(conn);
            ViewAllBooks v= new ViewAllBooks();
            Addbook add= new Addbook();
            DeleteBook del= new DeleteBook();
            UpdateBook updatebook = new UpdateBook();
            SearchBook searchbook= new SearchBook();
            OpenPDF openpdf= new OpenPDF();
            Scanner sc= new Scanner(System.in);
            int choice;
            do{
                System.out.println("\n Library Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Delete Book");
                System.out.println("4. Update Book");
                System.out.println("5. Search Book by Title or Author");
                System.out.println("6. Open Book PDF");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        var newBook= add.addbook(bookDAO,sc);
                        if(bookDAO.addBook(newBook)){
                            System.out.println("Book added successfully.");
                        } else{
                            System.out.println("Failed to add book.");
                        }
                        break;
                    case 2:
                        v.view(bookDAO);
                        break;
                    case 3:
                        del.delete(bookDAO,sc);
                        break;
                    case 4:
                        updatebook.update(bookDAO,sc);
                        break;
                    case 5:
                        searchbook.search(bookDAO,sc);
                        break;
                    case 6:
                        v.view(bookDAO);
                        openpdf.openPDF(bookDAO,sc);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while(choice!=7);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection failed or other error occurred.");
        }
    }
}