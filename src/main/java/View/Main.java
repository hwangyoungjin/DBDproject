package View;

import DAO.TestTBDAO;
import DAO.TestTBDAOImpl;
import VO.TestTBVO;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start!");
        TestTBDAO testTB = new TestTBDAOImpl();
        //testTB.getTestTB();
        //testTB.createTestTB();

        TestTBVO tb = new TestTBVO();
        //testTV 레코드 삽입
        for(int i=51; i<56; i++){
            tb.setId(i);
            tb.setValue((float)(i+0.1));
            testTB.createTestTB(tb);
        }

        System.out.println();
        //레코드 command 출력 (현재 조건 id>50)
        testTB.getTestTB();
    }
}
