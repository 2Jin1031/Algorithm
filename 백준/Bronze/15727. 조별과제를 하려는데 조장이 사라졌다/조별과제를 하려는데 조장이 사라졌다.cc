#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>

using namespace std;

int main(void) {
    int n; scanf("%d", &n);
    int result = n / 5;
    if (n % 5) result++;
    printf("%d", result);
}