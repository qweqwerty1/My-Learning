#include<stdio.h>

void my_operator(int,int,int);

int main()
{
    int a = 0;
    int b = 0;
    int c = 0;
    scanf("%d %d %d",&a,&b,&c);
    my_operator(a,b,c);
    return 0;
}

void my_operator(int a, int b, int c)
{
    int sum = a+b+c;
    printf("sum : %d\n",sum);
    printf("avg : %d\n",sum/3);
}