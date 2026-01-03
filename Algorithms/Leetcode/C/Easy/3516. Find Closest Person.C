#include<stdio.h>
#include<math.h>

int findClosest(int x, int y, int z);

int main(){
    int x,y,z;
    printf("Person 1(x) value : ");
    scanf("%d",&x);
    printf("Person 2(y) value : ");
    scanf("%d",&y);
    printf("Person 3(z) value : ");
    scanf("%d",&z);
    int result = findClosest(x,y,z);
    printf("결과 값 : %d",result);
    return 0;
}

int findClosest(int x, int y, int z) {
    int p1Step = abs(x-z);
    int p2Step = abs(y-z);

    if(p1Step != p2Step) {
        return (p1Step<p2Step) ? 1 : 2;
    }
    else return 0;
}