package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        Random random = new Random();
        String str;
        switch (random.nextInt(8)) {
            case (0) -> str = CERTAIN;
            case (1) -> str = DEFINITELY;
            case (2) -> str = MOST_LIKELY;
            case (3) -> str = OUTLOOK_GOOD;
            case (4) -> str = ASK_AGAIN_LATER;
            case (5) -> str = TRY_AGAIN;
            case (6) -> str = NO;
            case (7) -> str = VERY_DOUBTFUL;
            default -> str = null;
        };
        return str;
    }
}
