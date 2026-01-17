#include <stdio.h>

int main()
{
    const int steel_weight = 49;
    const double gravity_ratio = 0.2683;

    printf("%d %s %f %s %f",steel_weight,"*",gravity_ratio,"=",steel_weight*gravity_ratio);

    return 0;
}