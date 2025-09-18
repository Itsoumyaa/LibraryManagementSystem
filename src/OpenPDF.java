import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpenPDF {
    private void open(String filePath) {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(filePath));
            System.out.println("PDF opened: " + filePath);
        } catch (Exception e) {
            System.out.println("Failed to open PDF.");
            e.printStackTrace();
        }
    }
    public void openPDF(BookDAO  bookDAO, Scanner scanner){
        System.out.print("Enter Book ID to open PDF: ");
        int bookIdToOpen = scanner.nextInt();
        scanner.nextLine();
        Book book=bookDAO.getBookById(bookIdToOpen);
        if(book!=null){
            open(book.getPdfpath());
        } else{
            System.out.println("Book not found.");
        }
    }

}
