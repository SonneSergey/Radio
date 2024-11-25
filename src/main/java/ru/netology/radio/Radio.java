package ru.netology.radio;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationCount;

    private final int MIN_VOLUME = 0;
    private final int MAX_VOLUME = 100;

    // Конструктор без параметров
    public Radio() {
        this.stationCount = 10; // Значение по умолчанию
    }

    // Конструктор с параметром
    public Radio(int stationCount) {
        this.stationCount = stationCount;
    }

    // Методы для работы с радиостанциями
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationCount) {
            this.currentStation = station;
        }
    }

    public void nextStation() {
        if (currentStation == stationCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == 0) {
            currentStation = stationCount - 1;
        } else {
            currentStation--;
        }
    }

    // Методы для работы с громкостью
    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume >= MIN_VOLUME && currentVolume <= MAX_VOLUME) {
            this.currentVolume = currentVolume;
        }
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
}