public class CartItem {

//    private String[] itemBook = new String[7];
    private Book itemBook;
    private String bookID;
    private int quantity;
    private int totalPrice;

    /*
    public CartItem(String[] book) {
        this.itemBook = book;
        this.bookID = book[0];
        this.quantity = 1; // 기본 수량은 1로 설정
        updateTotalPrice();
    }
    */
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public CartItem(Book booklist) {
        this.itemBook = booklist;
        this.bookID = booklist.getBookId();
        this.quantity = 1; // 기본 수량은 1로 설정
        updateTotalPrice();
    }

//    public Book getItemBook() { return itemBook; }
//
//    public void setItemBook(String[] itemBook) { this.itemBook = itemBook; }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void updateTotalPrice() {
//        totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity; //문자열을 정수로 변환하여 가격 계산
        totalPrice = this.itemBook.getUnitPrice() * this.quantity;
    }
}
