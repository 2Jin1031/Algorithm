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

static int N;

int ft_login1(int N){
    int result = 0;
    for (int i = 1; i <= N; i++) {
        result += i;
    }
    return result;
}

int ft_login2(int N){
    int result = ft_login1(N);
    return result * result;
}

int ft_login3(int N){
    int result = 0;
    for (int i = 1; i <= N; i++) {
        result += i * i * i;
    }
    return result;
}

int main(void) {
    cin >> N;
    
    cout << ft_login1(N) << "\n";
    cout << ft_login2(N) << "\n";
    cout << ft_login3(N) << "\n";
}
