package constant;

import java.util.LinkedList;
import java.util.List;

public enum Month {
    ������("JANUARY", 1),
    �������("FEBRUARY", 2),
    �����("MARCH", 3),
    ������("APRIL", 4),
    ���("MAY", 5),
    ����("JUNE", 6),
    ����("JULY", 7),
    �������("AUGUST", 8),
    ��������("SEPTEMBER", 9),
    �������("OCTOBER", 10),
    ������("NOVEMBER", 11),
    �������("DECEMBER", 12);


    private final String month;
    private final int monthNumber;

    Month(String month, int monthNumber) {
        this.month = month;
        this.monthNumber = monthNumber;
    }

    public static int findMonth(String nameMonth) {
        if (nameMonth.contains("� ���� ������ ����� ��������� �����")) {
            return 990;
        }
        List<Month> list = new LinkedList<>();
        list.add(Month.������);
        list.add(Month.�������);
        list.add(Month.�����);
        list.add(Month.������);
        list.add(Month.���);
        list.add(Month.����);
        list.add(Month.����);
        list.add(Month.�������);
        list.add(Month.��������);
        list.add(Month.�������);
        list.add(Month.������);
        list.add(Month.�������);

        Month first = list.stream()
                .filter(f -> f.name().contains(nameMonth))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("����� �� ������ - " + nameMonth));
        return first.getMonthNumber();
    }

    public String getMonth() {
        return month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
