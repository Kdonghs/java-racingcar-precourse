package Util;

import DTO.Car;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Util {

    Random random = new Random();

    // 자동차명 입력 확인
    // 중복여부 검사
    // 이름에는 공백을 포함할 수 없다.
    public void checkNames(String[] names) {
        Set<String> set = new HashSet<>();

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (!set.add(name)) {
                throw new IllegalArgumentException();
            }
            if (name.contains(" ")){
                throw new IllegalArgumentException();
            }
        }
    }

    // 시도횟수 검증
    // int 자료형 최대 크기를 넘지 않는다.
    public void isNumber(String number) {
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }

    }

    // 랜덤 넘버 생성
    public int generateRandomNumber() {
        return random.nextInt(10);
    }


    // 최대로 이동한 자동차명 반환
    public String[] printWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = cars.get(0).getNum();
        for (Car car : cars) {
            if (max == car.getNum()) {
                winner.add(car.getName());
                continue;
            }
            if (max < car.getNum()) {
                winner.clear();
                winner.add(car.getName());
                max = car.getNum();
            }
        }
        return winner.toArray(new String[0]);
    }

}