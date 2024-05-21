#include <iostream>
#include <locale>
#include <vector>
#include <algorithm>

using namespace std;

static vector<int> arr1;
static vector<int> arr2;

int main(void) {
    arr1.resize(4); arr2.resize(2);
    for (int i = 0; i < 4; i++) cin >> arr1[i];
    for (int i = 0; i < 2; i++) cin >> arr2[i];

    sort(arr1.begin(), arr1.end());
    sort(arr2.begin(), arr2.end());

    int result = 0;
    for (int i = 1; i < 4; i++) {
        result += arr1[i];
    } result += arr2[1];

    cout << result;
}