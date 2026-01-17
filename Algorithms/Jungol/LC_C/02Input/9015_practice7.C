#include <stdio.h>

int main()
{
    int a = 0;
    int b = 0;

    printf("두 수를 입력하시오. ");
    scanf("%d %d",&a,&b);
    printf("%d + %d = %d\n",a,b,a+b);
    printf("%d * %d = %d",a,b,a*b);
    
    return 0;
}