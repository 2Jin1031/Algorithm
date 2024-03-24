#include <iostream>
#include <cmath>

using namespace std;

int visitOrder(int N, int r, int c) {
    if (N == 0)
        return 0;

    int size = pow(2, N - 1);
    int quadrant = 0;
    if (r >= size) {
        quadrant += 2;
        r -= size;
    }
    if (c >= size) {
        quadrant += 1;
        c -= size;
    }
    return quadrant * size * size + visitOrder(N - 1, r, c);
}

int main() {
    int N, r, c;
    cin >> N >> r >> c;

    cout << visitOrder(N, r, c) << endl;

    return 0;
}
