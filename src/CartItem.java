public class CartItem {

    private String[] itemBook = new String[7];
    private String bookID;
    private int quantity;
    private int totalPrice;

    public CartItem(String[] book) {
        this.itemBook = book;
        this.bookID = book[0];
        this.quantity = 1; // 기본 수량은 1로 설정
        updateTotalPrice();
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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
        totalPrice = Integer.parseInt(this.itemBook[2]) * this.quantity; //문자열을 정수로 변환하여 가격 계산
    }
}
