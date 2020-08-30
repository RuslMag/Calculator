public class RomanToNumber extends NumberToRoman {
//Класс для преобразования римских цифр в числа

    //Эта функция возвращает значение римского символа.
    int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    /*
    Метод находит десятичное значение заданной римской цифры
    и возвращает результат
    */
    int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int num1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int num2 = value(str.charAt(i + 1));
                if (num1 >= num2) {
                    res = res + num1;
                } else {
                    res = res + num2 - num1;
                    i++;
                }
            } else {
                res = res + num1;
                i++;
            }
        }
        return res;
    }

}
