#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring> // Include for strcmp
#include <queue>
#include <functional>
#include <algorithm>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

int main(void) {
    char score; char detail; scanf("%c%c", &score, &detail);
    double result = 0;
    if (score == 'A') result += 4;
    else if (score == 'B') result += 3;
    else if (score == 'C') result += 2;
    else if (score == 'D') result += 1;
    else result = 0;

    if(detail == '+') result += 0.3;
    else if (detail == '-') result -= 0.3;

    printf("%.1f", result);
}