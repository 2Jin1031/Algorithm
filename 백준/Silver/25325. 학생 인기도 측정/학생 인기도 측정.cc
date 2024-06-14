#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <sstream>

using namespace std;

static vector<pair<string, int> > v;

bool compare(const pair<string, int>& a, const pair<string, int>& b) {
    if (a.second == b.second)
        return a.first < b.first;
    return a.second > b.second;
}

int main(void) {
    int N; cin >> N; v.resize(N, make_pair("", 0));

    cin.ignore();

    for (int i = 0; i < N; i++) {
        cin >> v[i].first;
    }

    cin.ignore();

    // login
    for (int i = 0; i < N; i++) {
        string input; getline(cin, input);
        stringstream inputs(input);
        string tmp;
        while (inputs>>tmp) {
            for (int j = 0; j < N; j++) {
                if (tmp == v[j].first) {
                    v[j].second++;
                    break;
                }
            }
        }
    }

    // sort
    sort(v.begin(), v.end(), compare);

    // print
    for (int i = 0; i < N; i++) {
        cout << v[i].first << " " << v[i].second << endl;
    }

    return 0;
}