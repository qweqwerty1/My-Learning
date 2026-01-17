#include<stdio.h>

void my_operator(int,int);

int main()
{
    int a = 0;
    int b = 0;
    printf("두 개의 수를 입력하시오. ");
    scanf("%d %d",&a,&b);
    my_operator(a,b);
    return 0;
}

void my_operator(int a, int b)
{
    printf("%d + %d = %d\n",a,b,a+b);
    printf("%d - %d = %d\n",a,b,a-b);
    printf("%d * %d = %d\n",a,b,a*b);
    printf("%d / %d = %d\n",a,b,a/b);
    printf("%d %% %d = %d",a,b,a%b);
}