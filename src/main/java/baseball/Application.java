package baseball;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner14;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){   //큰 반복문 : 처음 숫자뽑기, 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            // for (Integer integer : computer) {
            //     System.out.print(integer);
            // }

            while(true){
                System.out.println("숫자를 입력해주세요 : ");
                String number =
                Console.readLine();

                if (!judge(number) ||number.length()!=3){
                    throw new IllegalArgumentException();
                }

                String[] array = number.split("");          // 숫자 자르기
                List<Integer> user = new ArrayList<>();
                for (int i = 0; i < array.length; i++) {
                    user.add(Integer.parseInt(array[i]));   //같은 자료형으로 변환
                }
                int st=0;
                int ball=0;

                for (int i = 0; i < 3; i++) {    //유저
                    for (int j = 0; j < 3; j++) {     //컴퓨터
                        if(user.get(i).equals(computer.get(j))) {
                            if (i==j) {
                                st=st+1;
                            }
                            else {
                                ball=ball+1;
                            }
                        }
                    }
                }
                if (st==3) {
                    System.out.println("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
                else if (st==0){
                    System.out.println(ball+"볼");
                }
                else if (st>0&&ball>0){
                    System.out.println(ball+"볼"+st+"스트라이크");
                }
                else {
                    System.out.println("낫싱");
                }
            }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String game = Console.readLine();
        if (game.equals("1")){
            continue;
        }
        else if (game.equals("2")){
            break;
        }
        else {
            throw new IllegalArgumentException();
        }
        }
    }
    public static Boolean judge(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}