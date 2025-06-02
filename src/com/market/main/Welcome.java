package com.market.main;

import com.market.cart.Cart;
import com.market.member.Admin;
import com.market.member.User;
import com.market.bookitem.Book;
import com.market.exception.CartException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Welcome {
    static final int NUM_BOOK = 3; // 도서의 개수에 대한 상수
    static final int NUM_ITEM = 7; // 각 도서에 대한 항목의 개수에 대한 상수
//    static CartItem[] mCartItem = new CartItem[NUM_BOOK]; // 장바구니에 담을 도서 정보 배열
//    static int mCartCount = 0; // 장바구니에 담긴 항목의 개수

    static Cart mCart = new Cart();
    static User mUser; // 사용자 정보 객체

    public static void main(String[] args) {
//        String[][] mBook = new String[NUM_BOOK][NUM_ITEM]; // 도서 정보 2차원 배열
//        Book[] mBookList = new Book[NUM_BOOK]; // 도서 정보 배열
        Book[] mBookList;
        int mTotalBook = 0; // 총 도서 개수

        Scanner input = new Scanner(System.in);

        System.out.print("당신의 이름을 입력하세요 : ");
        String userName = input.next();

        System.out.print("연락처를 입력하세요 : ");
        String userMobile = input.next();

        mUser = new User(userName, userMobile);

//        System.out.println("Welcome to Shopping Mall");
//        System.out.println("Welocme to Book Market");

        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market";



        /*
        System.out.println("***********************************************************");
        System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println(" 7. 영수증 표시하기 \t\t\t8. 종료");
        System.out.println("***********************************************************");
         */

//        System.out.println(n + "번 메뉴를 선택하셨습니다.");

        boolean quit = false;
        while (!quit) {
            menuIntroduction();

//            System.out.println("***********************************************************");
            System.out.println("\t\t\t\t" + greeting);
            System.out.println("\t\t\t\t" + tagline);
            System.out.println("***********************************************************");

            try {
                System.out.print("메뉴 번호를 선택해주세요 :");
                int n = input.nextInt();

//            if  (n < 1 || n > 8)
//                System.out.println("1부터 8까지의 메뉴 번호를 선택해주세요.");
                if (n < 1 || n > 9)
                    System.out.println("1부터 9까지의 메뉴 번호를 선택해주세요.");
                else {
                    switch (n) {
                        case 1:
//                        System.out.println("현재 고객 정보 :");
//                        System.out.println("이름 : " + userName + ", 연락처 : " + userMobile);
                            menuGuestInfo(userName, userMobile);
                            break;
                        case 2:
//                        System.out.println("장바구니 상품 목록 보기 :");
                            menuCartItemList();
                            break;
                        case 3:
//                        System.out.println("장바구니 비우기");
                            menuCartClear();
                            break;
                        case 4:
//                        System.out.println("바구니에 항목 추가하기 : ");
//                        menuCartAddItem(mBook);
                            mTotalBook = totalFileToBookList();
                            mBookList = new Book[mTotalBook]; // 도서 정보 배열 생성
                            menuCartAddItem(mBookList);
                            break;
                        case 5:
//                        System.out.println("장바구니의 항목 수량 줄이기");
                            menuCartRemoveItemCount();
                            break;
                        case 6:
//                        System.out.println("장바구니의 항목 삭제하기");
                            menuCartRemoveItem();
                            break;
                        case 7:
//                        System.out.println("영수증 표시하기");
                            menuCartBill();
                            break;
                        case 8:
//                        System.out.println("프로그램을 종료합니다.");
                            menuExit();
                            quit = true;
                            break;
                        case 9:
                            menuAdminLogin();
                            break;
                    } //switch문 종료
                } //if문 종료
            } // try문 종료
            catch (CartException e) {
                System.out.println(e.getMessage());
                quit = true;
            }
            catch (Exception e) {
                System.out.println("올바르지 않은 메뉴 선택으로 종료합니다.");
                quit = true;
            } // catch문 종료
        } //while문 종료
    } // main 메소드 종료
    public static void menuIntroduction() {
        System.out.println("***********************************************************");
        System.out.println(" 1. 고객 정보 확인하기 \t\t4. 바구니에 항목 추가하기");
        System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
        System.out.println(" 3. 장바구니 비우기 \t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println(" 7. 영수증 표시하기 \t\t\t8. 종료");
        System.out.println(" 9. 관리자 로그인");
        System.out.println("***********************************************************");
    }

    public static void menuGuestInfo(String name, String mobile) {
        System.out.println("현재 고객 정보 :");
//        System.out.println("이름 : " + name + ", 연락처 : " + mobile);
//        Person person = new Person(name, mobile);
//        System.out.println("이름 : " + person.getName() + ", 연락처 : " + person.getPhone());
        System.out.println("이름 : " + mUser.getName() + "   연락처 : " + mUser.getPhone());
    }

    public static void menuCartItemList() {
        /*System.out.println("장바구니 상품 목록 : ");
        System.out.println("---------------------------------------------------------");
        System.out.println("    도서ID \t\t|    수량 \t|    합계");
        for (int i = 0; i < mCartCount; i++) {
            System.out.print("    " + mCartItem[i].getBookID() + "\t| ");
            System.out.print("    " + mCartItem[i].getQuantity() + "\t\t| ");
            System.out.println("    " + mCartItem[i].getTotalPrice());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");*/

        if (mCart.mCartCount >= 0)
            mCart.printCart();
    }

    public static void menuCartClear() throws CartException {
//        System.out.println("3. 장바구니 비우기");
        if (mCart.mCartCount == 0) throw new CartException("장바구니에 항목이 없습니다.");

        else{
            System.out.println("장바구니를 비우시겠습니까? Y | N");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();

            if (str.toUpperCase().equals("Y")) {
                System.out.println("장바구니의 모든 항목을 삭제했습니다.");
                mCart.deleteBook();
            }
        }
    }

    public static void menuCartAddItem(Book[] booklist) {
//        System.out.println("4. 장바구니에 항목 추가하기");
        BookList(booklist);

        /*
        for (int i = 0; i < NUM_BOOK; i++) {
            for (int j = 0; j < NUM_ITEM; j++)
                System.out.print(book[i][j] + " | ");
            System.out.println();
        }
        */
        mCart.printBookList(booklist);

        boolean quit = false;
        while (!quit) {
            System.out.println("장바구니에 추가할 도서의 ID를 입력하세요.");

            Scanner input = new Scanner(System.in);
            String str = input.nextLine();

            boolean flag = false;
            int numId = -1;

            for (int i = 0; i < NUM_BOOK; i++) {
                if (str.equals(booklist[i].getBookId())) {
                    numId = i;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("장바구니에 추가하시곘습니까? Y | N");
                str = input.nextLine();

                if (str.toUpperCase().equals("Y")) {
                    System.out.println(booklist[numId].getBookId() + " 도서를 장바구니에 추가했습니다.");

                    // 카트에 넣기
                    if (!isCartInBook(booklist[numId].getBookId()))
                        mCart.insertBook(booklist[numId]);
                }
                quit = true;
            }
            else
                System.out.println("다시 입력해 주세요");
        } // while문 종료
    }

    public static void menuCartRemoveItemCount() {
        System.out.println("5. 장바구니의 항목 수량 줄이기");
    }

    public static void menuCartRemoveItem() throws CartException {
//        System.out.println("6. 장바구니의 항목 삭제하기");
        if (mCart.mCartCount == 0)
            throw new CartException("장바구니에 항목이 없습니다.");
//            System.out.println("장바구니에 담긴 항목이 없습니다.");
        else {
            menuCartItemList();
            boolean quit = false;
            while (!quit) {
                System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
                Scanner input = new Scanner(System.in);
                String str = input.nextLine();
                boolean flag = false;
                int numId = -1;

                for (int i = 0; i < mCart.mCartCount; i++) {
                    if (str.equals(mCart.mCartItem[i].getBookID())) {
                        numId = i;
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.println("장바구니에서 삭제하시곘습니까? Y | N");
                    str = input.nextLine();

                    if (str.toUpperCase().equals("Y")) {
                        System.out.println(mCart.mCartItem[numId].getBookID() + " 도서를 장바구니에서 삭제했습니다.");
                        mCart.removeCart(numId);
                    }
                    quit = true;
                } else {
                    System.out.println("다시 입력해 주세요");
                    ;
                }
            }
        }
    }

    public static void menuCartBill() throws CartException {

//        System.out.println("7. 영수증 표시하기");
        if (mCart.mCartCount == 0) throw new CartException("장바구니에 항목이 없습니다.");

        else {
            System.out.println("배송받을 고객 정보와 같습니까? Y | N");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();

            if (str.toUpperCase().equals("Y")) {
                System.out.print("배송지를 입력해주세요 :");
                String address = input.nextLine();
                printBill(mUser.getName(), String.valueOf(mUser.getPhone()), address);

            }
            else {
                System.out.print("배송받을 고객명을 입력하세요 :");
                String name = input.nextLine();
                System.out.print("배송받을 고객의 연락처를 입력하세요 :");
                String phone = input.nextLine();
                System.out.print("배송받을 고객의 배송지를 입력해주세요 :");
                String address = input.nextLine();
                printBill(name, phone, address);
            }
        }
    }

    public static void printBill(String name, String phone, String address) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM//dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println();
        System.out.println("----------------배송받을 고객 정보----------------");
        System.out.println("고객명 : " + name + "    \t\t연락처 : " + phone);
        System.out.println("배송지 : " + address + "    \t\t배송일 : " + strDate);

        mCart.printCart(); // 장바구니에 담긴 도서 목록 출력

        int sum = 0;
        for (int i = 0; i < mCart.mCartCount; i++)
            sum += mCart.mCartItem[i].getTotalPrice();

        System.out.println("\t\t\t총 주문 금액 : " + sum + "원\n");
        System.out.println("---------------------------------------------------");
        System.out.println();
    }

    public static void menuExit() {
        System.out.println("8. 종료");
    }

    public static boolean isCartInBook(String bookId) {
        /*
        boolean flag = false;
        for (int i = 0; i < mCartCount; i++) {
            if (bookId == mCartItem[i].getBookID()) {
                mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1); // 수량 증가
                flag = true;
            }
        }
        return flag;
        */
        return mCart.isCartInBook(bookId);
    }
    public static void menuAdminLogin() {
        System.out.println("관리자 정보를 입력하세요.");

        Scanner input = new Scanner(System.in);
        System.out.print("아이디 : ");
        String adminId = input.next();

        System.out.print("비밀번호 : ");
        String adminPw = input.next();

        Admin admin = new Admin(mUser.getName(), mUser.getPhone());
        if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())) {
            System.out.println("이름 : " + admin.getName() + ", 연락처: " + admin.getPhone());
            System.out.println("아이디 : " + admin.getId() + ", 비밀번호: " + admin.getPassword());
        }else
            System.out.println("관리자 정보가 일치하지 않습니다. 다시 시도해주세요.");
    }

    public static void BookList(Book[] booklist) {
        setFileToBookList(booklist);
        /*
        booklist[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000);
        booklist[0].setAuthor("송미영");
        booklist[0].setDescription("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
        booklist[0].setCategory("IT전문서");
        booklist[0].setReleaseDate("2018/10/08");

        booklist[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000);
        booklist[1].setAuthor("우재남");
        booklist[1].setDescription("실습 단계별 명쾌한 멘토링!");
        booklist[1].setCategory("IT전문서");
        booklist[1].setReleaseDate("2022/01/22");

        booklist[2] = new Book("ISBN1236", "스크래치", 22000);
        booklist[2].setAuthor("고광일");
        booklist[2].setDescription("컴퓨팅 사고력을 키우는 블록 코딩");
        booklist[2].setCategory("컴퓨터입문");
        booklist[2].setReleaseDate("2019/06/10");
        */
    }

    public static int totalFileToBookList() {
        try {
            FileReader fr = new FileReader("booklist.txt");
            BufferedReader reader = new BufferedReader(fr);

            String str;
            int num = 0;

            while ((str = reader.readLine()) != null) {
                String[] bookData = str.split(",");
                if (str.contains("ISBN"))
                    num++;
            }
            reader.close();
            fr.close();
            return num;
        }catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void setFileToBookList(Book[] booklist) {
        try {
            FileReader fr = new FileReader("book.txt");
            BufferedReader reader = new BufferedReader(fr);

            String str2;
            String[] readBook = new String[7];
            int count = 0;

            while ((str2 = reader.readLine()) != null) {
                if (str2.contains("ISBN")) {
                    readBook[0] = str2;
                    readBook[1] = reader.readLine(); // 책 제목
                    readBook[2] = reader.readLine(); // 가격
                    readBook[3] = reader.readLine(); // 저자
                    readBook[4] = reader.readLine(); // 설명
                    readBook[5] = reader.readLine(); // 카테고리
                    readBook[6] = reader.readLine(); // 출판일
                }

            booklist[count++] = new Book(readBook[0], readBook[1], Integer.parseInt(readBook[2]),
                    readBook[3], readBook[4], readBook[5], readBook[6]);
            } // while문 종료
            reader.close();
            fr.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}