#include <stdio.h>

int main()
{
    double pi = 3.14;
    int r = 5;
    int n = 2;
    char* times = " * ";

    printf("%s%d%s%d%s%f%s%f\n","원주 = ",r,times,n,times,pi," = ",r*n*pi);
    printf("%s%d%s%d%s%f%s%f","넓이 = ",r,times,r,times,pi," = ",r*r*pi);

    return 0;
}