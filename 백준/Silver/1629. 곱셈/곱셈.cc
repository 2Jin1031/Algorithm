#include <string>
#include <cstring>
#include <iostream>
#include <algorithm>
#include <functional>
#include <queue>
#include <cmath>
#include <deque>
#include <stack>
#include <tuple>
#include <utility>
#include <climits>


// 1629
using namespace std;

int A, B, C;

long long fastExponentiation(int base, int exponent, int mod) {
    if (exponent == 0)
        return 1; 
    if (exponent == 1)
        return base % mod;
    
    long long half = fastExponentiation(base, exponent / 2, mod);
    long long result = (half * half) % mod;
    
    if (exponent % 2 != 0)
        result = (result * base) % mod;
    
    return result;
}

int main() {
    cin >> A >> B >> C;
    
    long long result = fastExponentiation(A, B, C);
    cout << result;
    
    return 0;
}