package Prog2problemas.EjAvanzadosPOO;

import java.util.Arrays;

class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthorNames() {
        StringBuilder authorNames = new StringBuilder();
        for (int i = 0; i < authors.length; i++) {
            authorNames.append(authors[i].getName());
            if (i != authors.length - 1) {
                authorNames.append(", ");
            }
        }
        return authorNames.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }

    public static void main(String[] args) {
        Author author1 = new Author("John Doe", "johndoe@gmail.com", 'M');
        Author author2 = new Author("Jane Doe", "janedoe@gmail.com", 'F');

        Author[] authors = {author1, author2};
        Book book1 = new Book("Java Programming", authors, 29.99);
        Book book2 = new Book("Advanced Java", new Author[]{author1}, 35.99, 10);

        System.out.println(book1);
        System.out.println("Author names: " + book1.getAuthorNames());

        book1.setPrice(24.99);
        book1.setQty(5);
        System.out.println("Updated Book: " + book1);

        System.out.println(book2);
        System.out.println("Author names: " + book2.getAuthorNames());
    }
}
