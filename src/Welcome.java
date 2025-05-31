public class Welcome {
    public static void main(String[] args) {

//        System.out.println("Welcome to Shopping Mall");
//        System.out.println("Welocme to Book Market");

        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market";

        System.out.println("**********************************************************");
        System.out.println("\t\t\t\t" + greeting);
        System.out.println("\t\t\t\t" + tagline);
        System.out.println("***********************************************************");

        System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println(" 7. 영수증 표시하기 \t\t\t8. 종료");
    }
}