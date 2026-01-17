#include<stdio.h>

int main()
{
    double a = 0;
    double b = 0;
    char c = 0;

    scanf("%lf",&a);
    scanf("%lf",&b);
    while(getchar() != '\n');
    scanf("%c",&c);
    printf("%.2f\n",a);
    printf("%.2f\n",b);
    printf("%c",c);
    return 0;
}