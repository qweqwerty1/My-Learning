#include<stdio.h>

int add(int n) {return n+3;}
int sub(int n) {return n-3;}
int mul(int n) {return n*3;}
int div(int n) {return (n != 0) ? n / 3 : 0;}
int mod(int n) {return (n != 0) ? n % 3 : 0;}

int general_operation(int n) {
    static int step = 0;

    int (*ops[])(int) = { add, sub, mul, div, mod };
    int num_ops = sizeof(ops) / sizeof(ops[0]);

    int result = ops[step % num_ops](n);

    step++;
    return result;
}

int main() {
    int inputs[5];
    printf("5개의 수를 입력하시오. ");
    for(int i = 0;i < 5;i++) {
        scanf("%d", &inputs[i]);
        printf("%d ",general_operation(inputs[i]));
    }
    return 0;
}