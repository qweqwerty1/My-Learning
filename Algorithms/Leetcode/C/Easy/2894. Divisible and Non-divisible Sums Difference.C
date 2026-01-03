#include <stdio.h>

int differenceOfSums(int n, int m) {
    int not_dvn = 0;
    int dvn = 0;

    for (int i = 1;i <= n;i++) {
        if (i % m == 0) { dvn += i; }
        else { not_dvn += i; }
    }

    return not_dvn - dvn;
}

int main() {
    int n = 10;
    int m = 3;
    int result = differenceOfSums(n, m);

    printf("differenceOfSums : %d",result);
    return 0;
}