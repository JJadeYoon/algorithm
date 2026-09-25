#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int n = progresses.size();
    
    vector<int> days(n);
    
    for (int i = 0; i < n; i++) {
        days[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
    }
    
    int cur = days[0];
    int count = 1;
    
    for (int i = 1; i < n; i++) {
        if (days[i] <= cur) {
            count++;
        } else {
            answer.push_back(count);
            cur = days[i];
            count = 1;
        }
    }
    
    answer.push_back(count);
    
    return answer;
}