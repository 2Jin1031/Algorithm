#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

static int changeUnit[6] = {500, 100, 50, 10, 5, 1};

int main(void) {
    int price; cin >> price;
    int change = 1000 - price;
   
    int resultCnt = 0;
    for (int i = 0 ; i < 6; i++) {
        resultCnt += change / changeUnit[i];
        change = change - (change / changeUnit[i]) * changeUnit[i];
    }
    cout << resultCnt;
}