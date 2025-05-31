import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요 : ");
        String userName = input.next();

        System.out.print("연락처를 입력하세요 : ");
        int userMobile = input.nextInt();

//        System.out.println("Welcome to Shopping Mall");
//        System.out.println("Welocme to Book Market");

        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market";

        System.out.println("**********************************************************");
        System.out.println("\t\t\t\t" + greeting);
        System.out.println("\t\t\t\t" + tagline);

        /*
        System.out.println("***********************************************************");
        System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println(" 7. 영수증 표시하기 \t\t\t8. 종료");
        System.out.println("***********************************************************");
         */

        menuIntroduction();

        System.out.print("메뉴 번호를 선택해주세요 :");
        int n = input.nextInt();
//        System.out.println(n + "번 메뉴를 선택하셨습니다.");

        boolean quit = false;
        while (!quit) {
            if  (n < 1 || n > 8)
                System.out.println("1부터 8까지의 메뉴 번호를 선택해주세요.");
            else {
                switch (n) {
                    case 1:
//                        System.out.println("현재 고객 정보 :");
//                        System.out.println("이름 : " + userName + ", 연락처 : " + userMobile);
                        menuGuestInfo(userName, userMobile);
                        break;
                    case 2:
                        System.out.println("장바구니 상품 목록 보기 :");
                        break;
                    case 3:
                        System.out.println("장바구니 비우기");
                        break;
                    case 4:
                        System.out.println("바구니에 항목 추가하기 : ");
                        break;
                    case 5:
                        System.out.println("장바구니의 항목 수량 줄이기");
                        break;
                    case 6:
                        System.out.println("장바구니의 항목 삭제하기");
                        break;
                    case 7:
                        System.out.println("영수증 표시하기");
                        break;
                    case 8:
                        System.out.println("프로그램을 종료합니다.");
                        quit = true;
                        break;
                } //switch문 종료
            } //if문 종료
        } //while문 종료
    } // main 메소드 종료
    public static void menuIntroduction() {
        System.out.println("***********************************************************");
        System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println(" 7. 영수증 표시하기 \t\t\t8. 종료");
        System.out.println("***********************************************************");
    }

    public static void menuGuestInfo(String name, int mobile) {
        System.out.println("현재 고객 정보 :");
        System.out.println("이름 : " + name + ", 연락처 : " + mobile);
    }
}