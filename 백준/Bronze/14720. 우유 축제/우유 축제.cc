#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int ft_changeMilk (int milk) {
    milk++;
    return milk % 3;
}

int main(void) {
    int N; cin >> N;

    int milk = 0, shop;
    int result = 0;
    for (int i = 0; i < N; i++) {
        cin >> shop;
        if (milk == shop) {
            result++;
            milk = ft_changeMilk(milk);
        }
        
    }

    cout << result;
}