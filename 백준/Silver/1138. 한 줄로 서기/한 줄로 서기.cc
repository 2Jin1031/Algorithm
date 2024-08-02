#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;
    
    vector<int> L(N);
    for (int i = 0; i < N; ++i) {
        cin >> L[i];
    }

    vector<int> result(N, 0);

    for (int i = 0; i < N; ++i) {
        int tallerCount = L[i];
        int position = 0;
        

        for (int j = 0; j < N; ++j) {
            if (result[j] == 0) {
                if (tallerCount == 0) {
                    position = j;
                    break;
                }
                tallerCount--;
            }
        }


        result[position] = i + 1;
    }


    for (int i = 0; i < N; ++i) {
        cout << result[i] << " ";
    }
    cout << endl;

    return 0;
}