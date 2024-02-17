#include <string>
#include <vector>
#include <algorithm>

using namespace std;
static int sortIdx;

int compare(vector<int> a, vector<int> b) {
    return (a[sortIdx] < b[sortIdx]);
}

int ft_2idx(string ext) {
    if (!ext.compare("code")) {
        return 0;
    }
    else if (!ext.compare("date")) {
        return 1;
    }
    else if (!ext.compare("maximum")) {
        return 2;
    }
    return 3;
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    int extIdx = ft_2idx(ext);
    sortIdx = ft_2idx(sort_by);
    
    // Main
    for (int i = 0; i < data.size(); i++) {
        if (data[i][extIdx] < val_ext) {
            answer.push_back(data[i]);
        }
    }
    
    // Sort
    sort(answer.begin(), answer.end(), compare);
    
    return answer;
}