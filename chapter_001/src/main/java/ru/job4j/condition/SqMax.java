package ru.job4j.condition;

public class SqMax {
    public  int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            result = third;
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            }
        } else if (second > third) {
            if (second > forth) {
                result = second;
            }
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}