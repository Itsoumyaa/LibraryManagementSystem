import java.util.*;
import java.sql.*;
public class BookDAO {
    private Connection conn;
    public BookDAO(Connection conn){
        this.conn=conn;
    }
    public boolean addBook(Book book){
        String query="INSERT INTO books (title, author, file_path) VALUES (?,?,?)";
        try(PreparedStatement pstm= conn.prepareStatement(query)){
            pstm.setString(1,book.getTitle());
            pstm.setString(2,book.getAuthor());
            pstm.setString(3,book.getPdfpath());
            pstm.executeUpdate();
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Book> getAllBooks(){
        List<Book> books= new ArrayList<>();
        String query= "SELECT *  FROM books";
        try(Statement stm= conn.createStatement(); ResultSet rs= stm.executeQuery(query)){
            while(rs.next()){
                Book book= new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("file_path")
                );
                books.add(book);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } return books;
    }
    public boolean deletebook(String name){
        String query="DELETE FROM books WHERE title=?";
        try(PreparedStatement pstm= conn.prepareStatement(query)){
            pstm.setString(1,name);
            int affectedrows=pstm.executeUpdate();
            return affectedrows > 0;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatebook(Book book){
        String query="UPDATE books SET title= ?, author= ? , file_path= ? WHERE id=?";
        try(PreparedStatement pstm= conn.prepareStatement(query)){
            pstm.setString(1, book.getTitle());
            pstm.setString(2, book.getAuthor());
            pstm.setString(3, book.getPdfpath());
            pstm.setInt(4, book.getId());
            int affectedrows= pstm.executeUpdate();
            return affectedrows>0;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public List<Book> searchbook(String s){
        List<Book> books= new ArrayList<>();
        String query="SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try(PreparedStatement pstm= conn.prepareStatement(query)){
            String pattern="%" + s + "%";
            pstm.setString(1,pattern);
            pstm.setString(2,pattern);
            ResultSet rs= pstm.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String title= rs.getString("title");
                String author=rs.getString("author");
                String pdfPath=rs.getString("file_path");
                books.add(new Book(id,title,author,pdfPath));
            }
        } catch(SQLException e){
            e.printStackTrace();
        } return books;
    }
    public Book getBookById(int id){
        String query="SELECT * FROM books WHERE id=?";
        try(PreparedStatement pstm= conn.prepareStatement(query)){
            pstm.setInt(1,id);
            ResultSet rs= pstm.executeQuery();
            if(rs.next()){
                return new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("file_path")
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } return null;
    }


}
