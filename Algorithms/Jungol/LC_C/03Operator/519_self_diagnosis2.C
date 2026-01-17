#include<stdio.h>

int add(int n) { return n += 100; }
int mod(int n) { return (n != 0) ? n%10 : 0;}

int general_operation(int n) {
    static int step = 0;

    int (*ops[])(int) = { add, mod };
    int num_ops = sizeof(ops) / sizeof(ops[0]);

    int result = ops[step % num_ops](n);

    step++;
    return result;
}

int main() {
    int a = 0;
    int b = 0;
    scanf("%d %d",&a,&b);
    int res1 = general_operation(a);
    int res2 = general_operation(b);
    printf("%d %d",res1,res2);
    return 0;
}