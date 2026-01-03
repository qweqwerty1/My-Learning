#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char* defangIPaddr(char* address){
    char* result = (char*)malloc(30);
    if (result == NULL) { return NULL; }
    int n = strlen(address);
    int cnt = 0;
    for (int i = 0;i < n;i++) {
        if (address[i] == '.') {
            memcpy(&result[i+cnt],"[.]",4);
            cnt += 2;
        }
        else {
            result[i+cnt] = address[i];
            result[i+cnt+1] = '\0';
        }
    }
    return result;
}

int main () {
    char* address = "121.233.55.231";
    char* result = defangIPaddr(address);
    printf("defangIPaddr : %s",result);
    free(result);
    return 0;
}