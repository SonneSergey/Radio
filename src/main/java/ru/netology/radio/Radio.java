package ru.netology.radio;

public class Radio {

    private int currentStation;
    private int currentVolume;

    // Константы для минимальной и максимальной станции и громкости
    private final int MIN_STATION = 0;
    private final int MAX_STATION = 9;
    private final int MIN_VOLUME = 0;
    private final int MAX_VOLUME = 100;

    // Методы управления радиостанцией
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= MIN_STATION && station <= MAX_STATION) {
            this.currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == MAX_STATION) {
            currentStation = MIN_STATION;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == MIN_STATION) {
            currentStation = MAX_STATION;
        } else {
            currentStation--;
        }
    }

    // Методы управления громкостью
    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < MAX_VOLUME) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > MIN_VOLUME) {
            currentVolume--;
        }
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= 0 && currentVolume <= 100) {
            this.currentVolume = currentVolume;
        }
    }
}
