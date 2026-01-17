#include <stdio.h>

int main()
{
    const double x = 1.234;
    const double y = 10.3459;

    printf("%s\n","전체 7자리로 맞추고 소수 4자리까지 출력");
    printf("%s%7.4f\n","x = ",x);
    printf("%s%7.4f\n","y = ",y);
    printf("\n");
    printf("소수 2자리까지 출력(반올림)\n");
    printf("x = %.2f\n",x);
    printf("y = %.2f",y);
    return 0;
}