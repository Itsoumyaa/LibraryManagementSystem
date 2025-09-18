public class Book {
    private int id;
    private String title;
    private String author;
    private String pdfpath;

    public Book(int id, String title, String author, String pdfpath){
        this.id=id;
        this.title=title;
        this.author=author;
        this.pdfpath=pdfpath;
    }
    public Book( String title, String author, String pdfpath){
        this.title=title;
        this.author=author;
        this.pdfpath=pdfpath;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){ return title;}
    public String getAuthor(){ return author;}
    public String getPdfpath(){ return pdfpath;}
    public String toString(){
        return "Book{" +
                "id;" + id +
                ",title='"+ title+'\''+
                ",author='"+ author +'\''+
                ",pdfPath='"+ pdfpath+'\''+
                        '}';
    }

}
