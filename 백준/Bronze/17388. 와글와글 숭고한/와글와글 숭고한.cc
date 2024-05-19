#include <iostream>
#include <cstdio>

using namespace std;

int main(void) {
    int arr[3]; 
    string str[3] = {"Soongsil", "Korea", "Hanyang"};
    for (int i = 0; i < 3; i++) 
        scanf("%d", &arr[i]);
    int min = arr[0];
    int idx = 0;
    for (int i = 1; i < 3; i++) { 
        if (arr[i] < min) {
            min = arr[i];
            idx = i;
        }
    }
    int result = 0;
    for (int i = 0; i < 3; i++) {
        result += arr[i];
    }

    if (result >= 100) {
        cout << "OK";
    }
    else {
        cout << str[idx];
    }
    return 0;
}