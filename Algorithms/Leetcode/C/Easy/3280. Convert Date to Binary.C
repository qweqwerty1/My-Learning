#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* toBinary(int n) {
    char temp[32];
    int i = 0;

    while (n>0){
        temp[i++] = (n%2) + '0';
        n /= 2;
    }
    temp[i] = '\0';

    char* res = (char*)malloc(sizeof(char) * (i+1));
    for (int j = 0; j < i;j++) {
        res[j] = temp[i - 1 - j];
    }
    res[i] = '\0';

    return res;
}

char* convertDateToBinary(char* date) {
    int y, m, d;

    sscanf(date, "%d-%d-%d", &y, &m, &d);

    char* b_year = toBinary(y);
    char* b_month = toBinary(m);
    char* b_day = toBinary(d);

    char* result = (char*)malloc(sizeof(char) * 32);
    sprintf(result, "%s-%s-%s", b_year, b_month, b_day);

    free(b_day);
    free(b_month);
    free(b_year);

    return result;
}

int main() {
    char* date = "1994-01-04";
    char* result = convertDateToBinary(date);
    printf("%s",result);
    return 0;
}