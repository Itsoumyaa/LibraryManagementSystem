import java.util.List;

public class ViewAllBooks {
    public void view(BookDAO bookDAO){
        List<Book> books= bookDAO.getAllBooks();
        if(books.isEmpty()){
            System.out.println("No books found");
        } else{
            System.out.println("Book List: ");
            System.out.printf("%-5s %-30s %-25s %-40s%n", "ID", "Title", "Author", "PDF Path");
            System.out.println("----------------------------------------------------------------------------------------------");

            for (Book book : books) {
                System.out.printf("%-5d %-30s %-25s %-40s%n",
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPdfpath());
            }
        }
    }
}