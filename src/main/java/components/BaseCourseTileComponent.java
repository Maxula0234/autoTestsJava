package components;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.LessonsBasePage;
import pages.SpecializationBasePage;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BaseCourseTileComponent extends BasePage<BaseCourseTileComponent> {
    private final By DATE_SPECIALIZATION_START = By.xpath(".//div[@class='lessons__new-item-time']");
    private final By NAME_COURSE = By.xpath(".//div[contains(@class,'lessons__new-item-title_with-bg')]");
    private final By DATE_LESSON_START = By.xpath(".//div[@class='lessons__new-item-start']");
    private final By PRICE = By.xpath(".//div[@class='lessons__new-item-price']");
    private List<WebElement> lessons;

    public BaseCourseTileComponent(WebDriver driver, List<WebElement> lessons) {
        super(driver);
        this.lessons = lessons;
    }

    public BaseCourseTileComponent sortedSpecializationByDate() {
        lessons = lessons.stream().sorted((o1, o2) -> {
            LocalDate date1 = getStartDateCourseV2(o1, DATE_SPECIALIZATION_START);
            LocalDate date2 = getStartDateCourseV2(o2, DATE_SPECIALIZATION_START);

            return date1.compareTo(date2);
        }).collect(Collectors.toList());
        return this;
    }

    public LessonsBasePage clickLessons(int numLesson) {
        lessons.get(numLesson).click();
        return new LessonsBasePage(driver);
    }

    public SpecializationBasePage clickSpecialization(int numLesson) {
        lessons.get(numLesson).click();
        return new SpecializationBasePage(driver);
    }


    private LocalDate getStartDateCourseV2(WebElement lesson, By dateStart) {

        Pattern pattern = Pattern.compile("\\d{2}\\s(.{3})");
        String date = lesson.findElement(dateStart).getText();
        Matcher matcher = pattern.matcher(date);

        DateFormatSymbols symbols = new DateFormatSymbols(new Locale("ru"));
        String[] shortestMonths = new String[]{"янв", "фев", "мар", "апр", "мая", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        symbols.setShortMonths(shortestMonths);

        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM", symbols);

        Date date1;
        try {
            if (matcher.find()) {
                date1 = formatter.parse(matcher.group());
            } else {
                return LocalDate.of(2099, 12, 1);
            }
        } catch (ParseException e) {
            return LocalDate.of(2099, 12, 1);
        }

        return date1.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate().withYear(LocalDate.now().getYear());
    }

    public Map<WebElement, LocalDate> parseDateFromTile(By dateStart) {
        Map<WebElement, LocalDate> map = new HashMap<>();

        lessons.forEach(f -> {
            LocalDate startDateCourseV2;
            try {
                startDateCourseV2 = getStartDateCourseV2(f, dateStart);
                map.put(f, startDateCourseV2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return map;
    }

    public void clickSpecializationAfterDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(DATE_SPECIALIZATION_START);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isAfter(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
    }

    public void clickSpecializationByDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(DATE_SPECIALIZATION_START);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isEqual(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
    }

    public LessonsBasePage goToLesson(int idLesson) {
        lessons.get(idLesson).click();
        return new LessonsBasePage(driver);
    }

    @Step("Получим урок {nameLesson}")
    public void clickLessonByName(String nameLesson) {
        WebElement webElement = lessons.stream()
                .filter(f -> f.getText().contains(nameLesson))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Урок с именем " + nameLesson + " не найден"));

        webElement.click();

        assertThat(webElement).as("Урок не найден").isNotNull();
    }

    public LessonsBasePage clickLessonByDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(DATE_LESSON_START);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isEqual(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
        return new LessonsBasePage(driver);
    }

    public LessonsBasePage clickLessonAfterDate(LocalDate date) {
        Map<WebElement, LocalDate> specializationAfterDate = parseDateFromTile(DATE_LESSON_START);

        specializationAfterDate.entrySet()
                .stream().filter(f -> f.getValue().isAfter(date))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден курс до даты - " + date.toString()))
                .getKey().click();
        return new LessonsBasePage(driver);
    }

    public WebElement getExpensivePrice() {
        Map<WebElement, Double> map = new HashMap<>();

        lessons.forEach(f -> {
            double priceLesson;
            try {
                priceLesson = Double.parseDouble(f.findElement(PRICE).getText().replace(" ₽", ""));
                map.put(f, priceLesson);
            } catch (Exception e) {
                reporter.info("Стоимость курса не найдена");
            }
        });


        Map.Entry<WebElement, Double> webElementDoubleEntry = map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new RuntimeException("НЕ НАЙДЕН САМЫЙ ДОРОГОЙ"));

        return webElementDoubleEntry.getKey();
    }
}
