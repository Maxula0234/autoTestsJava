package constant;

import java.util.LinkedList;
import java.util.List;

public enum Month {
    €нвар€("JANUARY", 1),
    феврал€("FEBRUARY", 2),
    марта("MARCH", 3),
    апрел€("APRIL", 4),
    ма€("MAY", 5),
    июн€("JUNE", 6),
    июл€("JULY", 7),
    августа("AUGUST", 8),
    сент€бр€("SEPTEMBER", 9),
    окт€бр€("OCTOBER", 10),
    но€бр€("NOVEMBER", 11),
    декабр€("DECEMBER", 12);


    private final String month;
    private final int monthNumber;

    Month(String month, int monthNumber) {
        this.month = month;
        this.monthNumber = monthNumber;
    }

    public static int findMonth(String nameMonth) {
        if (nameMonth.contains("ќ дате старта будет объ€влено позже")) {
            return 990;
        }
        List<Month> list = new LinkedList<>();
        list.add(Month.€нвар€);
        list.add(Month.феврал€);
        list.add(Month.марта);
        list.add(Month.апрел€);
        list.add(Month.ма€);
        list.add(Month.июн€);
        list.add(Month.июл€);
        list.add(Month.августа);
        list.add(Month.сент€бр€);
        list.add(Month.окт€бр€);
        list.add(Month.но€бр€);
        list.add(Month.декабр€);

        Month first = list.stream()
                .filter(f -> f.name().contains(nameMonth))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("мес€ц не найден - " + nameMonth));
        return first.getMonthNumber();
    }

    public String getMonth() {
        return month;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
