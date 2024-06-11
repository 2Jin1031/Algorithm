#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

static vector<pair<int, double> > vect;

bool compare(const pair<int, double>& a, const pair<int, double>& b) {
    if (a.second == b.second)
        return a.first < b.first;
    return a.second < b.second;
}

int main() {
    int N; 
    cin >> N; 
    vect.resize(N);

    int x, y, v;
    for (int i = 0; i < N; ++i) {
        cin >> x >> y >> v;
        vect[i] = make_pair(i + 1, sqrt(x * x + y * y) / v);
    }

    sort(vect.begin(), vect.end(), compare);

    for (int i = 0; i < N; ++i) {
        cout << vect[i].first << "\n";
    }

    return 0;
}