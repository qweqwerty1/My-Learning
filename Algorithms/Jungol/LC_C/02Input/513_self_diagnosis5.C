#include<stdio.h>

int main()
{
    double yd = 2.1;
    double in = 10.5;

    printf("%4.1fyd = %5.1fcm\n",yd,yd*91.44);
    printf("%4.1fin = %5.1fcm",in,in*2.54);
    return 0;
}