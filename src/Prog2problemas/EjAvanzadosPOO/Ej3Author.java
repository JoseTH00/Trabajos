package Prog2problemas.EjAvanzadosPOO;

class Author {
    private String name, email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        if (gender=='m' || gender=='f') {
            this.gender = gender;
        } else {
            this.gender = 'm';
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }

    public static void main(String[] args) {
        Author author = new Author("Jose Thorlet","joseoscarthorlet@gmail.com",'m');
        System.out.println(author);
        Author author1 = new Author("Ana Thorlet","anitathorlet@gmail.com",'f');
        System.out.println(author1);
        Author author2 = new Author("Kuno","kunopelele@gmail.com",'o');
        System.out.println(author2);
    }
}
