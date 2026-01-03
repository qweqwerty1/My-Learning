#include <stdio.h>
#include <stdlib.h>

double* convertTemperature(double celsius, int* returnSize) {
    double* result = (double*)malloc(2 * sizeof(double));
    if (result == NULL) { return NULL; }
    double kelvin = celsius + 273.15;
    double fahrenheit = celsius * 1.8 + 32;
    result[0] = kelvin;
    result[1] = fahrenheit;
    *returnSize = 2;
    return result;
}

int main() {
    double celsius = 122.11;
    int returnSize = 0;
    double* result = convertTemperature(celsius, &returnSize);
    printf("%f,%f",result[0],result[1]);

    free(result);
    return 0;
}