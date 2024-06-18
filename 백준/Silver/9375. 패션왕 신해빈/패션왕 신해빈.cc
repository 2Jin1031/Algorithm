#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

void ft_make_result(map<string, vector<string> >& costumeInfo) {
    int result = 1;
    for (const auto& it : costumeInfo) {
        result *= (it.second.size() + 1);
    }
    result--;
    cout << result << endl;
}

// name과 type을 입력 받아 map에 추가
void hasCostume(map<string, vector<string> >& costumeInfo) {
    string name, type;
    cin >> name >> type;

    if (costumeInfo.find(type) != costumeInfo.end()) {
        auto& names = costumeInfo[type];
        if (find(names.begin(), names.end(), name) == names.end()) {
            names.push_back(name);
        }
    } else {
        costumeInfo[type].push_back(name);
    }
}

void ft_input_costume(int n) {
    map<string, vector<string> > costumeInfo;
    for (int i = 0; i < n; i++) {
        hasCostume(costumeInfo);
    }
    ft_make_result(costumeInfo);
}

int main(void) {
    int T; cin >> T;
    for (int t = 0; t < T; t++) {
        int n; cin >> n;
        ft_input_costume(n);
    }

    return 0;
}