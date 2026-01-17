#include<stdio.h>

int main()
{
    double a = 0;
    double b = 0;
    printf("두 개의 실수를 입력하시오.\n");
    scanf("%lf",&a);
    scanf("%lf",&b);
    printf("x = %.2f\n",a);
    printf("y = %.2f",b);
    return 0;
}