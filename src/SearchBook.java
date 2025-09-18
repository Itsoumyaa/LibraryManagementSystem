import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchBook {
    public void search(BookDAO bookDAO , Scanner sc){
        System.out.print("Enter search keyword: ");
        String keyword= sc.nextLine();
        List<Book> result= bookDAO.searchbook(keyword);
        if(result.isEmpty()){
            System.out.println("No matching books found,");
        } else{
            System.out.println("Search results: ");
            System.out.printf("%-5s %-30s %-25s %-40s%n", "ID", "Title", "Author", "PDF Path");
            System.out.println("----------------------------------------------------------------------------------------------");

            for (Book book : result) {
                System.out.printf("%-5d %-30s %-25s %-40s%n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPdfpath());
            }
        }


    }
}
