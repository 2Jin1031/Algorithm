#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int main(void) {
    int num1, num2; 
    char comma;
    int T; cin >> T;
    for (int i = 0; i < T; i++) {
         cin >> num1 >> comma >> num2;
        cout << num1 + num2 << endl;
    }
}