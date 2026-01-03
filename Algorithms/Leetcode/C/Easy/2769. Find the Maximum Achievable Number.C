# include <stdio.h>

int theMaximumAchievableX(int num, int t) {
    return num + 2 * t;
}

int main() {
    int num = 4;
    int t = 1;
    int result = theMaximumAchievableX(num, t);
    printf("Maximumachievablex : %d", result);
    return 0;
}