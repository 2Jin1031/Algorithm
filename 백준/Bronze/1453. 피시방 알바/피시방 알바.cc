#include <iostream>
#include <vector>

using namespace std;

int main() {
    bool arr[101] = {false};

    int N; cin >> N;
    int result = 0;
    for (int i = 0; i < N; i++) {
        int seatNum; cin >> seatNum;
        if(arr[seatNum]) {
            result++;
        }
        arr[seatNum] = true;
    }

    cout << result << endl;
}